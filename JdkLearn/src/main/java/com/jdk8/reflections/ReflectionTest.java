package com.jdk8.reflections;


import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author hgh 2019-07-11 10:08
 */
public class ReflectionTest {

	@Test
	public void testFrom() {
		LinkedHashMap linkedHashMap = new LinkedHashMap();
		System.out.println(linkedHashMap.getClass());
		System.out.println(linkedHashMap.getClass().isAssignableFrom(Map.class));
	}

	@Test
	public void testMap() {
        HashMap testMap = new HashMap<String, Object>();
		// testMap 是否是Map接口的实例
		System.out.println(testMap instanceof Map);
		// testMap 是否是Map接口的子接口的实例
		System.out.println(testMap instanceof HashMap);
		// testMap class 是否与 Map class相同，或是其超类或接口
		System.out.println(testMap.getClass().isAssignableFrom(Map.class));
		// Map class 是否与 testMap class相同，或是其超类或接口
		System.out.println(Map.class.isAssignableFrom(testMap.getClass()));
		// HashMap class 是否与 testMap class相同，或是其超类或接口
		System.out.println(HashMap.class.isAssignableFrom(testMap.getClass()));
		// testMap class 是否与 HashMap class相同，或是其超类或接口
		System.out.println(testMap.getClass().isAssignableFrom(HashMap.class));
	}
}
