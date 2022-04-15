package com.filwsx.JavaStudyAdvanced.NewFeature;

/**
 * @author filwsx
 * @date 2022-02-20 21:56
 */
@FunctionalInterface
public interface MyInterface<X,Y,Z>{
    public Z method(X x,Y y);
}
