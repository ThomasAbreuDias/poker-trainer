package app.poker.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"app.poker"})
public class PokerApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(PokerApiApplication.class, args);
    }
}