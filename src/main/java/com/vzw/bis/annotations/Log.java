package com.vzw.bis.annotations;

import java.lang.annotation.*;

/**
 *
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Documented
public @interface Log {
    //for slf4j
}
