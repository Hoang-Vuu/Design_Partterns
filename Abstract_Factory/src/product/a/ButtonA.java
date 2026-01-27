package product.a;

import product.Button;

public class ButtonA extends Button {
    public ButtonA(String text) {
        super(text);
    }

    @Override
    public void display() {
        String content = "[ " + text + " ]";
        System.out.println(box(content, '/', '\\', '\\', '/', '-', '|', 1));
    }
}
