package io.github.gabrielstz120.config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public abstract class SpringContext {

    public static ApplicationContext getContext() {
        return new AnnotationConfigApplicationContext("io.github.gabrielstz120");
    }

}
