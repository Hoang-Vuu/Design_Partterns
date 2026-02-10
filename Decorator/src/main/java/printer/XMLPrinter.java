package printer;

public class XMLPrinter extends PrinterDecorator {

    public XMLPrinter(Printer delegate) {
        super(delegate);
    }

    @Override
    public void print(String message) {
        String xml = "<message>" + escapeXml(message) + "</message>";
        delegate.print(xml);
    }

    // Đảm bảo message hợp lệ khi đưa vào XML
    private String escapeXml(String input) {
        if (input == null) return "";
        StringBuilder sb = new StringBuilder(input.length());
        for (char c : input.toCharArray()) {
            switch (c) {
                case '&': sb.append("&amp;"); break;
                case '<': sb.append("&lt;"); break;
                case '>': sb.append("&gt;"); break;
                case '"': sb.append("&quot;"); break;
                case '\'': sb.append("&apos;"); break;
                default: sb.append(c);
            }
        }
        return sb.toString();
    }
}