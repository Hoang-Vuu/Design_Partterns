package product;

public abstract class UIElement {
    protected String text;

    protected UIElement(String text) {
        this.text = text;
    }

    // Common for all UI elements -> should be here
    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    // Helper to draw a simple ASCII box
    protected String box(String content,
                         char tl, char tr, char bl, char br,
                         char h, char v,
                         int padding) {

        String padded = " ".repeat(Math.max(0, padding)) + content + " ".repeat(Math.max(0, padding));
        int width = padded.length();

        String top = tl + String.valueOf(h).repeat(width) + tr;
        String mid = v + padded + v;
        String bot = bl + String.valueOf(h).repeat(width) + br;

        return top + "\n" + mid + "\n" + bot;
    }
}
