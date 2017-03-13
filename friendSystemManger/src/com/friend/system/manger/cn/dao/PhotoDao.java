package com.friend.system.manger.cn.dao;

import java.util.List;

import com.friend.system.manger.cn.bean.Photo;

public interface PhotoDao {
	/**
	 * 将一张照片 保存到数据库  和用户关联
	 * 连接数据库失败 抛出异常
	 * @param photo
	 */
	void save(Photo photo);
	/**
	 * 查看某 联系人的图片 
	 * @param friendId
	 * @param start 
	 * @param count 
	 * @return
	 */
	List<Photo> findPhotosByUserId(long friendId, int count, int start);
	/**
	 * 根据photo 的 id  删除 一张 图片
	 * @param id
	 */
	Photo deletePhoto(long id);
	/**
	 * 查找  照片的数目
	 * @param friendId
	 * @return
	 */
	int photoCount(long friendId);
}
