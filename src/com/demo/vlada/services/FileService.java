package com.demo.vlada.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.vlada.dao.FileDao;
import com.demo.vlada.entities.FileE;

@Service
public class FileService {
	@Autowired
	private FileDao fileDao;
	
	public void saveOrUpdate(FileE file) {
		fileDao.saveOrUpdate(file);
	}
	
	public List<FileE> getFiles() {
		return fileDao.getFiles();
	}
	
	public FileE getFileById(Integer id) {
		return fileDao.getFileById(id);
	}
	
	public Boolean isFile(FileE file) {
		return fileDao.isFile(file);
	}
	
	public void remove(FileE file) {
		fileDao.remove(file);
	}
}