package com.selcukc.bean;

import org.springframework.dao.DataAccessException;
import com.selcukc.model.Customer;
import com.selcukc.service.CustomerService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "customerMB")
@RequestScoped
public class CustomerManagedBean implements Serializable {

    private static final long serialVersionUID = 1L;

    //Spring Customer Service is injected...
    @ManagedProperty(value = "#{CustomerService}")
    CustomerService customerService;

    List<Customer> customerList = new ArrayList<Customer>();

    Customer customer = new Customer();

    public String addCustomer() {
        try {
            getCustomerService().addCustomer(getCustomer());
            return "success.xhtml?faces-redirect=true";
        } catch (DataAccessException e) {
            e.printStackTrace();
        }

        return "error.xhtml?faces-redirect=true";
    }

    public void reset() {
        customer = new Customer();
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Customer> getCustomerList() {
        return getCustomerService().getCustomers();
    }

    public void setCustomerList(List<Customer> customerList) {
        this.customerList = customerList;
    }

    public CustomerService getCustomerService() {
        return customerService;
    }

    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

}
