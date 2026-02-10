package printer;

public class Demo {
    public static void main(String[] args) {
        Printer printer = new BasicPrinter();
        printer.print("Hello World!");

        Printer xmlPrinter = new XMLPrinter(new BasicPrinter());
        xmlPrinter.print("Hello World!");

        Printer printer2 = new EncryptedPrinter(new XMLPrinter(new BasicPrinter()));
        printer2.print("Hello World!");

        String xml = "<message>Hello World!</message>";
        String cipher = EncryptedPrinter.encrypt(xml, "secret");
        String plain = EncryptedPrinter.decrypt(cipher, "secret");

        System.out.println("Encrypted sample: " + cipher);
        System.out.println("Decrypted sample: " + plain);
    }
}