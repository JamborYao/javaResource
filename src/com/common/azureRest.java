package com.common;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.UnrecoverableKeyException;

import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;

public class azureRest {
	 public static KeyStore getKeyStore(String keyStoreName, String password) throws IOException
	    {
	        KeyStore ks = null;
	        FileInputStream fis = null;
	        try {
	            ks = KeyStore.getInstance("JKS");
	            char[] passwordArray = password.toCharArray();
	            fis = new java.io.FileInputStream(keyStoreName);
	            ks.load(fis, passwordArray);
	            fis.close();
	             
	        } catch (Exception e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	        finally {
	            if (fis != null) {
	                fis.close();
	            }
	        }
	        return ks;
	    }
	     
	 public static SSLSocketFactory getSSLSocketFactory(String keyStoreName, String password) throws UnrecoverableKeyException, KeyStoreException, NoSuchAlgorithmException, KeyManagementException, IOException {
	        KeyStore ks = getKeyStore(keyStoreName, password);
	        KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance("SunX509");
	        keyManagerFactory.init(ks, password.toCharArray());
	 
	          SSLContext context = SSLContext.getInstance("TLS");
	          context.init(keyManagerFactory.getKeyManagers(), null, new SecureRandom());
	 
	          return context.getSocketFactory();
	    }
	     
	    // Source - http://www.mkyong.com/java/how-to-convert-inputstream-to-string-in-java/
	 public static String getStringFromInputStream(InputStream is) {
	          
	        BufferedReader br = null;
	        StringBuilder sb = new StringBuilder();
	  
	        String line;
	        try {
	  
	            br = new BufferedReader(new InputStreamReader(is));
	            while ((line = br.readLine()) != null) {
	                sb.append(line);
	            }
	  
	        } catch (IOException e) {
	            e.printStackTrace();
	        } finally {
	            if (br != null) {
	                try {
	                    br.close();
	                } catch (IOException e) {
	                    e.printStackTrace();
	                }
	            }
	        }
	  
	        return sb.toString();
	  
	    }
}
