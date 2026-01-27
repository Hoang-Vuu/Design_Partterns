package product;

public abstract class Button extends UIElement {
    protected Button(String text) {
        super(text);
    }

    public abstract void display();
}
