package br.com.alura.escolalura;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class EscolaluraApplication {

    public static void main(String[] args) {
        SpringApplication.run(EscolaluraApplication.class, args);
    }
}
