package com.web.category.dto;

public class CategoryDto {
  int id;
  String name;
  String discription;
  
  public int getId() {
    return id;
  }
  public void setId(int id) {
    this.id = id;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public String getDiscription() {
    return discription;
  }
  public void setDiscription(String discription) {
    this.discription = discription;
  }
  
  public CategoryDto() {}
  
  // header menu
  public CategoryDto(int id, String name) {
    this.id = id;
    this.name = name;
  }
  
  public CategoryDto(int id, String name, String discription) {
    this.id = id;
    this.name = name;
    this.discription = discription;
  }
  
}
