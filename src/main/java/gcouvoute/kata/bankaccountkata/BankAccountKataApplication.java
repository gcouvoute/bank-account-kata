package gcouvoute.kata.bankaccountkata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("gcouvoute.kata.bankaccountkata.datasource.repositories")
public class BankAccountKataApplication {

    public static void main(String[] args) {
        SpringApplication.run(BankAccountKataApplication.class, args);
    }

}
