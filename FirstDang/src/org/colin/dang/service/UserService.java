package org.colin.dang.service;

import java.io.InputStream;

import org.colin.dang.pojo.User;

public interface UserService {
 public void register(User user) throws Exception;
 public String loginCheckEmail(String email,String ip)throws Exception;
 public boolean checkEmail(String email)throws Exception;
 public boolean emailVerifyCode(String errorTxt,String email)throws Exception;
}
