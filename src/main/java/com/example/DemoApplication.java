package com.example;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class DemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}

// TODO:
//  1. Почитать про контроллеры
//  2. Знакомство с JSON (обьект, массив, поля)
//  3. Подать лист Пэйментов и Ордер в метод pay класса OrderService с фронта, получить в Ордер в ответе
//  4. Протестировать REST Controller.