package com.filwsx.bean.factoryBean;

import com.filwsx.bean.school.Student;
import com.sun.org.apache.bcel.internal.generic.NEW;
import org.springframework.beans.factory.FactoryBean;

/**
 * @author filwsx
 * @create 2022-04-02 12:31
 */
public class MyBean implements FactoryBean<Student> {

    private Student student = new Student();
    // 定义返回的Bean类型
    @Override
    public Student getObject() throws Exception {
        return student;
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }

    @Override
    public boolean isSingleton() {
        return FactoryBean.super.isSingleton();
    }
}
