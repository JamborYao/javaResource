package com.azuredemo;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;

import com.common.azureRest;

public class listAutomation {
	private String subscriptionId;
	private String keyStorePath;
	private String keyStorePassword;
	private String getUrlString;
	private String putUrlString;
	
	public listAutomation() {
		// TODO Auto-generated constructor stub
		subscriptionId="5c99153f-be77-49ec-bbaa-107014e5dc69";
		keyStorePath="D:\\OpenSource\\java\\bin\\AzureKeyStore.jks";
		keyStorePassword="test123";
		getUrlString = "https://management.core.windows.net/5c99153f-be77-49ec-bbaa-107014e5dc69/cloudServices/"
				+ "OaaSCSBBWCYXKOAZOJCWOIRTR6W4JCQOEHLF5OAM4B37RP75UCHQGSDNXA-East-US?"
				+ "resourceType=AutomationAccount&detailLevel=Full&resourceProviderNamespace=automation";
		putUrlString= "https://management.core.windows.net/5c99153f-be77-49ec-bbaa-107014e5dc69/cloudServices/"
				+ "OaaSCSBBWCYXKOAZOJCWOIRTR6W4JCQOEHLF5OAM4B37RP75UCHQGSDNXA-East-US"
				+ "/resources/automation/AutomationAccount/test147?resourceType=AutomationAccount&detailLevel=Full&resourceProviderNamespace=automation";

	}
	
	public String getAutomation() {
		try {	
			String response = processGetRequest(new URL(getUrlString),
					keyStorePath, keyStorePassword);
			String contentString = "<Resource xmlns=\"http://schemas.microsoft.com/windowsazure\"> "
					+ "<CloudServiceSettings> "
					+ " <GeoRegion>East US 2</GeoRegion>"
					+ " </CloudServiceSettings> "
					+ " <SchemaVersion>1.0</SchemaVersion> "
					+ "<Plan>Free</Plan> " + "</Resource>";
			byte[] data = contentString.getBytes();
			
			return response;
		

		} catch (Exception e) {
			// TODO Auto-generated catch block
			return e.getMessage();
		}
	}
	public String putAutomation()
	{
		try {	
			
			String contentString = "<Resource xmlns=\"http://schemas.microsoft.com/windowsazure\"> "
					+ "<CloudServiceSettings> "
					+ " <GeoRegion>East US 2</GeoRegion>"
					+ " </CloudServiceSettings> "
					+ " <SchemaVersion>1.0</SchemaVersion> "
					+ "<Plan>Free</Plan> " + "</Resource>";
			byte[] data=contentString.getBytes();		
			int postresponse = processPostRequest(new URL(putUrlString),data,"application/xml", keyStorePath, keyStorePassword);
			
			
			return postresponse+"";
		

		} catch (Exception e) {
			// TODO Auto-generated catch block
			return e.getMessage();
		}
	}

	public static int processPostRequest(URL url, byte[] data,
			String contentType, String keyStore, String keyStorePassword)
			throws UnrecoverableKeyException, KeyManagementException,
			KeyStoreException, NoSuchAlgorithmException, IOException {
		SSLSocketFactory sslFactory = azureRest.getSSLSocketFactory(keyStore,
				keyStorePassword);
		HttpsURLConnection con = null;
		con = (HttpsURLConnection) url.openConnection();
		con.setSSLSocketFactory(sslFactory);
		con.setDoOutput(true);
		con.setRequestMethod("PUT");
		con.addRequestProperty("x-ms-version", "2013-08-01");
		con.setRequestProperty("Content-Length", String.valueOf(data.length));
		con.setRequestProperty("Content-Type", contentType);

		DataOutputStream requestStream = new DataOutputStream(
				con.getOutputStream());
		requestStream.write(data);
		requestStream.flush();
		requestStream.close();
		return con.getResponseCode();
	}

	public static String processGetRequest(URL url, String keyStore,
			String keyStorePassword) throws UnrecoverableKeyException,
			KeyManagementException, KeyStoreException,
			NoSuchAlgorithmException, IOException {
		SSLSocketFactory sslFactory = azureRest.getSSLSocketFactory(keyStore,
				keyStorePassword);
		HttpsURLConnection con = (HttpsURLConnection) url.openConnection();
		con.setSSLSocketFactory(sslFactory);
		con.setRequestMethod("GET");
		/*
		 * final String DATEFORMAT = "yyyy-MM-dd HH:mm:ss"; final
		 * SimpleDateFormat sdf = new SimpleDateFormat(DATEFORMAT);
		 * sdf.setTimeZone(TimeZone.getTimeZone("UTC")); final String utcTime =
		 * sdf.format(new Date());
		 */

		con.addRequestProperty("x-ms-version", "2013-06-01");
		// con.addRequestProperty("x-ms-date", utcTime);
		// con.addRequestProperty("x-ms-version", "2014-02-01");
		InputStream responseStream = (InputStream) con.getContent();
		String response = azureRest.getStringFromInputStream(responseStream);
		responseStream.close();
		return response;
	}

	public String getSubscriptionId() {
		return subscriptionId;
	}

	public void setSubscriptionId(String subscriptionId) {
		this.subscriptionId = subscriptionId;
	}

	public String getKeyStorPath() {
		return keyStorePath;
	}

	public void setKeyStorPath(String keyStorPath) {
		this.keyStorePath = keyStorPath;
	}

	public String getKeyStorePassword() {
		return keyStorePassword;
	}

	public void setKeyStorePassword(String keyStorePassword) {
		this.keyStorePassword = keyStorePassword;
	}

	public String getRequestUrlString() {
		return getUrlString;
	}

	public void setRequestUrlString(String requestUrlString) {
		this.getUrlString = requestUrlString;
	}

}
