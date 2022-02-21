package com.filwsx.JavaStudyAdvanced.Annotation;

import java.util.ArrayList;
import java.util.List;

/**
 * @author filwsx
 * @date 2022-02-21 16:13
 */
public class PersonData {
    public static List<Person> getPersonList(){
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("马化腾", 34));
        personList.add(new Person("马云", 12));
        personList.add(new Person("刘强东"));
        personList.add(new Person("雷军", 26));
        personList.add(new Person("李彦宏", 65));
        personList.add(new Person("比尔盖茨", 42));
        personList.add(new Person("任正非", 26));
        personList.add(new Person("扎克伯格", 35));
        return  personList;
    }
}
