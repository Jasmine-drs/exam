package com.drs.shangxuan.tool;

import org.apache.tomcat.util.codec.binary.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.management.openmbean.InvalidKeyException;
import java.io.UnsupportedEncodingException;
import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidParameterSpecException;

/**
 * @author Jasmine-drs
 * @date 2022/8/18 19:34
 */
public class AesCbcUtil {

    /**
     * AES解密
     *
     * @param encryptedData  包括敏感数据在内的完整用户信息的加密数据，
     * @param key            秘钥
     * @param iv             加密算法的初始向量，
     * @param encodingFormat 解密后的结果需要进行的编码
     * @return String
     * @see Exception
     */
    public static String decrypt(String encryptedData, String key, String iv, String encodingFormat) {
//        initialize();

        //被加密的数据
        byte[] dataByte = Base64.decodeBase64(encryptedData);
        //加密秘钥
        byte[] keyByte = Base64.decodeBase64(key);
        //偏移量
        byte[] ivByte = Base64.decodeBase64(iv);


        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");

            SecretKeySpec spec = new SecretKeySpec(keyByte, "AES");

            AlgorithmParameters parameters = AlgorithmParameters.getInstance("AES");
            parameters.init(new IvParameterSpec(ivByte));
            cipher.init(Cipher.DECRYPT_MODE, spec, parameters);// 初始化
            byte[] resultByte = cipher.doFinal(dataByte);
            if (null != resultByte && resultByte.length > 0) {
                return new String(resultByte, encodingFormat);
            }
            return null;//失败则返回空字符串
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException | BadPaddingException |
                 IllegalBlockSizeException | InvalidAlgorithmParameterException | InvalidKeyException |
                 InvalidParameterSpecException | NoSuchPaddingException | java.security.InvalidKeyException e) {
            e.printStackTrace();
        }
        return null;
    }

}
