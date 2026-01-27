package product;

public abstract class Checkbox extends UIElement {
    protected boolean checked;

    protected Checkbox(String text) {
        super(text);
        this.checked = false;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public boolean isChecked() {
        return checked;
    }

    public abstract void display();
}