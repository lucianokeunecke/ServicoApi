package br.com.infinet.pessoa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableCaching
public class PessoaApplication {
	@Bean
	public RestTemplate getRestTemplate(RestTemplateBuilder restTemplateBuilder){
		return restTemplateBuilder.build();
	}
	public static void main(String[] args) {
		SpringApplication.run(PessoaApplication.class, args);
	}

}
