package dao;

import business_logic.board.types.Type;
import business_logic.board.Board;
import business_logic.board.Column;

import java.util.ArrayList;

/**
 * Description of ColumnDAO.
 * 
 * @author Raphael Bourret, Salim Azharhoussen, Birane Ba, Nicolas Galois
 */
public abstract class ColumnDAO implements DAO {

	/**
	 * The constructor.
	 */
	public ColumnDAO() {
		super();
	}

	/**
	 * add Column to a board.
	 * @param columnName name of the column
	 * @param board which we will add the column
	 * @param typeName the String of the abstractType {@link Type}
	 * @return a {@link Board}
	 */
	public abstract Column<? extends Type> addColumn(String columnName, Board board, String typeName);

	/**
	 * delete Column.
	 * @param column which need to be deleted
	 * @return a boolean according to the success of delete
	 */
	public abstract Boolean deleteColumn(Column<? extends Type> column);

	/**
	 * getAllColumnTypes .
	 * @return column types String that describe type of all the column types
	 */
	public abstract ArrayList<Type> getAllColumnTypes();
	
	public abstract Type getTypeByName(String typeName);

	public abstract Type getColumnType(Column<? extends Type> column);

	// Start of user code (user defined methods for ColumnDAO)

	// End of user code

}
