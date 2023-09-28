package com.web.board.dto;

import java.util.Date;

// 댓글 DTO
public class ContentDto {
  private int id;
  private String content;
  private int post_id;   // 게시글의 primary key
  private int author_id; // 작성자의 primary key
  private Date created_at;
  private String name;
  public int getId() {
    return id;
  }
  public void setId(int id) {
    this.id = id;
  }
  public String getContent() {
    return content;
  }
  public void setContent(String content) {
    this.content = content;
  }
  public int getPost_id() {
    return post_id;
  }
  public void setPost_id(int post_id) {
    this.post_id = post_id;
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
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public ContentDto() {
    // TODO Auto-generated constructor stub
  }
  public ContentDto(int id, String content, Date created_at, String name) {
    this.id = id;
    this.content = content;
    this.created_at = created_at;
    this.name = name;
  }
  public ContentDto(int id, String content, int post_id, int author_id, Date created_at, String name) {
    this.id = id;
    this.content = content;
    this.post_id = post_id;
    this.author_id = author_id;
    this.created_at = created_at;
    this.name = name;
  }

}
