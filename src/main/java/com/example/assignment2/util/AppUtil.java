package com.example.assignment2.util;

import java.util.Base64;
import java.util.UUID;

public class AppUtil {

    public static String generateCustomerId(){
        return "CUSTOMER-" + UUID.randomUUID();
    }

    public static String generateItemId(){
        return "ITEM-" + UUID.randomUUID();
    }

    public static String generateOrderId(){
        return "ORDER-" + UUID.randomUUID();
    }

    public static String profilePicToBase64(byte[] profilePic){
        return Base64.getEncoder().encodeToString(profilePic);
    }
}
