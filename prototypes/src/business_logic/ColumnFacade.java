/*******************************************************************************
 * 2020, All rights reserved.
 *******************************************************************************/
package business_logic;

import business_logic.ColumnFacade;
import business_logic.board.Board;
import business_logic.board.Column;
// Start of user code (user defined imports)

// End of user code

/**
 * Description of ColumnFacade.
 * 
 * @author 
 */
public class ColumnFacade {
	/**
	 * Description of the property currentColumn.
	 */
	public Column currentColumn = null;

	// Start of user code (user defined attributes for ColumnFacade)

	// End of user code

	/**
	 * The constructor.
	 */
	public ColumnFacade() {
		// Start of user code constructor for ColumnFacade)
		super();
		// End of user code
	}

	/**
	 * Description of the method getColumnFacadeInstance.
	 * @return 
	 */
	public static ColumnFacade getColumnFacadeInstance() {
		// Start of user code for method getColumnFacadeInstance
		ColumnFacade getColumnFacadeInstance = null;
		return getColumnFacadeInstance;
		// End of user code
	}

	/**
	 * Description of the method addColumn.
	 * @param columnName 
	 * @param board 
	 * @param typeName 
	 * @return 
	 */
	public Boolean addColumn(String columnName, Board board, String typeName) {
		// Start of user code for method addColumn
		Boolean addColumn = Boolean.FALSE;
		return addColumn;
		// End of user code
	}

	/**
	 * Description of the method retrieveColumnTypes.
	 * @return 
	 */
	public Object retrieveColumnTypes() {
		return null;
		// Start of user code for method retrieveColumnTypes
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
	 * Description of the method getColumnType.
	 * @param column 
	 * @return 
	 */
	public String getColumnType(Column column) {
		// Start of user code for method getColumnType
		String getColumnType = "";
		return getColumnType;
		// End of user code
	}

	// Start of user code (user defined methods for ColumnFacade)

	// End of user code
	/**
	 * Returns currentColumn.
	 * @return currentColumn 
	 */
	public Column getCurrentColumn() {
		return this.currentColumn;
	}

	/**
	 * Sets a value to attribute currentColumn. 
	 * @param newCurrentColumn 
	 */
	public void setCurrentColumn(Column newCurrentColumn) {
		if (this.currentColumn != null) {
			this.currentColumn.set(null);
		}
		this.currentColumn.set(this);
	}

}
