/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sit.mysit.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jack
 */
public class SHA256Encryptor {
    public static final Logger LOGGER = Logger.getLogger(SHA256Encryptor.class.getSimpleName());
    
    public static String encrypt(String password) {
        String hashPwd = "";
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
                byte[] hash = messageDigest.digest(password.getBytes("UTF-8"));
                StringBuilder stringBuilder = new StringBuilder();
                for(int i=0;i<hash.length;i++){
                    stringBuilder.append(Integer.toString((hash[i] & 0xff) + 0x100,16).substring(1));
                }
                hashPwd = stringBuilder.toString();
                LOGGER.info("HASHPWD: " + hashPwd);
                
            } catch (NoSuchAlgorithmException ex) {
                ex.printStackTrace();
            } catch (UnsupportedEncodingException ex) {
                ex.printStackTrace();
            }
        return hashPwd;
    }
    
}
