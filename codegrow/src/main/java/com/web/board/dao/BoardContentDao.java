package com.web.board.dao;

public class BoardContentDao {
  private static BoardContentDao instance = new BoardContentDao();

  public static BoardContentDao getInstance() {
    return instance;
  }
}
