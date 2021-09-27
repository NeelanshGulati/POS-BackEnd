package com.nagarro.repository;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.nagarro.model.User;
import com.nagarro.utils.HibernateUtil;

@Repository
public class UserRepository {
	public List<User> getUsers() {
		List<User> userList = null;

		Session session = HibernateUtil.getSessionInstance();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			Query query = session.createQuery("from User");
			userList = query.list();
			tx.commit();
		} catch (Exception ex) {
			if (tx != null) {
				tx.rollback();
			}
			System.out.println(ex);
		} finally {
			session.close();
		}

		return userList;
	}
	
	public User getUser(String name) {
		Session session = HibernateUtil.getSessionInstance();
		Transaction tx = null;
		User user = null;

		try {
			tx = session.beginTransaction();
			System.out.println("Selecting user begins--------------");
			Query q = session.createQuery("from User where username = '" + name + "'");
			user = (User) q.uniqueResult();
			tx.commit();
		} catch (Exception ex) {
			if (tx != null) {
				tx.rollback();
			}
			System.out.println(ex);
		} finally {
			session.close();
		}

		return user;
	}
}
