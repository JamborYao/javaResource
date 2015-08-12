package com.azuredemo;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;

import javax.swing.JOptionPane;

import com.common.AzureSettings;
import com.microsoft.azure.storage.CloudStorageAccount;
import com.microsoft.azure.storage.blob.BlobOutputStream;
import com.microsoft.azure.storage.blob.CloudBlobClient;
import com.microsoft.azure.storage.blob.CloudBlobContainer;
import com.microsoft.azure.storage.blob.CloudBlockBlob;

public class uploadToStorage implements AzureSettings {

	private String filePath;
	private String fileName;

	public uploadToStorage() {
		// TODO Auto-generated constructor stub
		fileName = "Dummy data export (   %      .+,@$#=`~^{}) 14 June 2015 - 28 June 2015.zip";
		filePath = "C:\\Users\\v-jayao\\Downloads\\" + fileName;

	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public void upload() {
		try {
			CloudStorageAccount accountAccount = CloudStorageAccount
					.parse(storageConnection);
			CloudBlobClient accouBlobClient = accountAccount
					.createCloudBlobClient();
			CloudBlobContainer blobContainer = accouBlobClient
					.getContainerReference("jambor2");
			CloudBlockBlob blockBlob = blobContainer.getBlockBlobReference(fileName);
			File source = new File(filePath);
			blockBlob.upload(new FileInputStream(source), source.length());
			
			JOptionPane.showMessageDialog(null, "upload successful");

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public void readBlob()
	{
		try {
			CloudStorageAccount account = CloudStorageAccount
					.parse(AzureSettings.storageConnection);
			CloudBlobClient blobClient = account.createCloudBlobClient();
			CloudBlobContainer container = blobClient
					.getContainerReference("mycontainer");
			container.createIfNotExists();
			CloudBlockBlob blockBlob = container
					.getBlockBlobReference("test.txt");
			BlobOutputStream blobOutputStream = blockBlob.openOutputStream();
			String content = "hello, I want to input some information to test.txt file.";
			byte[] buffer = content.getBytes();
			ByteArrayInputStream inputStream = new ByteArrayInputStream(buffer);
			int next = inputStream.read();
			while (next != -1) {
				blobOutputStream.write(next);
				next = inputStream.read();
			}
			blobOutputStream.close();
		} catch (Exception e) {

		}
	}
}
