package printer;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class EncryptedPrinter extends PrinterDecorator {

    private final String key;

    /**
     * Sử dụng key mặc định "secret".
     */
    public EncryptedPrinter(Printer delegate) {
        this(delegate, "secret");
    }

    /**
     * Cho phép truyền key tuỳ chọn.
     */
    public EncryptedPrinter(Printer delegate, String key) {
        super(delegate);
        if (key == null || key.isEmpty()) {
            throw new IllegalArgumentException("Encryption key must not be null or empty");
        }
        this.key = key;
    }

    @Override
    public void print(String message) {
        String cipherText = encrypt(message, key);
        delegate.print(cipherText);
    }

    /**
     * Mã hoá: XOR từng byte với key (lặp lại) rồi Base64-encode để in ra console.
     */
    public static String encrypt(String plainText, String key) {
        if (plainText == null) plainText = "";
        byte[] data = plainText.getBytes(StandardCharsets.UTF_8);
        byte[] k = key.getBytes(StandardCharsets.UTF_8);
        byte[] out = new byte[data.length];

        for (int i = 0; i < data.length; i++) {
            out[i] = (byte) (data[i] ^ k[i % k.length]);
        }
        return Base64.getEncoder().encodeToString(out);
    }

    /**
     * Giải mã: Base64-decode rồi XOR ngược lại với cùng key.
     */
    public static String decrypt(String base64Cipher, String key) {
        byte[] enc = Base64.getDecoder().decode(base64Cipher);
        byte[] k = key.getBytes(StandardCharsets.UTF_8);
        byte[] out = new byte[enc.length];

        for (int i = 0; i < enc.length; i++) {
            out[i] = (byte) (enc[i] ^ k[i % k.length]);
        }
        return new String(out, StandardCharsets.UTF_8);
    }
}