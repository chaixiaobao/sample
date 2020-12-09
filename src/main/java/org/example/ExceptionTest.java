package org.example;

import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;

public class ExceptionTest {

    private static Logger logger = LoggerFactory.getLogger(ExceptionTest.class);

    public static void main(String[] args) {
        try {
            test();
        } catch (Exception e) {
//            System.out.println(e.getMessage());
//            System.out.println("---------------------");
//            System.out.println(e.toString());
//            System.out.println("---------------------");
//            e.printStackTrace();
//            System.out.println("---------------------");
//            System.out.println(e.getStackTrace());
//            e.printStackTrace();
//            System.out.println(e);
//            logger.warn("错误", e);
        }

        String str = "abc=";
        System.out.println(str.substring(str.indexOf("abc=") + "abc=".length()));
        System.out.println(str.substring(str.indexOf("abc=") + "abc=".length()).equals(""));
    }

    public static void test() {
        throw new RuntimeException("this is exception");
    }
}
