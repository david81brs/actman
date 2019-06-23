package com.deltal.actman;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties
@PropertySource("classpath:application.properties")
public class MyProperties {


    Actpring actspring;

    public static class Actpring {
        String username;
        String password;

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }



    public Actpring getActspring() {
        return actspring;
    }

    public void setActspring(Actpring actspring) {
        this.actspring = actspring;
    }
}
