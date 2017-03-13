package dao;

import java.util.List;

import pojo.Picture;

public interface PictureDAO {
	public void save(Picture picture);
	public List<Picture> findByUserId(Long id);
}
