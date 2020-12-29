package gui.view;

import gui.controller.*;

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

	/**
	 * The constructor.
	 */
	public CellView() {
		super();
	}

	/**
	 * Description of the method displayEdit.
	 */
	public abstract void displayEdit();
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
