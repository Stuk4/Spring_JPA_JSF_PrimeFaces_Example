package com.selcukc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.selcukc.dao.CustomerDAO;
import com.selcukc.model.Customer;

import java.util.List;

@Service("CustomerService")
@Transactional(readOnly = true)
public class CustomerService{

    @Autowired
    CustomerDAO dao;

    public CustomerService() {
        super();
    }

    @Transactional(readOnly = false)
    public void addCustomer(Customer customer) {
        dao.create(customer);
    }

    @Transactional(readOnly = false)
    public void deleteCustomer(Customer customer) {
        dao.delete(customer);
    }

    @Transactional(readOnly = false)
    public void updateCustomer(Customer customer) {
        dao.update(customer);
    }

    public Customer getCustomerById(int id) {
        return dao.findOne(id);
    }

    public List<Customer> getCustomers() {
        return dao.findAll();
    }

}

