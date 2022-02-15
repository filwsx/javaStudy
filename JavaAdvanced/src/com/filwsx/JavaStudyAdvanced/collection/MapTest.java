package com.filwsx.JavaStudyAdvanced.collection;

import org.junit.Test;

import java.util.*;

/**
 * @author filwsx
 * @date 2022-02-14 10:28
 */
public class MapTest {

    @Test
    public void test4(){
        Map map = new HashMap();
        map.put("AA",123);
        map.put(45,1234);
        map.put("BB",56);

        Set set = map.keySet();
        Iterator iterator = set .iterator();
        while (iterator.hasNext()){
            Object key = iterator.next();
            Object value = map.get(key);
            System.out.println(key + "=====" + value);
        }
        System.out.println("");

        Collection values = map.values();
        for(Object obj:values){
            System.out.println(obj);
        }
        System.out.println("");

        Set entry = map.entrySet();
        Iterator es = entry.iterator();
        while (es.hasNext()){
            Object obj = es.next();
            Map.Entry E = (Map.Entry) obj;
            System.out.println(E.getKey() + "---->" + E.getValue());
        }
    }

    @Test
    public void test3(){
        Map map1 = new HashMap();
        Map map2 = new HashMap();

        //添加
        map1.put("AA",123);
        map1.put(45,123);
        map1.put("BB",56);
        //修改
        map1.put("AA",87);

        System.out.println(map1);
        map2.put("BB",123);
        map2.put("DD",123);

        System.out.println(map2);
        map1.putAll(map2);

        System.out.println(map1);

        map1.remove("DD");

        System.out.println(map1);

        map1.remove(map2);
        System.out.println(map1);
        //这个结果有意思啊，BB=123还存在。
        //没意思，不是putall那样，dd不存在是因为前一句remove

        System.out.println(map1.get("AA"));
        boolean isExist = map1.containsKey("DD");
        System.out.println(isExist);
        isExist = map1.containsKey("BB");
        System.out.println(isExist);
        map2.clear();
        System.out.println(map2.isEmpty());
    }

    @Test
    public void test2(){
        Map map = new HashMap();
        map = new LinkedHashMap();
        map.put(123,"AA");
        map.put(345,"BB");
        map.put(12,"CC");

        System.out.println(map);
    }

    @Test
    public void test(){
        HashMap hm = new HashMap(15);
        hm.put("me",null);
        hm.put("me",Integer.parseInt("123"));
        System.out.println(hm);
    }
}
