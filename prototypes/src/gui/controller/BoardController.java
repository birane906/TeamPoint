/*******************************************************************************
 * 2020, All rights reserved.
 *******************************************************************************/
package gui.controller;

import business_logic.*;
import business_logic.board.*;
import business_logic.workspace.*;
import gui.view.*;


/**
 * Description of BoardController.
 * 
 * @author 
 */
public class BoardController {
	/**
	 * Description of the property cellView.
	 */
	public CellView cellView = null;

	/**
	 * Description of the property columnFacade.
	 */
	public ColumnFacade columnFacade = null;

	/**
	 * Description of the property cellFacade.
	 */
	public CellFacade cellFacade = null;

	/**
	 * Description of the property boardFacade.
	 */
	public BoardFacade boardFacade = null;


	/**
	 * The constructor.
	 */
	public BoardController() {
		super();
	}

	/**
	 * Description of the method createBoard.
	 * @param name 
	 * @param workspace 
	 * @return 
	 */
	public Boolean createBoard(String name, Workspace workspace) {
		Boolean createBoard = Boolean.FALSE;
		return createBoard;
	}

	/**
	 * Description of the method deleteBoard.
	 * @param board 
	 * @return 
	 */
	public Boolean deleteBoard(Board board) {
		// Start of user code for method deleteBoard
		Boolean deleteBoard = Boolean.FALSE;
		return deleteBoard;
		// End of user code
	}

	/**
	 * Description of the method retrieveBoard.
	 * @param board 
	 * @return 
	 */
	public Boolean retrieveBoard(Board board) {
		// Start of user code for method retrieveBoard
		Boolean retrieveBoard = Boolean.FALSE;
		return retrieveBoard;
		// End of user code
	}

	/**
	 * Description of the method retrieveColumnTypes.
	 * @return 
	 */
	public Object retrieveColumnTypes() {
		// Start of user code for method retrieveColumnTypes
		// End of user code
		return null;
	}

	/**
	 * Description of the method addColumn.
	 * @param columnName 
	 * @param typeName 
	 * @param board 
	 * @return 
	 */
	public Boolean addColumn(String columnName, String typeName, Board board) {
		// Start of user code for method addColumn
		Boolean addColumn = Boolean.FALSE;
		return addColumn;
		// End of user code
	}

	/**
	 * Description of the method deleteColumn.
	 * @param column 
	 * @return 
	 */
	public Boolean deleteColumn(Column column) {
		// Start of user code for method deleteColumn
		Boolean deleteColumn = Boolean.FALSE;
		return deleteColumn;
		// End of user code
	}

	/**
	 * Description of the method addItemCollection.
	 * @param itemCollectionName 
	 * @param board 
	 * @return 
	 */
	public Boolean addItemCollection(String itemCollectionName, Board board) {
		// Start of user code for method addItemCollection
		Boolean addItemCollection = Boolean.FALSE;
		return addItemCollection;
		// End of user code
	}

	/**
	 * Description of the method deleteItemCollection.
	 * @param itemCollection 
	 * @return 
	 */
	public Boolean deleteItemCollection(ItemCollection itemCollection) {
		Boolean deleteItemCollection = Boolean.FALSE;
		return deleteItemCollection;
	}

	/**
	 * Description of the method addItem.
	 * @param itemLabel 
	 * @param itemCollection 
	 * @return 
	 */
	public Boolean addItem(String itemLabel, ItemCollection itemCollection) {
		Boolean addItem = Boolean.FALSE;
		return addItem;
	}

	/**
	 * Description of the method deleteItem.
	 * @param item 
	 * @return 
	 */
	public Boolean deleteItem(Item item) {
		Boolean deleteItem = Boolean.FALSE;
		return deleteItem;
	}

	/**
	 * Description of the method editCell.
	 * @param cell 
	 * @param value 
	 * @return 
	 */
	public Boolean editCell(Cell cell, AbstractType value) {
		Boolean editCell = Boolean.FALSE;
		return editCell;
	}

	/**
	 * Returns cellView.
	 * @return cellView 
	 */
	public CellView getCellView() {
		return this.cellView;
	}

	/**
	 * Sets a value to attribute cellView. 
	 * @param newCellView 
	 */
	/*
	public void setCellView(CellView newCellView) {
		if (this.cellView != null) {
			this.cellView.set(null);
		}
		this.cellView.set(this);
	}


	 */
	/**
	 * Returns columnFacade.
	 * @return columnFacade 
	 */
	public ColumnFacade getColumnFacade() {
		return this.columnFacade;
	}

	/**
	 * Sets a value to attribute columnFacade. 
	 * @param newColumnFacade 
	 */
	public void setColumnFacade(ColumnFacade newColumnFacade) {
		this.columnFacade = newColumnFacade;
	}

	/**
	 * Returns cellFacade.
	 * @return cellFacade 
	 */
	public CellFacade getCellFacade() {
		return this.cellFacade;
	}

	/**
	 * Sets a value to attribute cellFacade. 
	 * @param newCellFacade 
	 */
	public void setCellFacade(CellFacade newCellFacade) {
		this.cellFacade = newCellFacade;
	}

	/**
	 * Returns boardFacade.
	 * @return boardFacade 
	 */
	public BoardFacade getBoardFacade() {
		return this.boardFacade;
	}

	/**
	 * Sets a value to attribute boardFacade. 
	 * @param newBoardFacade 
	 */
	public void setBoardFacade(BoardFacade newBoardFacade) {
		this.boardFacade = newBoardFacade;
	}

}
