package product;

public abstract class TextField extends UIElement {
    protected TextField(String text) {
        super(text);
    }

    public abstract void display();
}