/*******************************************************************************
 * 2020, All rights reserved.
 *******************************************************************************/
package business_logic.board;

invalid
// Start of user code (user defined imports)

// End of user code

/**
 * Description of TextType.
 * 
 * @author 
 */
public class TextType extends AbstractType implements  {
	/**
	 * Description of the property text.
	 */
	private String text = "";
	
	/**
	 * Description of the property charLimit.
	 */
	private String charLimit = "";
	
	// Start of user code (user defined attributes for TextType)
	
	// End of user code
	
	
	// Start of user code (user defined methods for TextType)
	
	// End of user code
	/**
	 * Returns text.
	 * @return text 
	 */
	public String getText() {
		return this.text;
	}
	
	/**
	 * Sets a value to attribute text. 
	 * @param newText 
	 */
	public void setText(String newText) {
	    this.text = newText;
	}

	/**
	 * Returns charLimit.
	 * @return charLimit 
	 */
	public String getCharLimit() {
		return this.charLimit;
	}
	
	/**
	 * Sets a value to attribute charLimit. 
	 * @param newCharLimit 
	 */
	public void setCharLimit(String newCharLimit) {
	    this.charLimit = newCharLimit;
	}



}
