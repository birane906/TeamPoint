/*******************************************************************************
 * 2020, All rights reserved.
 *******************************************************************************/
package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import business_logic.board.AbstractType;
import business_logic.board.Board;
import business_logic.board.Column;
import business_logic.board.Item;
import business_logic.board.ItemCollection;
import business_logic.user.User;
import business_logic.workspace.Workspace;
import dao.ColumnDAO;
// Start of user code (user defined imports)

// End of user code

/**
 * Description of MySQLBoardDAO.
 * 
 * @author 
 */
public class MySQLBoardDAO extends BoardDAO {
	// Start of user code (user defined attributes for MySQLBoardDAO)

	// End of user code

	/**
	 * The constructor.
	 */
	public MySQLBoardDAO() {
		// Start of user code constructor for MySQLBoardDAO)
		super();
		// End of user code
	}

	@Override
	public Board addBoard(String name, Workspace workspace, User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean deleteBoard(Board board) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Board retrieveBoard(Board board) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean addItemCollection(String itemCollectionName, Board board) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean deleteItemCollection(ItemCollection itemCollection) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean addItem(ItemCollection itemCollection, String itemLabel) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean deleteItem(Item item) {
		// TODO Auto-generated method stub
		return null;
	}

	public static void main(String[] args) {
	}

}
