package com.example;

import com.example.utils.GhostGreeter;
import com.example.utils.Greeter1;
import com.example.utils.Greeter2;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Application implements CommandLineRunner {

    @Value("${spring.application.name}")
    private String appName;

    private static final Logger log = LogManager.getLogger(Application.class);

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(Application.class, args);
        String beanNames = String.join(", ", ctx.getBeanDefinitionNames());
        log.info("Beans provided by Spring Boot:");
        log.info("Count: {} | {}", ctx.getBeanDefinitionNames().length, beanNames);
    }

    @Autowired
    ApplicationContext context;

    @Autowired
    private Greeter1 greeter1;

    private final Greeter2 greeter2;
    private final Greeter2 greeter3;
    private Greeter2 greeter4;


    @Autowired
    public Application(Greeter2 greeter2,
                       Greeter2 greeter3
    ) {
        this.greeter2 = greeter2;
        this.greeter3 = greeter3;
    }

    @Autowired
    public void setGreeter4(Greeter2 greeter4) {
        this.greeter4 = greeter4;
    }

    @Override
    public void run(String... args) {
        log.info("Application Name: {}", appName);
        log.info(greeter1.greet());
        log.info(greeter2.greet("Spring"));
        log.info(greeter3.greet("Spring"));
        log.info(greeter4.greet("Spring"));

        GhostGreeter ghostGreeter = (GhostGreeter) context.getBean("ghostGreeter");
        log.info("There's a hidden ghost in the app! {}", ghostGreeter.greet("Spooky Bean"));
    }
}
