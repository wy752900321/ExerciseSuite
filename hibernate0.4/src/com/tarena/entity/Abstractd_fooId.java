package com.tarena.entity;
// default package

import java.util.Date;


/**
 * Abstractd_fooId entity provides the base persistence definition of the d_fooId entity. @author MyEclipse Persistence Tools
 */

public abstract class Abstractd_fooId  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String name;
     private Date birthday;


    // Constructors

    /** default constructor */
    public Abstractd_fooId() {
    }

    
    /** full constructor */
    public Abstractd_fooId(Integer id, String name, Date birthday) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
    }

   
    // Property accessors

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return this.birthday;
    }
    
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
   



   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof Abstractd_fooId) ) return false;
		 Abstractd_fooId castOther = ( Abstractd_fooId ) other; 
         
		 return ( (this.getId()==castOther.getId()) || ( this.getId()!=null && castOther.getId()!=null && this.getId().equals(castOther.getId()) ) )
 && ( (this.getName()==castOther.getName()) || ( this.getName()!=null && castOther.getName()!=null && this.getName().equals(castOther.getName()) ) )
 && ( (this.getBirthday()==castOther.getBirthday()) || ( this.getBirthday()!=null && castOther.getBirthday()!=null && this.getBirthday().equals(castOther.getBirthday()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getId() == null ? 0 : this.getId().hashCode() );
         result = 37 * result + ( getName() == null ? 0 : this.getName().hashCode() );
         result = 37 * result + ( getBirthday() == null ? 0 : this.getBirthday().hashCode() );
         return result;
   }   





}