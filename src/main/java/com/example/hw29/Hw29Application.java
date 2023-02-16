package com.example.hw29;

import com.example.hw29.coffee.order.CoffeeOrderBoard;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import java.util.Arrays;

@SpringBootApplication
@Slf4j
public class Hw29Application {

	public static void main(String[] args) {
		SpringApplication.run(Hw29Application.class, args);
	}
	@EventListener(ApplicationReadyEvent.class)
	public void start(){
		CoffeeOrderBoard cob = new CoffeeOrderBoard();

		cob.add("Roma");
		cob.add("Valera");
		cob.add("Kirill");
		cob.add("Vlad");
		cob.add("Ilya");
		cob.add("Misha");
		cob.add("Veronika");
		cob.add("Erwin");
		cob.add("Katya");

		cob.showBoard();

		log.info("Доставлен самый первый заказ ");
		cob.deliver().showInfo();
		log.info("Доставлен четвёртый заказ ");
		cob.deliver(4).showInfo();
		log.info("Попытка повторно доставить четвёртый заказ ");
		try {
			cob.deliver(4).showInfo();
		} catch (NullPointerException e) {
			StringBuilder stringBuilder = new StringBuilder();
			Arrays.stream(e.getStackTrace()).forEach(stackTraceElement -> stringBuilder.append("\n at ").append(stackTraceElement.toString()));
			log.error(stringBuilder.toString());
		} finally {
			cob.showBoard();
		}
	}
}
