package product.b;

import product.Checkbox;

public class CheckboxB extends Checkbox {
    public CheckboxB(String text) {
        super(text);
    }

    @Override
    public void display() {
        String mark = checked ? "✓" : " ";
        System.out.println("(" + mark + ") " + text);
    }
}
