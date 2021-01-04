/*******************************************************************************
 * 2020, All rights reserved.
 *******************************************************************************/
package dao;

import business_logic.notification.Channel;
import business_logic.board.Item;
// Start of user code (user defined imports)

// End of user code

/**
 * Description of ChannelDAO.
 * 
 * @author Raphael
 */
public abstract class ChannelDAO implements DAO {
	// Start of user code (user defined attributes for ChannelDAO)

	// End of user code

	/**
	 * The constructor.
	 */
	public ChannelDAO() {
		// Start of user code constructor for ChannelDAO)
		super();
		// End of user code
	}

	/**
	 * create Channel of a said item.
	 * @param item 
	 * @return the channel created
	 */
	public abstract Channel createChannel(Item item);

	/**
	 * delete Channel of a said item.
	 * @param item  
	 * @return a boolean according to the success of delete
	 */
	public abstract Boolean deleteChannel(Item item);
	 
	// Start of user code (user defined methods for ChannelDAO)
	
	// End of user code


}
