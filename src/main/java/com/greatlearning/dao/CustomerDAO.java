package com.greatlearning.dao;

import com.greatlearning.entity.Customer;

import java.util.List;

public interface CustomerDAO {

	public List<Customer> findAll();

	public Customer findById(int id);

	public void save(Customer customer);

	public void deleteById(int id);
}
