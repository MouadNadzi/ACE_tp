package org.example.demo1;

import org.example.demo1.model.Compte;
import org.example.demo1.model.TypeCompte;
import org.example.demo1.repository.CompteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class Demo1Application {

    public static void main(String[] args) {
        SpringApplication.run(Demo1Application.class, args);
    }
    @Bean
    CommandLineRunner start(CompteRepository compteRepository) {
        return args -> {
            compteRepository.save(new Compte(null, 9000.0, new Date(), TypeCompte.COURANT));
            compteRepository.save(new Compte(null, 12000.0, new Date(), TypeCompte.EPARGNE));
            compteRepository.save(new Compte(null, 7500.0, new Date(), TypeCompte.COURANT));

            compteRepository.findAll().forEach(System.out::println);
        };
    }

}
