package org.tarena.entity;

public class AbstractUser implements java.io.Serializable{
	/**test
	CREATE TABLE d_user (
	  id int(12) NOT NULL auto_increment,
	  name varchar(50) default NULL,
	  password varchar(50) NOT NULL,
	  PRIMARY KEY  (id)
	);
	 */
	private static final long serialVersionUID = 1L;
		private int id;
		private String name;
		private String password;
		public String getPassword() {
			return password;
		}
		public AbstractUser() {
		}
		
		public AbstractUser(String name, String password) {
			super();
			this.name = name;
			this.password = password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public static long getSerialversionuid() {
			return serialVersionUID;
		}
	
		
}
