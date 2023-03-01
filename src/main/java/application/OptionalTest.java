package application;

import java.util.Optional;

public class OptionalTest {

    public static void main(String[] args) {


        Optional<String> str = Optional.of("abc");

        Optional<String> str1 = Optional.empty();

        if (str1.isPresent()){
            System.out.println("We have a value: "+str.get());
        } else{
            System.out.println("Empty optional");
        }


    }
}
