package com.example.config;

import com.example.utils.Greeter2;
import com.example.utils.GreeterHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public GreeterHelper greeterHelper() {
        return new GreeterHelper("Hello %s from GREETER2 !!!");
    }

    @Bean
    public GreeterHelper greeterHelper2() {
        return new GreeterHelper("Hello %s from GREETER3 !!!");
    }

    @Bean(name = "greeterHelper3_CUSTOM_NAME")
    public GreeterHelper greeterHelper3() {
        return new GreeterHelper("Hello %s from GREETER3 CUSTOM !!!");
    }

    @Bean
    @Autowired
    public Greeter2 greeter2(GreeterHelper greeterHelper) {
        return new Greeter2(greeterHelper);
    }

    @Bean
    @Autowired
    public Greeter2 greeter3(GreeterHelper greeterHelper2) {
        return new Greeter2(greeterHelper2);
    }

    @Bean
    @Autowired
    public Greeter2 greeter4(@Qualifier("greeterHelper3_CUSTOM_NAME") GreeterHelper greeterHelper3) {
        return new Greeter2(greeterHelper3);
    }


}
