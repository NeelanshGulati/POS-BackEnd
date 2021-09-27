package com.nagarro.repository;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nagarro.model.Orders;
import com.nagarro.utils.HibernateUtil;

public class OrderRepository {
	public int totalOrders() {
		List<Orders> ordersList = getOrders();

		return ordersList.size();
	}

	public void addOrder(Orders order) {
		Session session = HibernateUtil.getSessionInstance();

		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			session.save(order);
			tx.commit();
		} catch (Exception ex) {
			if (tx != null) {
				tx.rollback();
			}
			System.out.println(ex);
		} finally {
			session.close();
		}
	}

	public List<Orders> getOrders() {
		List<Orders> ordersList = null;

		Session session = HibernateUtil.getSessionInstance();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			Query query = session.createQuery("from Orders");
			ordersList = query.list();
			tx.commit();
		} catch (Exception ex) {
			if (tx != null) {
				tx.rollback();
			}
			System.out.println(ex);
		} finally {
			session.close();
		}

		return ordersList;
	}
}
