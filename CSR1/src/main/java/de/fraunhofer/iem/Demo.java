package de.fraunhofer.iem;

class Demo {
    public static void verifyCall(){ /* do something */ }

    static void callForName(String className) throws Exception {
        Class.forName(className);
    }

    public static void main(String[] args) throws Exception {
        Demo.callForName("de.fraunhofer.iem.TargetClass");
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
