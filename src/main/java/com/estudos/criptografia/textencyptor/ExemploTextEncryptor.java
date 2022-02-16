package com.estudos.criptografia.textencyptor;

import org.springframework.security.crypto.keygen.KeyGenerators;

public class ExemploTextEncryptor {

    public static void main(String[] args) {

            String nomeEncriptografado = CriptoTextEncryptor.encrypt("rafael");
            System.out.println("Texto Original: " + "rafael");
            System.out.println("Texto Criptografado: " + nomeEncriptografado);

            String descriptografado = CriptoTextEncryptor.decrypt(nomeEncriptografado);
            System.out.println("Texto Descriptografado: " + descriptografado);
        }
    }



