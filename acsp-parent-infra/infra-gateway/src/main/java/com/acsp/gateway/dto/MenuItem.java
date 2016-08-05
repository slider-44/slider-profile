package com.acsp.gateway.dto;


public class MenuItem {
  
  private String name;
  
  private String module;
  
  private String icon;
  
  private boolean read;
  
  private boolean write;

  
  public String getName() {
  
    return name;
  }

  
  public void setName(String name) {
  
    this.name = name;
  }

  
  public String getModule() {
  
    return module;
  }

  
  public void setModule(String module) {
  
    this.module = module;
  }

  
  public String getIcon() {
  
    return icon;
  }

  
  public void setIcon(String icon) {
  
    this.icon = icon;
  }

  
  public boolean isRead() {
  
    return read;
  }

  
  public void setRead(boolean read) {
  
    this.read = read;
  }

  
  public boolean isWrite() {
  
    return write;
  }

  
  public void setWrite(boolean write) {
  
    this.write = write;
  }
  

}
