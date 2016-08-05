package com.acsp.gateway.controller;

import com.acsp.common.security.ACSPUser;
import com.acsp.gateway.dto.SimpleACSPUser;
import com.acsp.gateway.service.MenuService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GatewayRestController {


  @Autowired
  MenuService menuService;

  /**
   * 
   * @param acspUser Autowired ACSPUser instance of the current user.
   * @return JSON serialized SimpleACSPUser instance of the current user.
   */
  @RequestMapping(value = "/user")
  public SimpleACSPUser user(@AuthenticationPrincipal ACSPUser acspUser) {

    if ( acspUser == null ) {

      return null;
    }

    SimpleACSPUser simpleAcspUser = new SimpleACSPUser(acspUser);
    
    menuService.retrieveMenuPermission(simpleAcspUser);

    return simpleAcspUser;
  }

}
