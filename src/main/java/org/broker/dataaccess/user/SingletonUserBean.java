package org.broker.dataaccess.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class SingletonUserBean {

    private static UserService service;

    @Autowired
    private UserService userService;

    public SingletonUserBean() {
    }

    @PostConstruct
    public void init() {
        service = userService;
    }

    public Long getSystemUser() {
        System.out.println("service.getSystemUser()" + service.getSystemUser());
        return service.getSystemUser();
    }

    public Long getUserLogged() {
        return service.getUserLogged();
    }
}
