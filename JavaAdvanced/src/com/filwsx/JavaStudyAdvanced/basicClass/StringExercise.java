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
        //reverseStringTest();
        //getRepeatTimesTest();
        System.out.println("start");
        getlongestRepeatStringTest();
    }

    @Test
    public static void getlongestRepeatStringTest(){
        String res = getlongestRepeatString("abcwerthelloyuiodef","cvhellobnm");
        System.out.println(res);
    }

    public static String getlongestRepeatString(String str,String subStr){
        //根据字符串长度确认谁是子串
        if(subStr.length()>str.length()){
            String temp = subStr;
            subStr = str;
            str = temp;
        }
        int len = str.length();
        int lenSub = subStr.length();

        //存在空字符串则返回0
        if(lenSub==0){
            return "";
        }
        char [] charArray = str.toCharArray();
        char [] charArraySub = subStr.toCharArray();
        int resultIndex = 0;
        int resultCount = 0;
        int index = 0;  //当前搜索起始索引
        int count = 0;  //当前搜索匹配长度
        int flag = 1;   //标记是否是重新匹配到
        for (int i = 0; i < lenSub; i++){  //遍历长字符串
            for (int j = 0; j < len; j++){   //遍历子字符串和长字符串挨个对比
                for (int k = 0; i+k < lenSub && i+k+j < len; k++) {
                    if(charArraySub[i+k] == charArray[i+k+j]){
                        if(flag==1){
                            index = i+k;
                            count = 0;
                            flag = 0;
                        }
                        count++;
                    }else{
                        if(count>resultCount){
                            resultIndex = index;
                            resultCount = count;
                        }
                        flag = 1;
                    }
                }
            }
            i = resultIndex+resultCount;
        }
        return "";
    }
    public static void method(){

    }
    @Test
    public static void getRepeatTimesTest(){
        String s1 = "HelloHelLohelloHello12312312HellTest";
        String s2 = "123";
        System.out.println(getRepeatTimes(s2,s1));
        System.out.println(getRepeatTimes(s1,s2));
        System.out.println(getRepeatTimes(s1,"12"));
        System.out.println(getRepeatTimes(s1,"Hello"));
        System.out.println(getRepeatTimes(s1,"HelLo"));
        System.out.println(getRepeatTimes(s1,"Hell"));
        System.out.println(getRepeatTimes(s1,"W"));
        System.out.println(getRepeatTimes(s1,""));
    }

    public static int getRepeatTimes(String str,String subStr){
        //根据字符串长度确认谁是子串
        if(subStr.length()>str.length()){
            String temp = subStr;
            subStr = str;
            str = temp;
        }
        int len = str.length();
        int lenSub = subStr.length();
        int result = 0; //运算结果

        //存在空字符串则返回0
        if(lenSub==0){
            return result;
        }
        char [] charArray = str.toCharArray();
        char [] charArraySub = subStr.toCharArray();

        //开始匹配
        for(int i=0;i+lenSub<len;i++){  //遍历长字符串
           int flag = 1;
           for(int j=0;j<lenSub;j++){   //遍历子字符串和长字符串挨个对比
                if(charArraySub[j] !=charArray[i+j]){
                    flag = 0;
                    break;
                }
           }
           result += flag;
        }
        return result;
        //20220206 1104 初步完成
        //20220206 1112 完成
    }

    @Test
    public static void reverseStringTest(){
        String s1 = "";
        String s2 = "HelLOWorld12";
        System.out.println(reverseString(s2,0,12));
        System.out.println(reverseString(s2,11,12));
        System.out.println(reverseString(s2,3,8));
        //System.out.println(reverseString(s2,12,12));
        //System.out.println(reverseString(s1,0,12));
    }

    public static String reverseString(String str,int start,int end) throws IndexOutOfBoundsException{
        int len = str.length();
        if(start>=end || start<0 ||end>len){ //不用写end<0 start>len
            throw new IndexOutOfBoundsException("字符串区间不合法");
        }//20220206 1012写
        char[] charArray = str.toCharArray();
        int middle = (end-1+start)/2;
        char temp = ' ';
        for(int i = 0;start+i <= middle;i++){
            temp = charArray[start + i];
            charArray[start + i] = charArray[end-1-i];
            charArray[end-1-i] = temp;
        }
        return new String(charArray);
        //20220206 1042完成，for对称反转写的不熟练啊！！！
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
