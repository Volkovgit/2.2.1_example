package com.example.test2;

import com.example.test2.config.AppConfig;
import com.example.test2.service.CarService;
import com.example.test2.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        UserService userService = (UserService) context.getBean(UserService.class);
        CarService carService = (CarService) context.getBean(CarService.class);

//        Создайте несколько пользователей с машинами,добавьте их в базу данных
//        userService.add(new User("User1", "Lastname1", "user1@mail.ru", new Car("BMW", 1)));
//        userService.add(new User("User2", "Lastname2", "user2@mail.ru", new Car("Lada", 2)));
//        userService.add(new User("User3", "Lastname3", "user3@mail.ru", new Car("GAZ", 3)));
//        userService.add(new User("User4", "Lastname4", "user4@mail.ru", new Car("Suzuki", 4)));

//        вытащите обратно
//        List<User> users = userService.listUsers();
//        for (User user : users) {
//            System.out.println(user);
//        }


//        В сервис добавьте метод, который с помощью hql-запроса будет доставать юзера, владеющего машиной по
//        ее модели и серии.
//        System.out.println(userService.getUserByCar("GAZ", 3));

    }
}