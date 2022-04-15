package com.filwsx.JavaStudyAdvanced.reflection;

/**
 * @author filwsx
 * @date 2022-02-19 17:32
 */

interface ClothFactory{
    void produceCloth();
}
public class ProxyClothFactory implements ClothFactory{

    private ClothFactory factory;

    public ProxyClothFactory(ClothFactory factory){
        this.factory = factory;
    }

    @Override
    public void produceCloth() {
        System.out.println("交付代理工厂");
        factory.produceCloth();
        System.out.println("生产完成");
    }
}

class TomFactory implements ClothFactory{
    @Override
    public void produceCloth() {
        System.out.println("生产Tom cat");
    }
}

class ProxyClothFactoryTest{
    public static void main(String[] args) {
        TomFactory tom = new TomFactory();
        ProxyClothFactory proxyClothFactory = new ProxyClothFactory(tom);
        proxyClothFactory.produceCloth();
    }
}