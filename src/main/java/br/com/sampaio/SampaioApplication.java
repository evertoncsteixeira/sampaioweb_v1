package br.com.sampaio;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class SampaioApplication {

	public static void main(String[] args) {
		  new SpringApplicationBuilder(SampaioApplication.class)
            .properties("server.port=8081")
            .run(args);
	}

}
