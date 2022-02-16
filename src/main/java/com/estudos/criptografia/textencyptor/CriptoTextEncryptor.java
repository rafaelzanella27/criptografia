package com.estudos.criptografia.textencyptor;

import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.security.crypto.encrypt.TextEncryptor;
import org.springframework.security.crypto.keygen.KeyGenerators;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class CriptoTextEncryptor {

        //Essa senha precisa estar segura
        final static String password = "testeCripto123";
        final static String salt = KeyGenerators.string().generateKey();

        public static String encrypt(String textToEncrypt){
            if (textToEncrypt != null && !textToEncrypt.isEmpty())
            {
                TextEncryptor encryptor = Encryptors.text(password, salt);
                String encryptedText = encryptor.encrypt(textToEncrypt);
                return encryptedText;
            }

            return null;
        }

        public static String decrypt(String encryptedText){
            if(encryptedText != null && !encryptedText.isEmpty())
            {
                TextEncryptor decryptor = Encryptors.text(password, salt);
                String decryptedText = decryptor.decrypt(encryptedText);

                return decryptedText;
            }

            return null;
        }

}

