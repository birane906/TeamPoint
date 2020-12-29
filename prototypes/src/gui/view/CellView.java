/*******************************************************************************
 * 2020, All rights reserved.
 *******************************************************************************/
package ui.view;

// Start of user code (user defined imports)

// End of user code

/**
 * Description of CellView.
 * 
 * @author 
 */
public abstract class CellView {
	/**
	 * Description of the property boardController.
	 */
	public BoardController boardController = null;

	// Start of user code (user defined attributes for CellView)

	// End of user code

	/**
	 * The constructor.
	 */
	public CellView() {
		// Start of user code constructor for CellView)
		super();
		// End of user code
	}

	/**
	 * Description of the method displayEdit.
	 */
	public abstract void displayEdit();

	// Start of user code (user defined methods for CellView)

	// End of user code
	/**
	 * Returns boardController.
	 * @return boardController 
	 */
	public BoardController getBoardController() {
		return this.boardController;
	}

	/**
	 * Sets a value to attribute boardController. 
	 * @param newBoardController 
	 */
	public void setBoardController(BoardController newBoardController) {
		if (this.boardController != null) {
			this.boardController.set(null);
		}
		this.boardController.set(this);
	}

}