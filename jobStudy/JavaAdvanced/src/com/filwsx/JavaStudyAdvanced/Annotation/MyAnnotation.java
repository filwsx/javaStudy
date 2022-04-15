package com.filwsx.JavaStudyAdvanced.Annotation;

import java.lang.annotation.*;

import static java.lang.annotation.ElementType.*;

/**
 * @author filwsx
 * @date 2022-02-07 13:45
 */
@Inherited
@Repeatable(MyFILWSX.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE,TYPE_PARAMETER,TYPE_USE})
public @interface MyAnnotation {
    String value() default "filwsx";

}
