package com.filwsx.JavaStudyAdvanced.enumClass;

/**
 * @author filwsx
 * @date 2022-02-07 10:45
 */
public class SeasonEnum {
    public static void main(String[] args) {
        //Thread类的内部枚举类State
        Thread.State values[] = Thread.State.values();
        for (int i = 0; i < values.length; i++) {
            System.out.println(values[i]);
        }
        Season2 summer = Season2.valueOf("SUMMER");
        System.out.println(summer.getClass());

        Season2 winter = Season2.WINTER;
        winter.show();
    }
}

interface Info{
    void show();
}

enum Season2 implements Info{
    //1.提供当前枚举类的对象，多个对象之间用","隔开，末尾对象";"结束
    SPRING("春天","春暖花开"){
        @Override
        public void show(){
            System.out.println("春天在哪里？");
        }
    },
    SUMMER("夏天","夏日炎炎"){
        @Override
        public void show(){
            System.out.println("宁静的夏天");
        }
    },
    AUTUMN("秋天","秋高气爽"){
        @Override
        public void show(){
            System.out.println("停车坐爱枫林晚");
        }
    },
    WINTER("冬天","冰天雪地"){
        @Override
        public void show(){
            System.out.println("Winter is coming！");
        }
    };

    //2.声明Season对象的属性:private final修饰
    private final String seasonName;
    private final String seasonDesc;

    //3.私有化类的构造器,并给对象属性赋值
    private Season2(String seasonName,String seasonDesc){
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }

    //4.其他诉求1：获取枚举类对象的属性
    public String getSeasonName() {
        return seasonName;
    }
    public String getSeasonDesc() {
        return seasonDesc;
    }

    //4.其他诉求2：toString()自动提供，一般就不写了
}
