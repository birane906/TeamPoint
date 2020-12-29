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
	 * Description of the method createMessage.
	 * @param message 
	 * @param channel; Channel 
	 * @return 
	 */
	public abstract Message createMessage(String message, Channel channel);

	/**
	 * Description of the method deleteMessage.
	 * @param message 
	 * @return 
	 */
	public abstract Boolean deleteMessage(Message message);

	/**
	 * Description of the method retrieveAllChannelMessages.
	 * @param channel 
	 * @return 
	 */
	public abstract HashSet<Message> retrieveAllChannelMessages(Channel channel);
	 
	// Start of user code (user defined methods for MessageDAO)
	
	// End of user code


}
