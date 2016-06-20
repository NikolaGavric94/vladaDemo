package com.demo.vlada.dao;

import java.util.List;

import com.demo.vlada.entities.FileE;

public interface FileDao {
	public void saveOrUpdate(FileE file);
	public List<FileE> getFiles();
}
