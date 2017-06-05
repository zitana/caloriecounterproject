package com.greenfoxacademy.calorie.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Response {
  private String status;

  public Response() {
  }

  public Response(String status) {
    this.status = status;
  }
}
