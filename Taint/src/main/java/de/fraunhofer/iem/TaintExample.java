package de.fraunhofer.iem;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TaintExample {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        Method sourceMethod = Source.class.getMethod("getParameter", String.class);
        String secret = (String) sourceMethod.invoke(Source.class, args[0]);

        Sink sink = new Sink();
        sink.executeSqlQuery(secret);
    }
}

class Source {

    public static String getParameter(String value) {
        return value;
    }
}

class Sink {

    public void executeSqlQuery(String value) {

        String queryString = "SELECT * From user_data WHERE userid= " + value;

        try {
            if (value.contentEquals("SECRET")) {
                throw new Exception();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
