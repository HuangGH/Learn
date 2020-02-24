package jdk;

import java.util.ArrayList;
import java.util.List;
import java.util.RandomAccess;

/**
 * @author hgh
 * @since 2020-02-06 10:33
 */
public class AssignableDemo {


    public static void main(String[] args) {
        // 是否是其父类或接口
        System.out.println(List.class.isAssignableFrom(ArrayList.class));
        System.out.println(RandomAccess.class.isAssignableFrom(ArrayList.class));

        // 错误示范
        System.out.println(ArrayList.class.isAssignableFrom(List.class));
    }
}
