/*
 * This code is sample code, provided as-is, and we make NO 
 * warranties as to its correctness or suitability for any purpose.
 * 
 * We hope that it's useful to you. Enjoy. 
 * Copyright LearningPatterns Inc.
 */
 
package com.javatunes.services;

public class AnotherRunner implements MyRunner{

	MessageService theMessageService;
	public MessageService getTheMessageService() { return theMessageService; }
	public void setTheMessageService(MessageService theMessageService) { this.theMessageService = theMessageService; }
	
	@Override
	public void run(String... arg0) throws Exception {
		System.out.println("*** AnotherRunner.run ***");
		System.out.format("Message is %s\n", theMessageService.getMessage());
		System.out.println();
	}

}
