package com.acsp.gateway.config;

import com.acsp.common.security.ACSPUser;
import com.acsp.gateway.dto.SimpleACSPUser;
import com.acsp.gateway.service.MenuService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public class WebURLSecurity {

  private static final Logger logger = LoggerFactory.getLogger(WebURLSecurity.class);

  @Autowired
  private MenuService menuService;

  /**
   * Checks the URL.
   * 
   * @param authentication current authenticated user
   * @param request Current servlet request instance
   * @return true if with access, false otherwise.
   */
  public boolean checkURL(Authentication authentication, HttpServletRequest request) {

    String requestURI = request.getRequestURI();
    logger.info("Context Path: " + requestURI);
    logger.info("Principal Class: " + authentication.getPrincipal().getClass().getSimpleName());

    if ( authentication.getPrincipal() instanceof ACSPUser ) {

      SimpleACSPUser acspUser = new SimpleACSPUser((ACSPUser) authentication.getPrincipal());

      menuService.retrieveMenuPermission(acspUser);

      WithAccess withAccess = new WithAccess();

      acspUser.getMenus()
              .forEach(menu -> {

                menu.getMenuItems()
                    .forEach(menuItem -> {

                      String path = "/" + menu.getProject() + "/" + menuItem.getModule();
                      logger.info(path + " with read access? " + menuItem.isRead());

                      if ( requestURI.startsWith(path) ) {
                        withAccess.read = menuItem.isRead();
                      }

                    });

              });

      return withAccess.read;

    } else {

      return false;
      
    }

  }
  
  
  private static class WithAccess {
    
    private boolean read = false;
    
  }
  
}
