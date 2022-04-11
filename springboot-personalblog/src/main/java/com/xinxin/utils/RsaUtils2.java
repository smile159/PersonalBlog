package com.xinxin.utils;

import cn.hutool.crypto.asymmetric.RSA;
import com.sun.org.apache.bcel.internal.generic.DADD;
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

/**
 * @author smile
 * @ClassName RsaUtils2.java
 * @Description RSA非对称加密工具类
 * @createTime 2022年04月11日 15:23:00
 */
public class RsaUtils2 {
    //使用的加密算法
    private static final String RSA_ALGORITHM ="RSA";
    //默认的密钥长度 （1024、2048）
    private static final int defaultKeySize = 1024;


    public static void main(String[] args) throws Exception {
        //String pk = "4155a41d15ad1w5q";
        //String prk = "awd4qw84eq8w4e8";
        //KeyStore keyStore = new KeyStore(pk,prk);
        //System.out.println(keyStore.publicKey);
        //System.out.println(keyStore.privateKey);
        //创建密钥对
        String s = "我是要加密的内容";
        //创建密钥对
        KeyStore keys = createKeys();
        //根据创建出来的公钥对字符串s进行加密
        String s1 = encryptByPublicKey(s, keys.publicKey);
        //输出加密后的字符
        String s2 = decryptByPrivateKey(s1, keys.privateKey);
        System.out.println(s2);
    }

    //生成密钥对,使用
    public static KeyStore createKeys() throws NoSuchAlgorithmException {
        //根据工厂方法实例化密钥生成器对象
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(RSA_ALGORITHM);
        //设定密钥长度
        keyPairGenerator.initialize(defaultKeySize);
        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        //公钥
        byte[] publicKey = keyPair.getPublic().getEncoded();
        //私钥
        byte[] privateKey = keyPair.getPrivate().getEncoded();
        return new KeyStore(publicKey,privateKey);
    }


    //获取base64编码后的公钥
    public String getPublicKeyToBase64(KeyStore keyStore){
        return Base64.encode(keyStore.publicKey);
    }


    //获取base64编码后的私钥
    public String getPrivateKeyToBase64(KeyStore keyStore){
        return Base64.encode(keyStore.privateKey);
    }


    //公钥加密
    public static String encryptByPublicKey(String data,byte[] key) throws NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        KeyFactory keyFactory = KeyFactory.getInstance(RSA_ALGORITHM);
        //将byte类型的密钥编码成PublicKey类型的
        X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(key);
        //根据keyfactory得到公钥
        PublicKey publicKey = keyFactory.generatePublic(x509EncodedKeySpec);
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
        cipher.init(Cipher.ENCRYPT_MODE,publicKey);
        return Base64.encode(cipher.doFinal(data.getBytes()));
    }


    //公钥解密
    public static byte[] decryptByPublicKey(byte[] data,byte[] key) throws NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException{
        KeyFactory keyFactory = KeyFactory.getInstance(RSA_ALGORITHM);
        X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(key);
        PublicKey publicKey = keyFactory.generatePublic(x509EncodedKeySpec);
        //根据rsa算法传入cipher得到解密对象
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
        //设置为解密模式，并将publickey传入
        cipher.init(Cipher.DECRYPT_MODE,publicKey);
        return cipher.doFinal(data);
    }


    /**
     * 私钥解密
     * @param data 待解密数据
     * @param key 密钥
     * @return byte[] 解密数据
     * */
    public static String decryptByPrivateKey(String data,byte[] key) throws Exception{
        //取得私钥
        PKCS8EncodedKeySpec pkcs8KeySpec=new PKCS8EncodedKeySpec(key);
        KeyFactory keyFactory=KeyFactory.getInstance(RSA_ALGORITHM);
        //生成私钥
        PrivateKey privateKey=keyFactory.generatePrivate(pkcs8KeySpec);
        //数据解密
        Cipher cipher=Cipher.getInstance(keyFactory.getAlgorithm());
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        return new String(cipher.doFinal(Base64.decode(data)));
    }





    @Data
    @AllArgsConstructor
    static class KeyStore{
        //存储公钥
        public byte[] publicKey;
        //存储私钥
        public byte[] privateKey;
    }
}
