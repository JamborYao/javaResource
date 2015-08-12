package com.common;

public interface AzureSettings {

	String subscriptionId="5c99153f-be77-49ec-bbaa-107014e5dc69";
	String storageConnection  =
		    "DefaultEndpointsProtocol=https;" +
		    	    "AccountName=danielfiletest;" +
		    	    "AccountKey=NntZ4wYSLxyqxLJXTJUSCUscmZdO6BKN0KmZQU7pIUd31dba/k38T1jYimo+TuVy1EFrlJURWPFJ23RALur0Bw==";
	
	String keyStorePath="D:\\OpenSource\\java\\bin\\AzureKeyStore.jks";
	String keyStorePassword="test123";
	
	String sqlconnectionString="jdbc:sqlserver://cdf5wkfy87.database.windows.net:1433;"
			+ "database=javasql;user=jambor@cdf5wkfy87;password=123Aking;encrypt=true;"
			+ "hostNameInCertificate=*.database.windows.net;loginTimeout=30;";

    
	
}
