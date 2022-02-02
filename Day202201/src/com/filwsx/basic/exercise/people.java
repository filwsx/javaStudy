package com.filwsx.basic.exercise;

public class people extends animal {

	@Override
    public void move(){
        System.out.println("walk");
        super.move();
    } 
	@Override
    public void sounds(){
       System.out.println("你好啊！");
       super.sounds();
    }
}
