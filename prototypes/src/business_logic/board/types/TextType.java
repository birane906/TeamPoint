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
	 * Constructor for empty TextType 
	 * charLimit set to 90 (default)
	 * @param id
	 * @param description
	 * @throws Exception
	 */
	public TextType(int id, String description) throws Exception {
		super(id, TextType.class.getSimpleName(), description);
		this.charLimit = 90;
		this.text = "";
	}

	/**
	 * Constructor for TextType filled
	 * charactere limit to 90 (default)
	 * @param id
	 * @param description
	 * @param text
	 * @throws Exception
	 */
	public TextType(int id, String description, String text) throws Exception {
		super(id, TextType.class.getSimpleName(), description);
		this.charLimit = 90;
		if (text.length() > charLimit) {
			throw new Exception("The text is too long.");
		}
		this.text = text;
	}

	public TextType(String text) throws Exception {
		super(TextType.class.getSimpleName(), "text");
		this.charLimit = 90;
		if (text.length() > charLimit) {
			throw new Exception("The text is too long.");
		}
		this.text = text;
	}

	/**
	 * Constructor for TextType filled
	 * charactere limit choosed by the client
	 * @param id
	 * @param description
	 * @param text
	 * @param charLimit
	 * @throws Exception
	 */
	public TextType(int id, String description, String text, int charLimit) throws Exception {
		super(id, TextType.class.getSimpleName(), description);
		this.charLimit = charLimit;
		if (text.length() > charLimit) {
			throw new Exception("The text is too long.");
		}
		this.text = text;
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
