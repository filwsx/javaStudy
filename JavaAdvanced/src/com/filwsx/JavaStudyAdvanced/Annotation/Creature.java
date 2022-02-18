package com.filwsx.JavaStudyAdvanced.Annotation;

/**
 * @author filwsx
 * @date 2022-02-18 20:07
 */
public class Creature<T>  {
    public T type;
    private char gender;
    public double weight;
    private void breath(){
        System.out.println("生物呼吸");
    }
}
