package com.greatlearning.dao;

import java.util.List;



import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.greatlearning.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	private SessionFactory sessionFactory;
	private Session session;

	public CustomerDAOImpl(SessionFactory sessionFactory) {
		// TODO Auto-generated constructor stub
		this.sessionFactory = sessionFactory;
		try {
			session = sessionFactory.getCurrentSession();
		} catch (HibernateException e) {
			// TODO: handle exception
			session = sessionFactory.openSession();
		}
	}

	@Override
	public List<Customer> findAll() {
		// TODO Auto-generated method stub

		Transaction transaction = session.beginTransaction();
		List<Customer> customers = session.createQuery("from Customer").list();
		transaction.commit();
		return customers;
	}

	@Override
	public Customer findById(int id) {
		// TODO Auto-generated method stub
		Transaction transaction = session.beginTransaction();
		Customer customer = session.get(Customer.class, id);
		transaction.commit();
		return customer;
	}

	@Override
	public void save(Customer customer) {
		// TODO Auto-generated method stub
		Transaction transaction = session.beginTransaction();
		session.save(customer);
		transaction.commit();

	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		Transaction transaction = session.beginTransaction();
		Customer customer = session.get(Customer.class, id);
		session.delete(customer);
		transaction.commit();
	}

}
