package com.goldhako.kanji.service.impl;

import com.goldhako.kanji.dao.CustomerDAO;
import com.goldhako.kanji.po.Customer;
import com.goldhako.kanji.po.CustomerExample;
import com.goldhako.kanji.service.CustomerService;
import lombok.Cleanup;
import lombok.SneakyThrows;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Log
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDAO customerDAO;

    @Override
    @SneakyThrows
    public List<Customer> findAll() {
        long a, b;
        a = new Date().getTime();
        FileInputStream fileInputStream = new FileInputStream("E://code//code.zip");
        BufferedInputStream bufferedInputStream=new BufferedInputStream(fileInputStream);
        byte[] bytes = new byte[bufferedInputStream.available()];
        bufferedInputStream.read(bytes);
        b=new Date().getTime();
        log.info((b-a)+"");


        return new ArrayList<>();
    }
}
