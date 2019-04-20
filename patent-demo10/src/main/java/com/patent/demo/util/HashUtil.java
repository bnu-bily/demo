package com.patent.demo.util;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashUtil {

    public static byte[] hash(byte[] datasource) {
        MessageDigest messageDigest;
        byte[] result = null;
        try {
            messageDigest = MessageDigest.getInstance("SHA-256");
            result = messageDigest.digest(datasource);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static String hashStr(byte[] datasource) {
        MessageDigest messageDigest;
        String result = null;
        try {
            messageDigest = MessageDigest.getInstance("SHA-256");

            result = safeUrlBase64Encode(messageDigest.digest(datasource));
            //result = byte2Hex(messageDigest.digest(datasource));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static byte[] hash(String datasource) {
        return hash(datasource.getBytes());
    }

    public static String hashStr(String datasource) {
        return hashStr(datasource.getBytes());
    }

    public static String safeUrlBase64Encode(byte[] data) {
        String encodeBase64 = new BASE64Encoder().encode(data);
        return safeUrlEncode(encodeBase64);
    }

    public static byte[] safeUrlBase64Decode(final String safeBase64Str) throws IOException {
        String base64Str = safeUrlDecode(safeBase64Str);
        return new BASE64Decoder().decodeBuffer(base64Str);
    }

    public static String safeUrlEncode(String key) {
        return key.replace('+', '-').replace('/', '_').replaceAll("=", "");
    }

    public static String safeUrlDecode(String key) {
        String base64Str = key.replace('-', '+');
        base64Str = base64Str.replace('_', '/');
        int mod4 = base64Str.length() % 4;
        if (mod4 > 0) {
            base64Str = base64Str + "====".substring(mod4);
        }
        return base64Str;
    }

    public static void main(String[] args) {
        String data = "hello,world";
        System.out.println(hashStr(data));
    }

    /**
     * 将byte转为16进制
     *
     * @param bytes 数组
     * @return String
     */
    private static String byte2Hex(byte[] bytes) {
        StringBuilder stringBuffer = new StringBuilder();
        String temp;
        for (byte aByte : bytes) {
            temp = Integer.toHexString(aByte & 0xFF);
            if (temp.length() == 1) {
                //1得到一位的进行补0操作
                stringBuffer.append("0");
            }
            stringBuffer.append(temp);
        }
        return stringBuffer.toString();
    }

}
