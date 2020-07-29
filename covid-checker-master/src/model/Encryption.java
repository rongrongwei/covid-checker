import java.io.File;
import javax.crypto.Cipher;

/*
 * use AES (Symmetric) encryption
 * created by Rongrong Wei
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
		System.out.println(inputData);
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
