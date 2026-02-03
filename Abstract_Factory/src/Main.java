import factory.AFactory;
import factory.BFactory;
import factory.UIFactory;

import product.Button;
import product.TextField;
import product.Checkbox;

public class Main {
    public static void main(String[] args) {
        UIFactory factory = chooseFactory(args);

        Button btn = factory.createButton("OK");
        TextField tf = factory.createTextField("Hello Abstract Factory");
        Checkbox cb = factory.createCheckbox("I agree");

        System.out.println("=== INITIAL UI ===");
        btn.display();
        tf.display();
        cb.display();

        System.out.println("\n=== CHANGE CONTENT DYNAMICALLY ===");
        btn.setText("SUBMIT");
        tf.setText("Text changed!");
        cb.setText("I accept terms");
        cb.setChecked(true);

        btn.display();
        tf.display();
        cb.display();
    }

    private static UIFactory chooseFactory(String[] args) {
        String style = (args.length > 0) ? args[0].trim().toUpperCase() : "A";
        return style.equals("B") ? new BFactory() : new AFactory();
    }
}