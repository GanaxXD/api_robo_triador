package main.java.com.tjma.toadalab;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(
		title = "Back-end Coleta de Dados das Automações do TJMA", version = "2.2.0",
		description = "API de coleta de dados das automações desenvolvidas pelo Toada Lab."))
public class APIColetaToada {

	public static void main(String[] args) {
		SpringApplication.run(APIColetaToada.class, args);
	}

}
