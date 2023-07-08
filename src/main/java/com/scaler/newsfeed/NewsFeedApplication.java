package com.scaler.newsfeed;

import com.scaler.newsfeed.commands.CommandRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.Scanner;

@SpringBootApplication
@EnableJpaAuditing
public class NewsFeedApplication implements CommandLineRunner {
    CommandRegistry commandRegistry;
    Scanner scanner;
    @Autowired
    NewsFeedApplication(CommandRegistry commandRegistry){
        this.commandRegistry = commandRegistry;
        scanner = new Scanner(System.in);
    }
    public static void main(String[] args) {
        SpringApplication.run(NewsFeedApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        while (true) {
            System.out.println("Tell what do you want to do?");
            String input = scanner.nextLine();
            commandRegistry.execute(input);
        }
    }
}
