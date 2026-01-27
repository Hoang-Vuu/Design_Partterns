package product.a;

import product.TextField;

public class TextFieldA extends TextField {
    public TextFieldA(String text) {
        super(text);
    }

    @Override
    public void display() {
        System.out.println(box(text, '+', '+', '+', '+', '-', '|', 1));
    }
}