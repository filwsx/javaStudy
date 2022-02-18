package com.filwsx.JavaStudyAdvanced.reflection;

import com.filwsx.JavaStudyAdvanced.Annotation.Person;
import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * @author filwsx
 * @date 2022-02-18 20:26
 */
public class MethodTest {

    @Test
    public void test2(){
        Class cla = Person.class;
        Method declaredMethods[] = cla.getDeclaredMethods();
        for (Method method:declaredMethods){
            Annotation annos[] = method.getAnnotations();
            int modifiers = method.getModifiers();
            Class type = method.getReturnType();
            String methodName = method.getName();
            Class parameterTypes[] = method.getParameterTypes();
            Class exceptionTypes[] = method.getExceptionTypes();

            for(Annotation a : annos){
                System.out.print(a + "\t");
            }
            System.out.println("");
            System.out.print(Modifier.toString(modifiers) + "\t");
            System.out.print(type.getName()+"\t");
            System.out.print(methodName+"\t");

            System.out.print("(");
            if(!(parameterTypes == null && parameterTypes.length == 0)){
                for(int i = 0;i < parameterTypes.length;i++){
                    //这个判断是为了最后一个参数不输出逗号！
                    if(i == parameterTypes.length - 1){
                        System.out.print(parameterTypes[i].getName() + " args_" + i);
                        break;
                    }
                    System.out.print(parameterTypes[i].getName() + " args_" + i + ",");
                }
            }
            System.out.println(")");

            if(exceptionTypes.length > 0){
                System.out.print("throws ");
                for(int i = 0;i < exceptionTypes.length;i++){
                    if(i == exceptionTypes.length - 1){
                        System.out.print(exceptionTypes[i].getName());
                        break;
                    }
                    System.out.print(exceptionTypes[i].getName() + ",");
                }
            }
            System.out.println("******************************************************************");
        }
    }

    @Test
    public void test1(){
        Class cla = Person.class;
        Method methods[] = cla.getMethods();
        for(Method method:methods){
            System.out.println(method);
        }
        System.out.println("");

        Method declaredMethods[] = cla.getDeclaredMethods();
        for (Method method:declaredMethods){
            System.out.println(method);
        }
        System.out.println("");
    }
}
