package io.github.gabrielstz120.config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public abstract class SpringContext {
    private static ApplicationContext applicationContext = new AnnotationConfigApplicationContext("io.github.gabrielstz120");

    public static ApplicationContext getContext() {
        return applicationContext;
    }

}
