package de.fraunhofer.iem;

class Demo {
    static String target() { return "42"; }

    public static void main(String[] args) throws Exception {
        Demo.class.getDeclaredMethod("target").invoke(null);
    }
}
