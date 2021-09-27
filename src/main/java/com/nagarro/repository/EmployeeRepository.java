package com.nagarro.repository;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.nagarro.model.Employee;
import com.nagarro.utils.HibernateUtil;

@Repository
public class EmployeeRepository {

	public List<Employee> getEmployees() {
		List<Employee> employeeList = null;

		Session session = HibernateUtil.getSessionInstance();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			Query query = session.createQuery("from Employee");
			employeeList = query.list();
			tx.commit();
		} catch (Exception ex) {
			if (tx != null) {
				tx.rollback();
			}
			System.out.println(ex);
		} finally {
			session.close();
		}

		return employeeList;
	}

	public Employee getEmployee(int employeeCode) {
		Session session = HibernateUtil.getSessionInstance();
		Transaction tx = null;
		Employee employee = null;

		try {
			tx = session.beginTransaction();
			Query q = session.createQuery("from Employee where employeeCode = '" + employeeCode + "'");
			employee = (Employee) q.uniqueResult();
			tx.commit();
		} catch (Exception ex) {
			if (tx != null) {
				tx.rollback();
			}
			System.out.println(ex);
		} finally {
			session.close();
		}

		return employee;

	}

	public void addEmployee(Employee employee) {
		Session session = HibernateUtil.getSessionInstance();

		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			session.save(employee);
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

	public void updateEmployee(Employee employee) {
		Session session = HibernateUtil.getSessionInstance();

		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			session.update(employee);
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

	public Employee deleteEmployee(int employeeCode) {
		Session session = HibernateUtil.getSessionInstance();
		Transaction tx = null;
		Employee employee = null;

		try {
			tx = session.beginTransaction();
			employee = getEmployee(employeeCode);
			session.delete(employee);
			tx.commit();
		} catch (Exception ex) {
			if (tx != null) {
				tx.rollback();
			}
			System.out.println(ex);
		} finally {
			session.close();
		}

		return employee;
	}
	
	public int totalEmployee() {
		List<Employee> employeeList=getEmployees();
		
		return employeeList.size();
	}
}