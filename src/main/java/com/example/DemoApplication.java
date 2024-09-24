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
//  1. Протестировать REST Controller (MocMvc)  https://habr.com/ru/companies/otus/articles/746414/
//  2. Жизненный цикл бина
//  3. Создать таблицу для payment через Liquibase. Создать в таблице payment колонку link_order. Сделать foreign key на таблицу order(link_order на id ордера)
//  4. Сделать из order и payment Entity