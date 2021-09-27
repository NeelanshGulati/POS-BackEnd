package com.nagarro.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static SessionFactory sf;

	public static Session getSessionInstance() {
		sf = new Configuration().configure().buildSessionFactory();
		return sf.openSession();
	}
}
