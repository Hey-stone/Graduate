package  com.stone.util;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class DES {
	
    private static byte[] iv = { 1, 2, 3, 4, 5, 6, 7, 8 };
    private BASE64Encoder encoder = new BASE64Encoder();
    private BASE64Decoder decoder = new BASE64Decoder();
    
    public final SecretKeySpec key;
    
    public DES(String key){
    	if(key.length()<8){
    		throw new RuntimeException("Key is Error,must be 8 byte");
    	}
    	key = key.substring(0, 8);
    	if(key.getBytes().length!=8){
    		throw new RuntimeException("Key is Error,must be 8 byte");
    	}
    	
    	this.key = new SecretKeySpec(key.getBytes(), "DES");
    }
    
    
    /**
     * 加密
     * @param encryptString
     * @return
     */
    public synchronized String encryptDES(String encryptString){
    	try{
    		    IvParameterSpec zeroIv = new IvParameterSpec(iv);
    	        Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
    	        cipher.init(Cipher.ENCRYPT_MODE, key, zeroIv);
    	        byte[] encryptedData = cipher.doFinal(encryptString.getBytes());
    	        
    	        return  encoder.encode(encryptedData);
    	}catch (Exception e) {
    		throw new RuntimeException(e);
    	}
    }
    
    
    /**
     * 解密
     * @param decryptString
     * @return
     */
     public synchronized String decryptDES(String decryptString){
    	 
    	 try{
    		 byte[] byteMi = decoder.decodeBuffer(decryptString);
             IvParameterSpec zeroIv = new IvParameterSpec(iv);
             Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
             cipher.init(Cipher.DECRYPT_MODE, key, zeroIv);
             byte decryptedData[] = cipher.doFinal(byteMi);

             return new String(decryptedData);
    	 }catch (Exception e) {
    		 throw new RuntimeException(e);
    	 }
      }
     public static void main(String[] args) {
    	 DES des = new DES("20150410");
    	 System.out.println(des.encryptDES("20150410130436712120976"));
	}
}