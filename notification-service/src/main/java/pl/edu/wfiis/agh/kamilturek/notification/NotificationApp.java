package pl.edu.wfiis.agh.kamilturek.notification;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class NotificationApp {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(NotificationApp.class, args);
        System.out.println(context.getBean(A.class));
    }

    @Component
    class A {
        @Value("${author.firstname}")
        private String name;

        @Override
        public String toString() {
            return "A{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }
}
