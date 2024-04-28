package com.example.common.kit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Base64Utils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.SecureRandom;
import java.util.Random;

/**
 * Created by pengrl on 2016/11/1.
 */
public class CodecKit {

    private static final Logger LOGGER = LoggerFactory.getLogger(CodecKit.class);

    public static String urlEncode(String url) {
        try {
            return URLEncoder.encode(url, "UTF-8");
        } catch (Exception e) {
            LOGGER.error("encode url failed.", e);
        }
        return url;
    }

    public static String urlDecode(String url) {
        try {
            return URLDecoder.decode(url, "UTF-8");
        } catch (Exception e) {
            LOGGER.error("decode url failed.", e);
        }
        return url;
    }

    public static String base64Encode(String content) {
        try {
            return Base64Utils.encodeToString(content.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            LOGGER.error("base64 ecode failed,", e);
        }
        return content;
    }

    public static String base64Decode(String content) {
        try {
            return new String(Base64Utils.decodeFromString(content), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            LOGGER.error("base64 ecode failed,", e);
        }
        return content;
    }

    /** 0-9a-zA-Z */
    public static final String CODES64 = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static String randomCode(int length) {
        StringBuffer code = new StringBuffer();
        Random random = new SecureRandom();

        int codeLength = CODES64.length();
        for (int i = 0; i < length; i++) {
            code.append(CODES64.charAt(random.nextInt(codeLength)));
        }
        return code.toString();
    }
}
