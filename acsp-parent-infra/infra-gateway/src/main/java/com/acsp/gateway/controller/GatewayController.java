package com.acsp.gateway.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class GatewayController {

  
  /**
   * 
   * @param request Autowired HttpServletRequest instance.
   * @return Template location or a redirect command.
   */
  @RequestMapping(value = "/signin")
  public String signin(HttpServletRequest request) {

    return request.isUserInRole("ROLE_USER") ? "redirect:/"
                                             : "signin";
  }



  /**
   * 
   * @return Template location or a redirect command.
   */
  @RequestMapping(value = "/invalidSession")
  public String invalidSession() {

    return "redirect:/signin";
  }

}
