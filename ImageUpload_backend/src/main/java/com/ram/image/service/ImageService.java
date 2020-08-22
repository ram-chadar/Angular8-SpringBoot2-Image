package com.ram.image.service;

import java.io.Serializable;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ram.image.model.Image;

@Service
@Transactional
public class ImageService {
	
	@Autowired
	private SessionFactory sf;
	
	public Serializable save(Image image) {
		Session session= sf.getCurrentSession();
		Serializable image2=session.save(image);
		return image2;
	}
	
	public Image findByName(String name)
	{
		Session session= sf.getCurrentSession();
		Query q=session.createQuery("FROM Image WHERE name=:name");
		q.setParameter("name", name);
		return (Image) q.uniqueResult();
		
	}

}
