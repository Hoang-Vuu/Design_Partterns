package product.b;

import product.TextField;

public class TextFieldB extends TextField {
    public TextFieldB(String text) {
        super(text);
    }

    @Override
    public void display() {
        String content = "\"" + text + "\"";
        System.out.println(box(content, '#', '#', '#', '#', '=', '#', 1));
    }
}