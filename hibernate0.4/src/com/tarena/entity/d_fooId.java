package com.tarena.entity;
// default package

import java.util.Date;


/**
 * d_fooId entity. @author MyEclipse Persistence Tools
 */
public class d_fooId extends Abstractd_fooId implements java.io.Serializable {

    // Constructors

    /** default constructor */
    public d_fooId() {
    }

    
    /** full constructor */
    public d_fooId(Integer id, String name, Date birthday) {
        super(id, name, birthday);        
    }
   
}
