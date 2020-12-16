package com.example.configurations;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.io.InputStream;
import java.security.KeyStore;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

@Configuration
public class KeysConfiguration {

    @Value("${KEYSTORE_ALIAS}")
    private String alias;

    @Value("${KEYSTORE_PASSWORD}")
    private String keystorePassword;

    @Value("${KEYSTORE_PRIVATE_KEY_PASSWORD}")
    private String privateKeyPassword;

    @Bean
    public KeyStore keyStore() throws Exception {
        KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());

        try (InputStream stream = new ClassPathResource("keystore.jks").getInputStream()) {
            keyStore.load(stream, keystorePassword.toCharArray());
        }

        return keyStore;
    }

    @Bean
    public RSAPrivateKey rsaPrivateKey(KeyStore keyStore) throws Exception {
        return (RSAPrivateKey) keyStore.getKey(alias, privateKeyPassword.toCharArray());
    }

    @Bean
    public RSAPublicKey rsaPublicKey(KeyStore keyStore) throws Exception {
        return (RSAPublicKey) keyStore.getCertificate(alias).getPublicKey();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

}
