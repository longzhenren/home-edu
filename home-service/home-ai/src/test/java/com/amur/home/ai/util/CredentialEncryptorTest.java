package com.amur.home.ai.util;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class CredentialEncryptorTest {

    @Test
    @DisplayName("生成加密密钥")
    void testGenerateKey() throws Exception {
        String key = CredentialEncryptor.generateKey();
        assertNotNull(key);
        assertTrue(key.length() > 0);
    }

    @Test
    @DisplayName("加密和解密")
    void testEncryptAndDecrypt() throws Exception {
        String key = CredentialEncryptor.generateKey();
        String plaintext = "sk-test-api-key-12345";
        String encrypted = CredentialEncryptor.encrypt(plaintext, key);
        assertNotNull(encrypted);
        assertNotEquals(plaintext, encrypted);
        String decrypted = CredentialEncryptor.decrypt(encrypted, key);
        assertEquals(plaintext, decrypted);
    }

    @Test
    @DisplayName("不同明文产生不同密文")
    void testDifferentPlaintexts() throws Exception {
        String key = CredentialEncryptor.generateKey();
        String enc1 = CredentialEncryptor.encrypt("key1", key);
        String enc2 = CredentialEncryptor.encrypt("key2", key);
        assertNotEquals(enc1, enc2);
    }

    @Test
    @DisplayName("错误密钥无法解密")
    void testWrongKey() throws Exception {
        String key1 = CredentialEncryptor.generateKey();
        String key2 = CredentialEncryptor.generateKey();
        String encrypted = CredentialEncryptor.encrypt("secret", key1);
        assertThrows(Exception.class, () -> CredentialEncryptor.decrypt(encrypted, key2));
    }

    @Test
    @DisplayName("长密钥加密")
    void testLongKey() throws Exception {
        String key = CredentialEncryptor.generateKey();
        String longPlaintext = "sk-" + new String(new char[200]).replace("\0", "a");
        String encrypted = CredentialEncryptor.encrypt(longPlaintext, key);
        String decrypted = CredentialEncryptor.decrypt(encrypted, key);
        assertEquals(longPlaintext, decrypted);
    }
}
