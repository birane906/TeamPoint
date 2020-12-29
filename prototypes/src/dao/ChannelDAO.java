/*******************************************************************************
 * 2020, All rights reserved.
 *******************************************************************************/
package dao;

import business_logic.notification.Channel;

import java.util.Date;

import business_logic.board.Item;
import dao.DAO;
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
	 * Description of the method createChannel.
	 * @param item 
	 * @return 
	 */
	public abstract Channel createChannel(Item item);

	/**
	 * Description of the method deleteChannel.
	 * @param item 
	 * @return 
	 */
	public abstract Boolean deleteChannel(Item item);
	 
	// Start of user code (user defined methods for ChannelDAO)
	
	// End of user code


}
