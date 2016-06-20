package com.demo.vlada.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.demo.vlada.dao.FileDao;
import com.demo.vlada.entities.FileE;

@Repository
public class FileDaoImpl implements FileDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public void saveOrUpdate(FileE file) {
		sessionFactory.getCurrentSession().saveOrUpdate(file);
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<FileE> getFiles() {
		return (List<FileE>)sessionFactory.getCurrentSession().createCriteria(FileE.class).list();
	}

}
