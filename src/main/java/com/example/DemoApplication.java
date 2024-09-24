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
//  3. Сделать из payment Entity (связь прописывается в аннотациях)
//  4. CRUD на Order (Создать, достать по ид, достать все)
//  4. Сделать метод pay (посылать ид ордера и лист пэментов *использовать методы find)
//  5. Установить DBeaver. И подключиться к БД. Либо же подключиться через ИДЕЮ.