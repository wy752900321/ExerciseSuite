package com.tarena.entity;
// default package



/**
 * Abstractd_foo entity provides the base persistence definition of the d_foo entity. @author MyEclipse Persistence Tools
 */

public abstract class Abstractd_foo  implements java.io.Serializable {


    // Fields    

     private d_fooId id;


    // Constructors

    /** default constructor */
    public Abstractd_foo() {
    }

    
    /** full constructor */
    public Abstractd_foo(d_fooId id) {
        this.id = id;
    }

   
    // Property accessors

    public d_fooId getId() {
        return this.id;
    }
    
    public void setId(d_fooId id) {
        this.id = id;
    }
   








}