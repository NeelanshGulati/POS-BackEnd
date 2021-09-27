package com.nagarro.repository;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.nagarro.model.Product;
import com.nagarro.utils.HibernateUtil;

@Repository
public class ProductRepository {
	public List<Product> getProducts() {
		List<Product> productList = null;

		Session session = HibernateUtil.getSessionInstance();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			Query query = session.createQuery("from Product");
			productList = query.list();
			tx.commit();
		} catch (Exception ex) {
			if (tx != null) {
				tx.rollback();
			}
			System.out.println(ex);
		} finally {
			session.close();
		}

		return productList;
	}

	public Product getProduct(int productId) {
		Session session = HibernateUtil.getSessionInstance();
		Transaction tx = null;
		Product product = null;

		try {
			tx = session.beginTransaction();
			Query q = session.createQuery("from Product where id = '" + productId + "'");
			product = (Product) q.uniqueResult();
			tx.commit();
		} catch (Exception ex) {
			if (tx != null) {
				tx.rollback();
			}
			System.out.println(ex);
		} finally {
			session.close();
		}

		return product;

	}

	public void addProduct(Product product) {
		Session session = HibernateUtil.getSessionInstance();

		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			session.save(product);
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

	public void updateProduct(Product product) {
		Session session = HibernateUtil.getSessionInstance();

		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			session.update(product);
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

	public Product deleteProduct(int productId) {
		Session session = HibernateUtil.getSessionInstance();
		Transaction tx = null;
		Product product = null;

		try {
			tx = session.beginTransaction();
			product = getProduct(productId);
			session.delete(product);
			tx.commit();
		} catch (Exception ex) {
			if (tx != null) {
				tx.rollback();
			}
			System.out.println(ex);
		} finally {
			session.close();
		}

		return product;
	}
	
	public int totalProducts() {
		return getProducts().size();
	}
}