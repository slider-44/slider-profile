package com.acsp.gateway.repository;

import com.acsp.gateway.dto.Menu;

import java.util.List;

public interface MenuRepository {

  List<Menu> retrieveUserMenuPermission(String userCd);
  
}
