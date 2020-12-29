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
	public abstract Message createMessage(String message, Object channel; Channel);

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

	/**
	 * Description of the method dateFormat.
	 * @param date 
	 * @return 
	 */
	public Object dateFormat(Date date) {
		// Start of user code for method dateFormat
		// End of user code
	}

	/**
	 * Description of the method stringFormat.
	 * @param String str 
	 * @return 
	 */
	public Object stringFormat(String String str) {
		// Start of user code for method stringFormat
		// End of user code
	}
	 
	// Start of user code (user defined methods for MessageDAO)
	
	// End of user code


}
