/*******************************************************************************
 * 2020, All rights reserved.
 *******************************************************************************/
package business_logic.board.types;

/**
 * Type used in a {@link Column} to specify a text field
 *
 * @author Salim Azharhoussen, Birane Ba, Raphael Bourret, Nicolas Galois
 */
public class TextType extends Type {
	/**
	 * The text of the {@link TextType}
	 */
	private String text;
	
	/**
	 * The limit of characters allowed in the text field
	 */
	private int charLimit;

	/**
	 * Create a {@link TextType} giving a text and a character number limit
	 * @param text
	 * @param charLimit
	 */
	public TextType(String text, int charLimit, int id, String nameType, String description) throws Exception {
		super(id, nameType, description);
		if (text.length() > charLimit) {
			throw new Exception("The text is too long.");
		}
		this.text = text;
		this.charLimit = charLimit;
	}

	/**
	 * @return The text of the {@link TextType}
	 */
	public String getText() {
		return this.text;
	}
	
	/**
	 * Sets the text of the {@link TextType}
	 * @param text The new text of the {@link TextType}
	 */
	public void setText(String text) throws Exception {
		if (text.length() > this.charLimit) {
			throw new Exception("The text is too long.");
		}
	    this.text = text;
	}

	/**
	 * @return The limit of characters allowed in the text field
	 */
	public int getCharLimit() {
		return this.charLimit;
	}
	
	/**
	 * Sets the limit of characters for the text field
	 * @param newCharLimit The limit of the text field of the {@link TextType}
	 */
	public void setCharLimit(int newCharLimit) throws Exception {
		if (this.text.length() > charLimit) {
			throw new Exception("Character limit is too low for current text field.");
		}
	    this.charLimit = newCharLimit;
	}



}
