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
 * Description of MySQLMessageDAO.
 * 
 * @author Raphael
 */
public class MySQLMessageDAO extends MessageDAO {
	// Start of user code (user defined attributes for MySQLMessageDAO)

	// End of user code

	/**
	 * The constructor.
	 */
	public MySQLMessageDAO() {
		// Start of user code constructor for MySQLMessageDAO)
		super();
		// End of user code
	}

	/**
	 * create Message on a channel.
	 * @param message String
	 * @param channel {@link Channel}
	 * @return the message create
	 */
	public Message createMessage(String message, Channel channel) {
		// Start of user code for method createMessage
		Message createMessage = null;
		return createMessage;
		// End of user code
	}

	/**
	 * delete a Message.
	 * @param message that will be deleted
	 * @return a boolean according to the success of delete
	 */
	public Boolean deleteMessage(Message message) {
		// Start of user code for method deleteMessage
		Boolean deleteMessage = Boolean.FALSE;
		return deleteMessage;
		// End of user code
	}

	/**
	 * retrieveAllChannelMessages.
	 * @param channel we want the message from
	 * @return a hashSet of all messages and their creator {@link User}
	 */
	public HashSet<Message> retrieveAllChannelMessages(Channel channel) {
		// Start of user code for method retrieveAllChannelMessages
		HashSet<Message> retrieveAllChannelMessages = new HashSet<Message>();
		return retrieveAllChannelMessages;
		// End of user code
	}

	// Start of user code (user defined methods for MySQLMessageDAO)

	// End of user code

}
