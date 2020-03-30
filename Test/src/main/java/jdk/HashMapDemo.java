package jdk;

import java.util.HashMap;

/**
 * @author hgh
 * @since 2020-03-25 15:35
 */
public class HashMapDemo {

    public static void main(String[] args) {
        HashMap<Object, Object> objectObjectHashMap = new HashMap<>();
        objectObjectHashMap.put(null, 34);
        objectObjectHashMap.put(34, null);
        System.out.println(objectObjectHashMap.get(null));
        System.out.println(objectObjectHashMap.get(34));
    }
}
