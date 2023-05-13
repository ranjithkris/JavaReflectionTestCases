package de.fraunhofer.iem;

class Demo {
    public static String target(String parameter) { return "Value: " + parameter; }

    public static void main(String[] args) throws Exception {
        Demo.class.getDeclaredMethod("target", String.class).invoke(null, "42");
    }
}
