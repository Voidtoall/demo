package com.example.common.kit;


import com.example.common.exception.EncryptionException;
import com.example.common.exception.InvalidTokenException;
import com.example.common.exception.TokenExpiredException;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.tuple.Pair;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AESKit {
	
    private static final Logger logger = LoggerFactory.getLogger(AESKit.class);
    public static final long DEFAULT_TOKEN_EXPIRE_TIME = 86400000L * 7;// 7 days
    
    private AES aes;

    public AESKit(String iv, String key) {
        aes = new AES(iv, key);
    }
    
    public static AESKit me(){
    	return new AESKit("hdgsftahtgfjdhgr","ikjhdbsncgtrhdjg");
    }

    public String encrypt(String plainText) throws EncryptionException {
        try {
            return Base64.encodeBase64String(aes.encrypt(plainText));
        } catch (EncryptionException e) {
            logger.error("error encrypt plainText", e);
            throw e;
        }
    }

    public String decrypt(String cipherText) throws EncryptionException {
        try {
            return new String(aes.decrypt(Base64.decodeBase64(cipherText)));
        } catch (EncryptionException e) {
            logger.error("error decrypt cipherText:" + cipherText, e);
            throw e;
        }
    }

    public String generateToken(String input, long expireTime) {
        return encrypt(input + "_" + (System.currentTimeMillis() + expireTime));
    }

    public String generateToken(String input) {
        return generateToken(input, DEFAULT_TOKEN_EXPIRE_TIME);
    }

    public int parseToken(String token) throws InvalidTokenException {
        if (token == null) {
            throw new InvalidTokenException(token);
        }
        String decrypted;
        try {
            decrypted = decrypt(token);
        } catch (EncryptionException e) {
            throw new InvalidTokenException(token);
        }
        String[] pair = decrypted.split("_");
        if (pair.length != 2) {
            throw new InvalidTokenException(token);
        }
        try {
            Pair<String, Long> result = Pair.of(pair[0], Long.parseLong(pair[1]));
            if (result.getRight() < System.currentTimeMillis()) {
                throw new TokenExpiredException();
            }
            return Integer.parseInt(result.getLeft());
        } catch (NumberFormatException e) {
            throw new InvalidTokenException(token);
        }

    }
    
    public int parseTokenIgnoreTime(String token) throws InvalidTokenException {
        if (token == null) {
            throw new InvalidTokenException(token);
        }
        String decrypted;
        try {
            decrypted = decrypt(token);
        } catch (EncryptionException e) {
            throw new InvalidTokenException(token);
        }
        String[] pair = decrypted.split("_");
        if (pair.length != 2) {
            throw new InvalidTokenException(token);
        }
        try {
            Pair<String, Long> result = Pair.of(pair[0], Long.parseLong(pair[1]));
            return Integer.parseInt(result.getLeft());
        } catch (NumberFormatException e) {
            throw new InvalidTokenException(token);
        }
    }

    public static final void main(String[] args) throws InterruptedException {  
    	
       String code = AESKit.me().generateToken("11",DateTime.now().plusYears(1).getMillis());
        System.out.println(code);
        int ee = AESKit.me().parseToken(code);
        System.out.println(ee);

    }

}
