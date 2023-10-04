package com.web.video.dto;

import java.util.Date;

public class VideoDto {
  private int id;
  private String title;
  private String description;
  private String url;
  private Date uploaded_at;
  private int category_id;
  private int hit;
  public int getId() {
    return id;
  }
  public void setId(int id) {
    this.id = id;
  }
  public String getTitle() {
    return title;
  }
  public void setTitle(String title) {
    this.title = title;
  }
  public String getDescription() {
    return description;
  }
  public void setDescription(String description) {
    this.description = description;
  }
  public String getUrl() {
    return url;
  }
  public void setUrl(String url) {
    this.url = url;
  }
  public Date getUploaded_at() {
    return uploaded_at;
  }
  public void setUploaded_at(Date uploaded_at) {
    this.uploaded_at = uploaded_at;
  }
  public int getCategory_id() {
    return category_id;
  }
  public void setCategory_id(int category_id) {
    this.category_id = category_id;
  }
  public int getHit() {
    return hit;
  }
  public void setHit(int hit) {
    this.hit = hit;
  }
 
  
  public VideoDto() {};
  
  // education에서 사용할 sub menu
  public VideoDto(int id, String title, String description, String url, int category_id) {
    this.id = id;
    this.title = title;
    this.description = description;
    this.url = url;
    this.category_id = category_id;
  }
  public VideoDto(int id, String title, String description, String url, Date uploaded_at, int category_id) {
    this.id = id;
    this.title = title;
    this.description = description;
    this.url = url;
    this.uploaded_at = uploaded_at;
    this.category_id = category_id;
  }
  public VideoDto(int id, String title, String description, String url, Date uploaded_at, int category_id, int hit) {
    this.id = id;
    this.title = title;
    this.description = description;
    this.url = url;
    this.uploaded_at = uploaded_at;
    this.category_id = category_id;
    this.hit = hit;
  }
  

}
