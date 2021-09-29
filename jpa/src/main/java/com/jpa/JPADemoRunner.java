package com.jpa;

import com.jpa.dao.DAOService;
import com.jpa.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class JPADemoRunner implements CommandLineRunner {

    @Autowired
    private DAOService daoService;



    @Override
    public void run(String... args) throws Exception {
        User user = new User("Saksham","25");
        daoService.insertUser(user);
    }
}
