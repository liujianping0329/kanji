package com.goldhako.kanji.service.impl;

import com.goldhako.kanji.dao.CustomerDAO;
import com.goldhako.kanji.po.Customer;
import com.goldhako.kanji.po.CustomerExample;
import com.goldhako.kanji.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDAO customerDAO;

    @Override
    public List<Customer> findAll() {
        return customerDAO.selectByExample(new CustomerExample());
    }
}
