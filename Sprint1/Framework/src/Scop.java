package etu1819.annotation;

import java.lang.annotation.*;


@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Scop {
    boolean isSingle() default false;
}
