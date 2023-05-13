package de.fraunhofer.iem;

class Demo {
    public static void verifyCall(){ /* do something */ }

    public Demo() { Demo.verifyCall(); }

    public static void main(String[] args) throws Exception {
        Demo.class.newInstance();
    }
}
