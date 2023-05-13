package de.fraunhofer.iem;

class Demo {
    public static void verifyCall(){ /* do something */ }

    public static void main(String[] args) throws Exception {
        Class.forName("de.fraunhofer.iem.InitializedClass");
    }
}

class InitializedClass {

    static {
        staticInitializerCalled();
    }

    static private void staticInitializerCalled(){
        Demo.verifyCall();
    }
}
