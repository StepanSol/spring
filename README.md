- Java language level: 22
- Spring:  3.3.2
- Spring WEB 
- Spring Data
- hibernate
- HQL
- JDBC template
- Maven
- lombok 1.18.34
- PostgreSQL 16.4
- Liquibase
- Mockito
- openapi 2.6.0
- Stream API
- SQL

# Сервис предоставляет работу с заказами:

**order-controller:**
- *createOrder* - создание заказа. (Время создания заказа - момент запроса; принимает "Дедлайн", сумму для оплаты и тип клиента)
- *getOrderById/{id}* - Возвращает заказ по ID.
- *getAllOrders* - Возвращает список всех заказов.
- *getActualOrders* - возвращает актуальные заказы (у которых не просрочен "Дедлайн").
- *getOrdersByClientTypeSQL(так же HQL и Spring Data)* - Возвращает заказ по типу клиента.
- *pay* - производит оплату по ID заказа. (Может передаваться один ID заказа и список оплат). Если заказ оплачен, оплата не зачисляется. Если сумма оплаты превышает требуемую сумму оплаты заказа, начисляется сдача. 

**payment-controller:**
- *getMaxSumPaymentQuery (так же через StreamAPI и CleanJava)* - возвращает оплату с наибольшей суммой.

Некоторые методы продублированы с использованием различных технологий: "getOrdersByClientTypeHQL", "getOrdersByClientTypeSQL", "getOrdersByClientTypeSpringData".


[swagger for this project](http://localhost:8080/swagger-ui/index.html#)

![Диаграмма таблиц](https://github.com/StepanSol/spring/blob/main/Диаграмма%20таблиц.png)

# Road Map

**Java Syntax:**

- [X]  *Variables*
- [X]  *Constants*
- [X]  *Types*
- [X]  *Function*
- [X]  *Packages*
- [X]  *Generics*

**Java Core:**

- [X]  *oop principles*
- [X]  *interface*
- [X]  *Приведение типов, instanceof*
- [X]  *method overloading*
- [X]  *Thread*
- [X]  *InputStream/OutputStream, FileInputStream, FileOutputStream*
- [X]  *Reader/Writer, FileReader/FileWriter*
- [X]  *Serialization*
- [X]  *Object: equals, hashCode, clone, wait, notify, toString()*
- [X]  *Inner Class, Nested Classes*
- [X]  *Stream API*
- [X]  *Optional*

**Java Multithreading:**

- [X]  *Thread Life Circle, состояние объекта Thread*
- [X]  *DeadLock, LifeLick, Race condition*

**Java Collections:**

 - **Map:**
 - [X] *HashMap*
 - [X] *LinkedHashMap*
 - [X] *TreeMap*

 - **List:**
 - [X] *ArrayList*
 - [X] *LinkedList*

 - **Set:**
 - [X] *HashSet*
 - [X] *LinkedHashSet*
 - [X] *TreeSet*

 - **Spring:**

 - [X] *XML-based Configuration*
 - [X] *Annotation-based Configuration*
 - [X] *Java-based Configuration*

**Hibernate:**

- [X]  *Работа с entity*
- [X]  *HQL*
 
- [ ]  **Gradle**  

- [X]  **Maven**  
 
- [X]  **Apache-Tomcat:**

**SQL:**

- [X]  *Basic SQL Syntax*
- [X]  *JDBC*
- [X]  *Prepared statement*

**Git:**

- [X]  *First commit*
- [X]  [*New branch*](https://git-scm.com/book/ru/v2/Ветвление-в-Git-Основы-ветвления-и-слияния)
- [X]  *Git push*
- [X]  *Git fetch*
- [X]  *Git pull*
- [X]  *Git merge*
- [X]  *Git rebase*
- [X]  *Cerry-pick*
- [X]  *Squash*
- [X]  *Patch*
- [X]   *Stash*
- [X]   *Git revert*
- [X]   *Git reset*


**Testing:**

- [X]  *Mockito*
- [X]  *jupiter*
- [X]  *ParameterizedTest*
