package com.friend.system.manger.cn.bean;

import java.io.Serializable;

public class Concern implements Serializable{

	private static final long serialVersionUID = 1920692461763708293L;
	private long id;
	private Team team;
	private Friend friend;
	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}
	/**
	 * @return the team
	 */
	public Team getTeam() {
		return team;
	}
	/**
	 * @param team the team to set
	 */
	public void setTeam(Team team) {
		this.team = team;
	}
	/**
	 * @return the friend
	 */
	public Friend getFriend() {
		return friend;
	}
	/**
	 * @param friend the friend to set
	 */
	public void setFriend(Friend friend) {
		this.friend = friend;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Concern)) {
			return false;
		}
		Concern other = (Concern) obj;
		if (id != other.id) {
			return false;
		}
		return true;
	}
}
