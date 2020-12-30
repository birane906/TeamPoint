/*******************************************************************************
 * 2020, All rights reserved.
 *******************************************************************************/
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import business_logic.board.AbstractType;
import business_logic.board.Board;
import business_logic.board.Column;
import business_logic.board.Item;
import business_logic.board.ItemCollection;
import business_logic.board.Permission;
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
	public Board addBoard(String name, Workspace workspace, User user, Permission permission) {
		// Query statement
		PreparedStatement stmt = null;
				
		String query = "INSERT INTO workspace"
				+ " (userOwner, idPermission, boardName, parentWorkspace) VALUES(?, ?, ?, ?)";
		
		try {
			// Getconnection
			stmt = DAO.getConnection().prepareStatement(query);
		} catch (SQLException e) {
			// TODO explain database not found
			e.printStackTrace();
		}
		
		String req = "INSERT INTO workspace"
				+ " (userOwner, idPermission, boardName, parentWorkspace) VALUES("
				+ DAO.stringFormat(user.getUser_id() + "") + ", " 
				+ DAO.stringFormat(permission.getIdPermission() + "")
				+ DAO.stringFormat(name) + ", "
				+ DAO.stringFormat(workspace.getWorkspace_id() + "") + ", " 
				+ ")";
							
		try {
			stmt.execute(req);
		} catch (SQLException e) {
			return null;
		}
				
		return new Board(name, workspace, user);
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
		// Query statement
		PreparedStatement stmt = null;
						
		String query = "INSERT INTO workspace"
				+ " (idBoard, itemCollectionName) VALUES(?, ?)";
		try {
			// Getconnection
			stmt = DAO.getConnection().prepareStatement(query);
		} catch (SQLException e) {
			// TODO explain database not found
			e.printStackTrace();
		}
				
		String req = "INSERT INTO workspace"
				+ " (idBoard, itemCollectionName) VALUES("
				+ DAO.stringFormat(board.getBoard_id() + "") + ", " 
				+ DAO.stringFormat(itemCollectionName)
				+  ")";
									
		try {
			stmt.execute(req);
		} catch (SQLException e) {
			return false;
		}
		
		return true;
	}

	@Override
	public Boolean deleteItemCollection(ItemCollection itemCollection) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean addItem(ItemCollection itemCollection, String itemLabel) {
		// Query statement
		PreparedStatement stmt = null;
		String query = "INSERT INTO workspace"
				+ " (idBoard, idItemCollection, itemName) VALUES(?, ?, ?)";
								
		try {
			// Getconnection
			stmt = DAO.getConnection().prepareStatement(query);
		} catch (SQLException e) {
			// TODO explain database not found
			e.printStackTrace();
		}
		
		String req = "INSERT INTO workspace"
				+ " (idBoard, idItemCollection, itemName) VALUES("
				+ DAO.stringFormat(itemCollection.getParentBoard().getBoard_id() + "") + ", " 
				+ DAO.stringFormat(itemCollection.getItemCollection_id() + "") + ", "
				+ DAO.stringFormat(itemLabel)
				+  ")";
		
		try {
			stmt.execute(req);
		} catch (SQLException e) {
			return false;
		}
		
		return true;
	}

	@Override
	public Boolean deleteItem(Item item) {
		// TODO Auto-generated method stub
		return null;
	}

	public static void main(String[] args) {
		
	}

}
