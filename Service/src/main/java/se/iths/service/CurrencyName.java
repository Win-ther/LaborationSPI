package se.iths.service;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
public @interface CurrencyName {
    String value() default "";
}
@interface CurrencyNames {
    CurrencyName[] value();
}