package com.acsp.gateway.service;

import com.acsp.gateway.dto.Menu;
import com.acsp.gateway.dto.SimpleACSPUser;
import com.acsp.gateway.repository.MenuRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class MenuServiceImpl implements MenuService {

  @Autowired
  MenuRepository menuRepository; 
  

  @Override
  public void retrieveMenuPermission(SimpleACSPUser acspUser) {

    List<Menu> menus = menuRepository.retrieveUserMenuPermission(acspUser.getUserCd());
    
    acspUser.setMenus(menus);

  }

}
