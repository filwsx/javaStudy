package com.filwsx.test;

import com.filwsx.bean.SpringBeginning;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author filwsx
 * @date 2022-02-22 21:13
 */
public class SpringBeginningTest {

    @Test
    public void NewTest(){

        // 1.加载Spring配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("com/filwsx/springBeginning.xml");

        // 2.获取配置创建的对象
        SpringBeginning ss = context.getBean("springBeginning", SpringBeginning.class);
        System.out.println(ss);
        ss.show();
    }

}
