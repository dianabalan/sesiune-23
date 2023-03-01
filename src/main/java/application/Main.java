package application;

import model.Person;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        Person person = new Person();

        Person person1 = new Person("123", "andreea", LocalDate.now());

        person1.getCnp();
        person1.getName();

        person1.setName("ddd");

        System.out.println(person1);

        String str= "string ssss";

        person1.method1(str);

        Person person2 = Person.builder()
                .cnp("cnp person 2")
                .build();
        System.out.println(person2);


        Person person3 = Person.builder()
                .cnp("hhhh")
                .name("diana")
                .build();
        System.out.println(person3);

        Person person4 = Person.builder()
                .cnp("123")
                .name("annna")
                .birthDate(LocalDate.now())
                .build();
        System.out.println(person4);
    }
}
