package printer;

public abstract class PrinterDecorator implements Printer {
    protected final Printer delegate;

    protected PrinterDecorator(Printer delegate) {
        if (delegate == null) {
            throw new IllegalArgumentException("Delegate printer must not be null");
        }
        this.delegate = delegate;
    }
}