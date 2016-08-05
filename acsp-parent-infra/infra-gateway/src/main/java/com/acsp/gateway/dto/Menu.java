package com.acsp.gateway.dto;

import java.util.List;

public class Menu {

  private String name;

  private String icon;

  private String project;

  private List<MenuItem> menuItems;
  
  private Short displayOrder;


  public String getName() {

    return name;
  }



  public void setName(String name) {

    this.name = name;
  }



  public String getIcon() {

    return icon;
  }



  public void setIcon(String icon) {

    this.icon = icon;
  }



  public String getProject() {

    return project;
  }



  public void setProject(String project) {

    this.project = project;
  }


  public List<MenuItem> getMenuItems() {

    return menuItems;
  }


  public void setMenuItems(List<MenuItem> menuItems) {

    this.menuItems = menuItems;
  }

    
  public Short getDisplayOrder() {
  
    return displayOrder;
  }

  
  public void setDisplayOrder(Short displayOrder) {
  
    this.displayOrder = displayOrder;
  }


  @Override
  public int hashCode() {

    final int prime = 31;
    int result = 1;
    result = prime * result + ((name == null) ? 0
                                              : name.hashCode());
    return result;
  }



  @Override
  public boolean equals(Object obj) {

    if ( this == obj ) {
      return true;
    }
    if ( obj == null ) {
      return false;
    }
    if ( getClass() != obj.getClass() ) {
      return false;
    }
    Menu other = (Menu) obj;
    if ( name == null ) {
      if ( other.name != null ) {
        return false;
      } 
    } else if ( !name.equals(other.name) ) {
      return false;
    } 
    return true;
  }

}
