package utils;

import com.github.javafaker.Faker;
import java.util.Random;

public class GenerateTestData {
    public static Faker faker;

    public static int getRandomIndex(int listSize) {
        Random random = new Random();
        return random.nextInt(listSize);
    }

    // ---------------EMAIL----------------------------
    public static String generateEmail() {
        faker = new Faker();
        return faker.letterify("????????@test.ru");
    }


    // --------------------------PASSWORD-----------------------------
    public static String generatePassword() {
        faker = new Faker();
        return faker.letterify("??????Q#1");
    }


    public static String generateName() {
        faker = new Faker();
        return faker.name().firstName();
    }

    public static String generateFullName() {
        faker = new Faker();
        return faker.name().lastName();
    }

}
