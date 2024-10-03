package com.example.assignment2.util;

import java.util.Base64;
import java.util.UUID;

public class AppUtil {

    public static String generateNoteId(){
        return "CUSTOMER-" + UUID.randomUUID();
    }

    public static String generateUserId(){
        return "ITEM-" + UUID.randomUUID();
    }

    public static String profilePicToBase64(byte[] profilePic){
        return Base64.getEncoder().encodeToString(profilePic);
    }
}
