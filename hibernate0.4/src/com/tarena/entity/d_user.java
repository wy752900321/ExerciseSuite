package com.tarena.entity;
// default package



/**
 * d_user entity. @author MyEclipse Persistence Tools
 */
public class d_user extends Abstractd_user implements java.io.Serializable {

    // Constructors

    /** default constructor */
    public d_user() {
    }

	/** minimal constructor */
    public d_user(Integer id, String email, String password, Integer userIntegral) {
        super(id, email, password, userIntegral);        
    }
    
    /** full constructor */
    public d_user(Integer id, String email, String nickname, String password, Integer userIntegral, String isEmailVerify, String emailVerifyCode, Long lastLoginTime, String lastLoginIp) {
        super(id, email, nickname, password, userIntegral, isEmailVerify, emailVerifyCode, lastLoginTime, lastLoginIp);        
    }
   
}
