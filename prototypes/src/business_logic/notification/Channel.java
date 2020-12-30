/*******************************************************************************
 * 2020, All rights reserved.
 *******************************************************************************/
package business_logic.notification;

// Start of user code (user defined imports)

// End of user code

import business_logic.board.Item;

import java.util.HashSet;

/**
 * Description of Channel.
 * 
 * @author Raphael
 */
public class Channel {
	/**
	 * Description of the property item.
	 */
	public Item item = null;
	
	/**
	 * Description of the property messages.
	 */
	public HashSet<Message> messages = new HashSet<Message>();
	
	// Start of user code (user defined attributes for Channel)
	
	// End of user code
	
	
	// Start of user code (user defined methods for Channel)
	
	// End of user code
	/**
	 * Returns item.
	 * @return item 
	 */
	public Item getItem() {
		return this.item;
	}
	
	/**
	 * Sets a value to attribute item. 
	 * @param newItem 
	 */
	/*
	public void setItem(Item newItem) {
		if(this.item != null) {
			this.item.set
			(null);
		}
		this.item.set
		(this);
	}
	 */

	/**
	 * Returns messages.
	 * @return messages 
	 */
	public HashSet<Message> getMessages() {
		return this.messages;
	}



}
