package com.example.servingwebcontent;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MyBackendProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyBackendProjectApplication.class, args);
	}

	@Bean
	public OpenAPI baseOpenApi()
	{
		return new OpenAPI().info(new Info()
				.title("Ticket shop")
				.version("1.0.0")
				.description("Ticket shop REST API"));
	}
}

// На основе созданного проекта добавьте Controller, который будет выдавать список исполнителей.
// Он должен обрабатывать адреса /artists
// Добавьте view который будет показывать список исполнителей
// По аналогии в классе сделайте список артистов с полями name и genre
// artists?genre=[GENRE VALUE] должен отдавать исполнителей только этого жанра.
// Например, /artists?genre=rock должен отобразить только исполнителей в этом жанре из вашего заготовленного списка.
