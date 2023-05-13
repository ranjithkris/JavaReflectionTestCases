package de.fraunhofer.iem;

import java.util.Properties;

class Demo {

    public static void verifyCall(){ /* do something */ }

    static void callForName() throws Exception {
        String className = System.getProperty("className");
        Class.forName(className);
    }

    public static void main(String[] args) throws Exception {
        Properties props = System.getProperties();
        props.put("className", "de.fraunhofer.iem.TargetClass");
        System.setProperties(props);
        Demo.callForName();
    }
}

class TargetClass {

    static {
        staticInitializerCalled();
    }

    static private void staticInitializerCalled(){
        Demo.verifyCall();
    }
}

