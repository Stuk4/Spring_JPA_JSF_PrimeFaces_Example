package com.selcukc.dao;

import org.springframework.stereotype.Repository;
import com.selcukc.model.Customer;

@Repository
public class CustomerDAO extends AbstractDao<Customer>{

    public CustomerDAO() {
        super();
        setClazz(Customer.class);
    }

}

