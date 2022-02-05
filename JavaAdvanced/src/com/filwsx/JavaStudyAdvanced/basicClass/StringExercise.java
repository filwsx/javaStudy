package com.filwsx.JavaStudyAdvanced.basicClass;

/**
 * 与String有关的面试题
 * @author filwsx
 * @date 2022-02-05 16:04
 */
public class StringExercise {
    public static void main(String[] args) {
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
    }//20220205 1621初步完成，待测试
    // 1628测试完成，傻了，把循环终止条件写反了
}
