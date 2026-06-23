package com.snhu.sslserver;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

import org.apache.tomcat.util.buf.HexUtils;
import org.springframework.boot.SpringApplication;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SslServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SslServerApplication.class, args);
    }

    @GetMapping("/hash")
    public String checksum() {

        String data = "Dhandeaka Harris-Kearse CS305 Project Two";

        try {

            // SHA-256
            MessageDigest sha256 = MessageDigest.getInstance("SHA-256");
            String checksum = HexUtils.toHexString(
                    sha256.digest(data.getBytes(StandardCharsets.UTF_8)));

            // MD2
            MessageDigest md2 = MessageDigest.getInstance("MD2");
            String md2hex = HexUtils.toHexString(
                    md2.digest(data.getBytes(StandardCharsets.UTF_8)));

            // AES Key
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
            keyGenerator.init(128);
            Key key = keyGenerator.generateKey();

            String keyString = java.util.Base64.getEncoder()
                    .encodeToString(key.getEncoded());

            // Encrypt
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] encrypted = cipher.doFinal(data.getBytes(StandardCharsets.UTF_8));
            String encryptedHex = HexUtils.toHexString(encrypted);

            // Decrypt
            cipher.init(Cipher.DECRYPT_MODE, key);
            byte[] decrypted = cipher.doFinal(encrypted);
            String decryptedText = new String(decrypted, StandardCharsets.UTF_8);

            return "data: " + data +
                   "<br><br>checksum: " + checksum +
                   "<br><br>md2hex: " + md2hex +
                   "<hr>" +
                   "<br>key: " + keyString +
                   "<br><br>encrypted: " + encryptedHex +
                   "<br><br>decrypted: " + decryptedText;

        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }
}