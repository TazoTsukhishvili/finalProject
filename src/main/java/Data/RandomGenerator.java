package Data;

import java.util.Random;

public class RandomGenerator {

    public static String generateRandomString(int length) {
        String symbols = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        Random random = new Random();
        StringBuilder sbRandom = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            sbRandom.append(symbols.charAt(random.nextInt(symbols.length())));
        }
        return sbRandom.toString();
    }

    public static String generateRandomInt(int length) {
        String symbols = "0123456789";
        Random random = new Random();
        StringBuilder sbRandom = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            sbRandom.append(symbols.charAt(random.nextInt(symbols.length())));
        }
        return sbRandom.toString();
    }

    public String randomEmail = generateRandomString(8) + "@gmail.com";
    public String randomPassword = generateRandomString(4) + generateRandomInt(4);
    public String randomName = generateRandomString(6);
    public String randomSurname = generateRandomString(10);
}
