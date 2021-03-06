package model;
import java.io.File;
import javax.crypto.Cipher;

/**
 * This class is used to encrypt Strings to unreadable byte[] sequences
 * This class is also used to decrypt byte[] sequences to readable Strings
 * use AES (Symmetric) encryption
 * @author rongrong
 *
 */


public class Encryption {
	private KeyManager myKey = null;
    private Cipher cipher = null;
	
	public Encryption(String password, String keyFile) throws Exception {
    	cipher = Cipher.getInstance("AES");
    	myKey = new KeyManager(password, keyFile);
		
		File myKeyFile = new File(keyFile);
		if (!myKeyFile.exists()) {
			myKey.createExportKey();
		}
		
		myKey.loadKeys();
	}
	public byte[] encryptData(String inputData) {
		try 
		{
			cipher.init(Cipher.ENCRYPT_MODE, myKey.getSecretKey());
	        byte[] encrypted = cipher.doFinal(inputData.getBytes());
	        return encrypted;
		}
	    catch(Exception e) 
	    {
	    	e.printStackTrace();
	    }
		return null;
	}	

	public String decryptData(byte[] inputData) {
		try 
		{
			cipher.init(Cipher.DECRYPT_MODE, myKey.getSecretKey());
	        byte[] decrypted = cipher.doFinal(inputData);
	        String output = new String(decrypted);
	        return output;
		}
	    catch(Exception e) 
	    {
	    	e.printStackTrace();
	    }
	    return "";

	}
	
	
}
