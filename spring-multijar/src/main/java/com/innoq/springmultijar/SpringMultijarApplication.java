package com.innoq.springmultijar;

import de.jvmcon.Greeter;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringMultijarApplication implements CommandLineRunner {

    private final Greeter greeter;

    public SpringMultijarApplication(Greeter greeter) {
        this.greeter = greeter;
    }

    @Override
    public void run(String... args) {
        greeter.greet("Michael");
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringMultijarApplication.class, args);
    }

    @Bean
    public static Greeter greeter() {
        return new Greeter();
    }
}
