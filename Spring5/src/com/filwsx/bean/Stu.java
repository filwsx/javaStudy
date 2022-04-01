package com.filwsx.bean;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author filwsx
 * @create 2022-04-01 18:53
 */
public class Stu {
    private String[] course;

    private List<String> list;

    private Map<String,String> maps;

    private Set<String> sets;

    public void setList(List<String> list) {
        this.list = list;
    }

    public void setMaps(Map<String, String> maps) {
        this.maps = maps;
    }

    public void setSets(Set<String> sets) {
        this.sets = sets;
    }

    public void setCourse(String[] course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "Stu{" +
                "course=" + Arrays.toString(course) +
                ", list=" + list +
                ", maps=" + maps +
                ", sets=" + sets +
                '}';
    }
}
