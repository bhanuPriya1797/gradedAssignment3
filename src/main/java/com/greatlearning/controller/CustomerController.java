package com.greatlearning.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.greatlearning.entity.Customer;
import com.greatlearning.service.CustomerService;
import com.greatlearning.service.CustomerServiceImpl;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	@Autowired

	private CustomerService customerServiceImpl;

	@RequestMapping("/list")
	public String listCustomer(Model model) {

		List<Customer> customers = customerServiceImpl.findAll();
		model.addAttribute("customers", customers);
		return "listCustomer";
	}

	@RequestMapping("/showFormForAdd")
	public String showFormForAdd(Model model) {

		Customer customer = new Customer();
		model.addAttribute("customer", customer);
		return "addCustomer";
	}

	@RequestMapping("/showFormForUpdate")
		public String showFormForUpdate(@RequestParam("id") int id, Model model) {
		Customer customer = customerServiceImpl.findById(id);
		model.addAttribute("customer", customer);
		return "addCustomer";
	}

	@PostMapping("/save")
	public String save(@RequestParam("id") int id, @RequestParam("firstName") String firstName,
			@RequestParam("lastName") String lastName, @RequestParam("email") String email) {

		Customer customer;
		if (id != 0) {
			customer = customerServiceImpl.findById(id);
			customer.setFirstName(firstName);
			customer.setLastName(lastName);
			customer.setEmail(email);

		} else {
			customer = new Customer(firstName, lastName, email);
		}
		customerServiceImpl.save(customer);
		return "redirect:/customer/list";
	}
	@RequestMapping("/delete")
	public String delete(@RequestParam("id") int id) {
		customerServiceImpl.deleteById(id);

		return "redirect:/customer/list";
	}

}
