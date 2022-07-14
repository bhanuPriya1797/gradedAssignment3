package com.greatlearning.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.dao.CustomerDAO;
import com.greatlearning.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired

	CustomerDAO customerDAOImpl;

	@Override
	public List<Customer> findAll() {
		// TODO Auto-generated method stub
		return customerDAOImpl.findAll();
	}

	@Override
	public Customer findById(int id) {
		// TODO Auto-generated method stub
		return customerDAOImpl.findById(id);
	}

	@Override
	public void save(Customer customer) {
		// TODO Auto-generated method stub
		customerDAOImpl.save(customer);
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		customerDAOImpl.deleteById(id);
	}

}
