package org.example;

import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;

import javax.sound.midi.Soundbank;
import java.io.File;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class Generic {

    private static Logger logger = LoggerFactory.getLogger(Generic.class);

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
//        List<String> list = new ArrayList<>();
//        list.add("hello");
//        Field field = list.getClass().getDeclaredField("elementData");
//        field.setAccessible(true);
//        Object[] arr = (Object[]) field.get(list);
//        arr[0] = new User("chaihao", 34);
////        String str = list.get(0);
////        System.out.println(list.get(0));
//        Object obj = list.get(0);
////        int i = list.get(0);
//        System.out.println(obj);
//        System.out.println("测试" + System.getProperty("line.separator") + "换行测试" + System.getProperty("line.separator"));
        logger.error(System.getProperty("java.class.path"));//系统的classpaht路径
        logger.error(System.getProperty("user.dir"));
    }
}
