/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.xml.bind.DatatypeConverter;

/**
 *
 * @author sonthanhnguyen
 */
public class Password {

    public String makePassword(String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(password.getBytes());
        byte[] digest = md.digest();
        String hashedPassword = DatatypeConverter.printHexBinary(digest).toUpperCase();
        return hashedPassword;
    }

    public boolean checkPassword(String password, String retypePassword) {
        if (!password.equals(retypePassword)) {
            return false;
        }
        return true;
    }
    
    public boolean checkPasswordNotNull(String password){
        if(password.equals("")){
            return false;
        }
        return true;
    }
}
