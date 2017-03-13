package com.tarena.elts.entity;

//entity 实体, 就是业务范畴中的具体名词
import java.io.Serializable;

public class User implements Serializable {
  private int id;
  private String passwd;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getPasswd() {
    return passwd;
  }

  public void setPasswd(String passwd) {
    this.passwd = passwd;
  }

}
