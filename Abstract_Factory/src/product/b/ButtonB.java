package product.b;

import product.Button;

public class ButtonB extends Button {
    public ButtonB(String text) {
        super(text);
    }

    @Override
    public void display() {
        String content = "<" + text + ">";
        System.out.println(box(content, '*', '*', '*', '*', '*', '*', 2));
    }
}