package com.devsuperior.desafio;

import java.util.Locale;
import java.util.Scanner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.devsuperior.entities.Order;
import com.devsuperior.services.OrderService;

@SpringBootApplication
@ComponentScan({ "com.devsuperior" })
public class DesafioApplication implements CommandLineRunner {

	@Autowired
	private OrderService orderService;

	public static void main(String[] args) {
		SpringApplication.run(DesafioApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.println("Digite o código do pedido:");
		int code = sc.nextInt();

		System.out.println("Digite o valor básico do pedido:");
		double basic = sc.nextDouble();

		System.out.println("Digite a porcentagem de desconto:");
		double discount = sc.nextDouble();

		Order order = new Order(code, basic, discount);

		System.out.println("Pedido código " + order.getCode());
		System.out.printf("Valor total: %.2f%n", orderService.total(order));

		sc.close();
	}
}
