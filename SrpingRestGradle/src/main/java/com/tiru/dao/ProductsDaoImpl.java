package com.tiru.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import com.tiru.domain.Products;

@Repository
public class ProductsDaoImpl implements ProductsDao {

	private static SessionFactory sessionFactory;

	static {
		sessionFactory = new Configuration().configure().buildSessionFactory();
	}

	public List<Products> getAll() {
		Session session = sessionFactory.openSession();

		// HQL Queries
		return session.createQuery("From Products").list();
	}

	public void create(Products prd) {
		Session session = sessionFactory.openSession();
		session.getTransaction().begin();
		session.save(prd);
		session.getTransaction().commit();

	}

	@Override
	public Products getProduct(Long id) {
		Session session = sessionFactory.openSession();
		return (Products) session.get(Products.class, id);
	}

}
