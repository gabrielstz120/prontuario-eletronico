/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.gabrielstz120;

import io.github.gabrielstz120.views.LoginView;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author gabriel.correa
 */
@EnableJpaRepositories
@ComponentScan
@SpringBootApplication
public class ProntuarioApplication implements CommandLineRunner {

    public static void main(String[] args) {
        new SpringApplicationBuilder(ProntuarioApplication.class)
                .headless(false)
                .bannerMode(Banner.Mode.OFF)
                .web(WebApplicationType.NONE)
                .run(args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.setProperty("java.awt.headless", "false");
        new LoginView().setVisible(true);
    }

}
