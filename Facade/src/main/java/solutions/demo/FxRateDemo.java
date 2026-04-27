package solutions.demo;

import solutions.facade.ApiFacade;

public class FxRateDemo {

    public static void main(String[] args) {
        ApiFacade facade = new ApiFacade();

        try {
            String baseCurrency = facade.getAttributeValueFromJson(
                    "https://api.fxratesapi.com/latest",
                    "base"
            );

            System.out.println("Base currency: " + baseCurrency);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}