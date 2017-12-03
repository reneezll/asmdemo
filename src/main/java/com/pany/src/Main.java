package com.pany.src;


import java.lang.reflect.Method;

public class Main {

    public static void main(String[] args) throws Exception {
        MyClassLoader cl = new MyClassLoader();
        Class c = cl.findClass("com.pany.model.Algorithm");
        Method m = c.getDeclaredMethod("run");

        Object algorithm = c.newInstance();
        m.invoke(algorithm);
    }

}
