import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.KeyStore;
import java.security.KeyStore.ProtectionParameter;
import java.security.KeyStore.SecretKeyEntry;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.UnrecoverableEntryException;
import java.security.cert.CertificateException;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

// reference: https://www.tutorialspoint.com/java_cryptography/java_cryptography_storing_keys.htm
// reference: http://tutorials.jenkov.com/java-cryptography/index.html
public class KeyManager {
	private char[] password;
	private String keyFile;
	private KeyStore keyStore = null; 
	private SecretKey secretKey = null;
	
	public KeyManager(String password, String keyFile) throws Exception{
		this.password = password.toCharArray();
		this.keyFile = keyFile;
	    keyStore = KeyStore.getInstance("JCEKS");
	    keyStore.load(null,null);
	}
	
	public void loadKeys() throws NoSuchAlgorithmException, CertificateException, IOException, UnrecoverableEntryException, KeyStoreException {
		// load key file using the key path and the password (defined in constructor)
		FileInputStream fis = new FileInputStream(keyFile);
		keyStore.load(fis, password);
		
		ProtectionParameter protectionParam = new KeyStore.PasswordProtection(password);
	    SecretKeyEntry secretKeyEnt = (SecretKeyEntry)keyStore.getEntry("alias", protectionParam);
	    
	    // set private variable secretKey
	    secretKey = secretKeyEnt.getSecretKey();
	    // System.out.println(secretKey.toString());
	}
	
	public void createExportKey() throws KeyStoreException, NoSuchAlgorithmException, CertificateException, IOException {
		
		// define protection parameter
		ProtectionParameter protectionParam = new KeyStore.PasswordProtection(this.password);
		
		// generate secret key
		// SecretKey mySecretKey = new SecretKeySpec(new String(this.password).getBytes(), "AES");
		KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");

		SecureRandom secureRandom = new SecureRandom();
		int keyBitSize = 256;
		keyGenerator.init(keyBitSize, secureRandom);

		SecretKey secretKey = keyGenerator.generateKey();
		
		SecretKeyEntry secretKeyEntry = new KeyStore.SecretKeyEntry(secretKey);
		
		// add protection parameter, key entry to keystore entry
		keyStore.setEntry("alias", secretKeyEntry, protectionParam);
		
		// save keystore
		FileOutputStream fos = new FileOutputStream(keyFile);
		keyStore.store(fos, password);
	}

	public SecretKey getSecretKey() {
		return secretKey;
	}
	
}
