package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);

        User user1 = new User("Gimli", "Gloinson", "Myaxecrushurbones@mail.ru");
        User user2 = new User("Frodo", "Baggins", "Mypleasure@mail.ru");
        User user3 = new User("Gandalf", "TheGrey", "Ichangemycolouronceayear@mail.ru");
        User user4 = new User("Gollum", "Smeagol", "iloveriddles@mail.ru");

        Car car1 = new Car("BoevoiBaran", 1);
        Car car2 = new Car("MalenkiiPoni", 11);
        Car car3 = new Car("Shadowfax", 1);
        Car car4 = new Car("Golienogi", 4);

        userService.add(user1.setCar(car1).setUser(user1));
        userService.add(user2.setCar(car2).setUser(user2));
        userService.add(user3.setCar(car3).setUser(user3));
        userService.add(user4.setCar(car4).setUser(user4));


        List<User> users = userService.listUsers();
        for (User user : users) {
            System.out.println("Id = " + user.getId());
            System.out.println("First Name = " + user.getFirstName());
            System.out.println("Last Name = " + user.getLastName());
            System.out.println("Email = " + user.getEmail());
            System.out.println("Car = " + user.getCar());
        }
        System.out.println(userService.getUserByCar("BoevoiBaran",1));

        context.close();
    }
}
