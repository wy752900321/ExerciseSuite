package org.tarena.entity.ext;

import org.tarena.entity.AbstractUser;

public class User extends AbstractUser{
	
	private static final long serialVersionUID = 1L;

	public User(){
		
	}

	public User(String name, String password) {
		super(name, password);
	}
	
}	
