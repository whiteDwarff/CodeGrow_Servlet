package com.web.board.dto;

import java.util.Date;

// 게시글 DTO
public class AuthDto {
  private int id;
  private String title;
  private String content;
  private int author_id; // 작성자의 primary key
  private Date created_at;
  private int hit;
  
  // ahthor_id를 통해 작성자의 이름을 가져오기 위함 
  private String name;

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
  public String getContent() {
    return content;
  }
  public void setContent(String content) {
    this.content = content;
  }
  public int getAuthor_id() {
    return author_id;
  }
  public void setAuthor_id(int author_id) {
    this.author_id = author_id;
  }
  public Date getCreated_at() {
    return created_at;
  }
  public void setCreated_at(Date created_at) {
    this.created_at = created_at;
  }
  public int getHit() {
    return hit;
  }
  public void setHit(int hit) {
    this.hit = hit;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.title = name;
  }
  
  public AuthDto() { }
  
  public AuthDto(String title, String content, int author_id) {
    this.title = title;
    this.content = content;
    this.author_id = author_id;
  }
  
  public AuthDto(int id, String title, String content, int author_id, Date created_at, int hit, String name) {
    this.id = id;
    this.title = title;
    this.content = content;
    this.author_id = author_id;
    this.created_at = created_at;
    this.hit = hit;
    this.name = name;
  }
}
