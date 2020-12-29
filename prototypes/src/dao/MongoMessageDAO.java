/*******************************************************************************
 * 2020, All rights reserved.
 *******************************************************************************/
package dao;

import java.util.HashSet;

import business_logic.notification.Channel;
import business_logic.notification.Message;

// Start of user code (user defined imports)

// End of user code

/**
 * Description of MongoMessageDAO.
 * 
 * @author Raphael
 */
public class MongoMessageDAO extends MessageDAO {
	// Start of user code (user defined attributes for MongoMessageDAO)

	// End of user code

	/**
	 * The constructor.
	 */
	public MongoMessageDAO() {
		// Start of user code constructor for MongoMessageDAO)
		super();
		// End of user code
	}

	/**
	 * Description of the method createMessage.
	 * @param message 
	 * @param channel; Channel 
	 * @return 
	 */
	public Message createMessage(String message, Channel channel) {
		// Start of user code for method createMessage
		Message createMessage = null;
		return createMessage;
		// End of user code
	}

	/**
	 * Description of the method deleteMessage.
	 * @param message 
	 * @return 
	 */
	public Boolean deleteMessage(Message message) {
		// Start of user code for method deleteMessage
		Boolean deleteMessage = Boolean.FALSE;
		return deleteMessage;
		// End of user code
	}

	/**
	 * Description of the method retrieveAllChannelMessages.
	 * @param channel 
	 * @return 
	 */
	public HashSet<Message> retrieveAllChannelMessages(Channel channel) {
		// Start of user code for method retrieveAllChannelMessages
		HashSet<Message> retrieveAllChannelMessages = new HashSet<Message>();
		return retrieveAllChannelMessages;
		// End of user code
	}

	// Start of user code (user defined methods for MongoMessageDAO)

	// End of user code

}
