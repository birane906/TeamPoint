/*******************************************************************************
 * 2020, All rights reserved.
 *******************************************************************************/
package dao;

import business_logic.notification.Channel;
import business_logic.notification.Message;
import dao.DAO;
import java.util.HashSet;
// Start of user code (user defined imports)

// End of user code

/**
 * Description of MessageDAO.
 * 
 * @author Raphael
 */
public abstract class MessageDAO implements DAO {
	// Start of user code (user defined attributes for MessageDAO)

	// End of user code

	/**
	 * The constructor.
	 */
	public MessageDAO() {
		// Start of user code constructor for MessageDAO)
		super();
		// End of user code
	}

	/**
	 * create Message on a channel.
	 * @param message String
	 * @param channel {@link Channel}
	 * @return the message create
	 */
	public abstract Message createMessage(String message, Channel channel);

	/**
	 * delete a Message.
	 * @param message that will be deleted
	 * @return a boolean according to the success of delete
	 */
	public abstract Boolean deleteMessage(Message message);

	/**
	 * retrieveAllChannelMessages.
	 * @param channel we want the message from
	 * @return a hashSet of all messages and their creator {@link User}
	 */
	public abstract HashSet<Message> retrieveAllChannelMessages(Channel channel);
	 
	// Start of user code (user defined methods for MessageDAO)
	
	// End of user code


}
