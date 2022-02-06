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
        //getRepeatTimesTest();
        //getlongestRepeatStringTest();
    }

    @Test
    public static void getlongestRepeatStringTest(){
        long startTime = 0L;
        long endTime = 0L;
        String s1 = "abcwerthelloyuiodhellobefrgfdee";
        String s2 = "cvhellobnmabcwerthel";
        String s3 = "cvhellobnm";
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            getlongestRepeatString(s1,s2);
            getlongestRepeatString(s1,s3);
        }
        endTime = System.currentTimeMillis();
        System.out.println("StringBuffer的执行时间：" + (endTime - startTime));

        startTime = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            getMaxSameString(s1,s2);
            getMaxSameString(s1,s3);
        }
        endTime = System.currentTimeMillis();
        System.out.println("StringBuffer的执行时间：" + (endTime - startTime));
        //20220206 1547 还是我的代码效率高！！！
    }

    //获取两个字符串中最大相同子串。
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
        /**
         * 算法思路：
         * ①短的字符串从头开始匹配长字符串。
         * ②匹配到一个字符后继续匹配子字符串的下一个，直到无法连续匹配。记录该连续匹配的字符串信息（索引和长度）
         * ③如果此次匹配长度大于上次，则值得记录。记录后继续匹配，直到此次长字符串被遍历完。
         * 下一次匹配起始点则是从上次子字符串未能连续匹配点开始，这也是算法的精髓之处，没必要每次只缩短一个长度重新匹配。
         * 为什么不调用现有的函数进行对比，因为看了现有函数源码，内部实现是双层循环，这样一来四层了，不如自己写的三层。
         */
        // i控制匹配子字符串的开始索引
        // j控制遍历长字符串的位置
        // k控制某次匹配中，字符串对比到第几个了
        for (int i = 0; i < lenSub; i++){  //遍历子字符串，从0开始和长字符匹配
            for (int j = 0; j < len; j++){   //遍历子字符串和长字符串挨个对比
                for (int k = 0; i+k < lenSub && k+j < len; k++) {
                    if(charArraySub[i+k] == charArray[k+j]){
                        if(count==0){
                            index = i+k;
                        }
                        count++;    //连续匹配一次，值加一
                    }else{//此次连续匹配结束
                        if(count>resultCount){//长度超过上次
                            resultCount = count;
                            resultIndex = index;
                        }
                        count = 0;
                        break;
                    }
                }
            }
            if(i<resultIndex+resultCount){
                i = resultIndex+resultCount;
            }
        }
        return subStr.substring(resultIndex, resultIndex+resultCount);
        //20220206 1325完成测试，成功！！！太难了，想的我头疼
        //20220206 1405完成，真正！
        //20220206 1542 尝试用两个for写出来，失败
    }

    public static String getMaxSameString(String str1,String str2){
        if(str1 != null && str2 != null){
            String maxStr = (str1.length() >= str2.length())? str1 : str2;
            String minStr = (str1.length() < str2.length())? str1 : str2;
            int length = minStr.length();

            for(int i = 0;i < length;i++){
                for(int x = 0,y = length - i;y <= length;x++,y++){
                    String subStr = minStr.substring(x,y);
                    if(maxStr.contains(subStr)){
                        return subStr;
                    }

                }
            }

        }
        return null;
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

    //获取一个字符串在另一个字符串中出现的次数。
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
        System.out.println(s2);
        System.out.println(reverseString2(s2,0,12));
        System.out.println(reverseString2(s2,11,12));
        System.out.println(reverseString2(s2,3,8));
        System.out.println(reverseString2(s2,12,12));
        System.out.println(reverseString2(s1,0,12));
    }

    //将字符串中指定部分进行反转。
    public static String reverseString(String str,int start,int end){
        if(start>=end || start<0 ||end>str.length()){ //不用写end<0 start>len
            return str;
        }
        char[] charArray = str.toCharArray();
        char temp = ' ';
        for(int i = start,j=end-1;i<j;i++,j--){
            temp = charArray[i];
            charArray[i] = charArray[j];
            charArray[j] = temp;
        }
        return new String(charArray);
        //20220206 1042完成，for对称反转写的不熟练啊！！！
        //20220206 1558改进，我写的复杂了！
    }
    
    public static String reverseString2(String str,int start,int end){
        if(start>=end || start<0 ||end>str.length()){
            return str;
        }
        String str1 = str.substring(0,start);
        for (int i = end-1; i >= start; i--) {
            str1 += str.charAt(i);
        }
        str1 += str.substring(end);

        return str1;
        //这么写会加入null字符串
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

    //去除字符串两端的空格.
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
