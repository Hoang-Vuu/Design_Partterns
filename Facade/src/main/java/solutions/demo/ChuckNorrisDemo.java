package solutions.demo;

import solutions.facade.ApiFacade;

public class ChuckNorrisDemo {

    public static void main(String[] args) {
        ApiFacade facade = new ApiFacade();

        try {
            String joke = facade.getAttributeValueFromJson(
                    "https://api.chucknorris.io/jokes/random",
                    "value"
            );

            System.out.println("Chuck Norris Joke:");
            System.out.println(joke);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}