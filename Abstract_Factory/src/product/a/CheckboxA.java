package product.a;

import product.Checkbox;

public class CheckboxA extends Checkbox {
    public CheckboxA(String text) {
        super(text);
    }

    @Override
    public void display() {
        String mark = checked ? "x" : " ";
        System.out.println("[" + mark + "] " + text);
    }
}
