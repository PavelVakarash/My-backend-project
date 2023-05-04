package com.example.servingwebcontent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MyBackendProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyBackendProjectApplication.class, args);
	}

}

// На основе созданного проекта добавьте Controller, который будет выдавать список исполнителей.
// Он должен обрабатывать адреса /artists
// Добавьте view который будет показывать список исполнителей
// По аналогии в классе сделайте список артистов с полями name и genre
// artists?genre=[GENRE VALUE] должен отдавать исполнителей только этого жанра.
// Например, /artists?genre=rock должен отобразить только исполнителей в этом жанре из вашего заготовленного списка.
