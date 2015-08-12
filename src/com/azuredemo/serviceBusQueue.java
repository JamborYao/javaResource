package com.azuredemo;

import com.microsoft.windowsazure.Configuration;
import com.microsoft.windowsazure.services.servicebus.ServiceBusConfiguration;
import com.microsoft.windowsazure.services.servicebus.ServiceBusContract;
import com.microsoft.windowsazure.services.servicebus.ServiceBusService;
import com.microsoft.windowsazure.services.servicebus.models.BrokeredMessage;
import com.microsoft.windowsazure.services.servicebus.models.ReceiveMessageOptions;
import com.microsoft.windowsazure.services.servicebus.models.ReceiveMode;
import com.microsoft.windowsazure.services.servicebus.models.ReceiveQueueMessageResult;

public class serviceBusQueue {

	private	Configuration config =
	        ServiceBusConfiguration.configureWithSASAuthentication(
	                "willtestcsmsg-ns",
	                "RootManageSharedAccessKey",
	                "PkxJ9gJZZkTJbXeV5A8PodmMOHExmgfBBQDv879GC90=",
	                ".servicebus.windows.net"
	                );
	public void ReceiveMessage()
	{
		ServiceBusContract service = ServiceBusService.create(config);
		 ReceiveMessageOptions opts = ReceiveMessageOptions.DEFAULT;
		    opts.setReceiveMode(ReceiveMode.PEEK_LOCK);

		    try{
		    while(true)  {
		         ReceiveQueueMessageResult resultQM =
		                service.receiveQueueMessage("jaqueue", opts);
		        BrokeredMessage message = resultQM.getValue();
		        if (message != null && message.getMessageId() != null)
		        {
		            System.out.println("MessageID: " + message.getMessageId());
		            // Display the queue message.
		            System.out.print("From queue: ");
		            byte[] b = new byte[200];
		            String s = null;
		            int numRead = message.getBody().read(b);
		            while (-1 != numRead)
		            {
		                s = new String(b);
		                s = s.trim();
		                System.out.print(s);
		                numRead = message.getBody().read(b);
		            }
		            System.out.println();
		            System.out.println("Custom Property: " +
		                message.getProperty("MyProperty"));
		            // Remove message from queue.
		            System.out.println("Deleting this message.");
		            //service.deleteMessage(message);
		        }  
		        else  
		        {
		            System.out.println("Finishing up - no more messages.");
		            break;
		            // Added to handle no more messages.
		            // Could instead wait for more messages to be added.
		        }
		    }
		    }
		    catch(Exception e)
		    {
		    	
		    }

	}
}
