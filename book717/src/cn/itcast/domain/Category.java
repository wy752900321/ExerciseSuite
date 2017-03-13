package cn.itcast.domain;

/**
 * 	处理图书分类的javabean
 * @author soft01
 *
 */
public class Category {
		private String id;
		private String name;
		private String description;
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		
}
/*
  		--图书类别表
CREATE TABLE category
(
   id VARCHAR(40) PRIMARY KEY,
   NAME VARCHAR(40) NOT NULL UNIQUE,  #分类名称
   description VARCHAR(255)           #分类描述
);

 */
 