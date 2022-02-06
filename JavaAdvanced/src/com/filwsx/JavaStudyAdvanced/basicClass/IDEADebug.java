package com.filwsx.JavaStudyAdvanced.basicClass;

import org.junit.Test;

/**
 * @author filwsx
 * @date 2022-02-06 16:33
 */
public class IDEADebug {
    @Test
    public void testStringBuffer(){
        String str = null;

        StringBuffer sb = new StringBuffer();
        sb.append(str);//
        System.out.println(sb.length());//4
        System.out.println(sb);//"null"

        StringBuffer sb1 = new StringBuffer(str);//抛异常NullPointerException
        System.out.println(sb1);//
    }
}
