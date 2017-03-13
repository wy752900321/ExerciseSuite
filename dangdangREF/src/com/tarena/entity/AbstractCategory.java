package com.tarena.entity;

import java.io.Serializable;

public abstract class AbstractCategory implements Serializable {

	private static final long serialVersionUID = 1L;

	public AbstractCategory() {

	}

	private Integer id;
	private Integer turn;// 显示顺序(*)
	private String enName;// 英文名字
	private String name;// 中文名字
	private String description;// 种类描述(*)
	private Integer parentId;// 父类项

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getTurn() {
		return turn;
	}

	public void setTurn(Integer turn) {
		this.turn = turn;
	}

	public String getEnName() {
		return enName;
	}

	public void setEnName(String enName) {
		this.enName = enName;
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

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

}
