package com.filwsx.JavaStudyAdvanced.basicClass;

import org.junit.Test;

/**
 * 与String有关的面试题
 * @author filwsx
 * @date 2022-02-05 16:04
 */
public class StringExercise {
    public static void main(String[] args) {
        //testTrim();
        reverseStringTest();
    }

    @Test
    public static void reverseStringTest(){
        String s1 = "";
        String s2 = "HelLOWorld12";
        reverseString(s2,0,12);
        System.out.println();
    }

    public static String reverseString(String str,int start,int end) throws IndexOutOfBoundsException{
        int len = str.length();
        if(start>end || start<0 ||end>len){ //不用写end<0 start>len
            throw new IndexOutOfBoundsException("字符串区间不合法");
        }//20220206 1012写
        char[] charArray = str.toCharArray();
        int middle = (end-1+start)/2;
        for(int i=start;i<=middle;i++){
            int index = middle<<1-i;
            char temp = charArray[i];
            charArray[i] = charArray[index];
            charArray[index] = temp;
        }
        return charArray.toString();
    }

    @Test
    public static void testTrim(){
        String s1 = "     ";
        String s2 = "  Hel  LO World  12   ";
        String s3 = "  Hel  LO World  12";
        String s4 = "Hel  LO World  12   ";
        System.out.println("---"+ExerciseTrim(s1)+"---");
        System.out.println("---"+ExerciseTrim(s2)+"---");
        System.out.println("---"+ExerciseTrim(s3)+"---");
        System.out.println("---"+ExerciseTrim(s4)+"---");
    }

    public static String ExerciseTrim(String str){
        int len = str.length();
        int lowIndex = 0;
        int upIndex = len-1;
        //获取从左到右第一个不为空格的索引
        while(lowIndex<len-1){
            if (str.charAt(lowIndex) != ' '){
                break;
            }else{
                lowIndex++;
            }
        }
        //获取从右到左第一个不为空格的索引
        while(upIndex>0){
            if (str.charAt(upIndex) != ' '){
                break;
            }else{
                upIndex--;
            }
        }
        //防止空白字符串
        if(lowIndex<=upIndex){
            int resLen = upIndex-lowIndex+1;
            char res[] = new char[resLen];
            for(int i = 0 ; i < resLen ; i++){
                res[i] = str.charAt(i+lowIndex);
            }
            return new String(res);
        }else{
            return "";
        }
    }
    //20220205 1621初步完成，待测试
    //1628测试完成，傻了，把循环终止条件写反了
    //1632 去看了源码，发现实现思路和我一样，但是源码写的更优雅更简单！！
}
