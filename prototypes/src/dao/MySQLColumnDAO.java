package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import business_logic.board.AbstractType;
import business_logic.board.Board;
import business_logic.board.Column;
import business_logic.user.User;
import business_logic.workspace.Workspace;

public class MySQLColumnDAO extends ColumnDAO {

	@Override
	public Column addColumn(String columnName, Board board, String typeName) {

		if(columnName.isBlank() || board == null || typeName.isBlank()) {
			return null;
		}

		if(DAO.isNameExist(columnName, "column")) {
			return null;
		}

		// Query statement
		PreparedStatement stmt = null;
		int columnId = -1;

		String query = "INSERT INTO 'column'"
				+ " (idBoard, idColumnType, columnName) VALUES(?, ?, ?)";
		try {
			// Getconnection
			stmt = DAO.getConnection().prepareStatement(query);
		} catch (SQLException e) {
			// TODO explain database not found
			e.printStackTrace();
		}

		String req = "INSERT INTO `column`"
				+ " (idBoard, idColumnType, columnName) VALUES ("
				+ DAO.stringFormat(board.getBoard_id() + "") + ", "
				+ DAO.stringFormat(getTypeByName(typeName).getIdType() + "") + ", "
				+ DAO.stringFormat(columnName)
				+  ")";


		try {
			stmt.executeUpdate(req, Statement.RETURN_GENERATED_KEYS);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

		// Add the column id to board_contains

		try {
			ResultSet rs = stmt.getGeneratedKeys();
			rs.next();
			columnId = rs.getInt(1);

		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}

		stmt = null;

		query = "INSERT INTO board_contains"
				+ " (idBoard, idItemCollection, idColumn) VALUES(?, ?, ?)";
		try {
			stmt = DAO.getConnection().prepareStatement(query);
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}

		req = "INSERT INTO board_contains"
				+ " (idBoard, idItemCollection, idColumn) VALUES("
				+ DAO.stringFormat(board.getBoard_id() + "") + ", "
				+ null + ", "
				+ DAO.stringFormat(columnId + "")
				+ ")";

		try {
			stmt.execute(req);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

		return new Column(board, columnName, columnId, getTypeByName(typeName).getIdType());
	}

	@Override
	public Boolean deleteColumn(Column column) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * getAllColumnTypes .
	 * @return column abtract types String that describe type of all the column types
	 */
	public ArrayList<AbstractType> getAllColumnTypes() {
		
		ArrayList<AbstractType> resultat = new ArrayList<AbstractType>();
		
		// Result from database
		ResultSet rs = null;
		// Query statement
		Statement stmt = null;

		try {
			// Getconnection from JDBCConnector
			stmt = DAO.getConnection().createStatement();
		} catch (SQLException e) {
			// TODO explain database not found
			e.printStackTrace();
		}

		String req = "SELECT *"
				+ " FROM type";

		try {
			if (stmt.execute(req)) {
				rs = stmt.getResultSet();
			}
		} catch (SQLException e) {
			// TODO explain connection lost
			e.printStackTrace();
		}

		// if we have a result then move to the next line
		try {
			while(rs.next()){
				
				int id = rs.getInt("idType");
				String typeName = rs.getString("nameType");
				String description = rs.getString("descriptionType");
				
				
				resultat.add(new AbstractType(id, typeName, description));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return resultat;
	}

	public AbstractType getTypeByName(String typeName) {
		
		AbstractType resultat = null;
		
		// Result from database
		ResultSet rs = null;
		// Query statement
		PreparedStatement stmt = null;

		String query = "SELECT * "
				+ "FROM type "
				+ "WHERE nameType = ?";

		try {
			// Getconnection from JDBCConnector
			stmt = DAO.getConnection().prepareStatement(query);
		} catch (SQLException e) {
			// TODO explain database not found
			e.printStackTrace();
			return null;
		}

		String req = "SELECT * "
				+ "FROM type "
				+ "WHERE nameType = " + DAO.stringFormat(typeName);

		try {
			if (stmt.execute(req)) {
				rs = stmt.getResultSet();
			}
		} catch (SQLException e) {
			// TODO explain connection lost
			e.printStackTrace();
			return null;
		}

		// if we have a result then move to the next line

			
		try {
			if(rs.next()){
					
				int id = rs.getInt("idType");
				String nameType = rs.getString("nameType");
				String description = rs.getString("descriptionType");

				resultat = new AbstractType(id, nameType, description);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultat;
	}
	
	public static void main(String[] args) {
		MySQLColumnDAO mySQLColumnDAO = new MySQLColumnDAO();
		
		ArrayList<AbstractType> res = mySQLColumnDAO.getAllColumnTypes();
		
		for (int i = 0; i < res.size(); i++) {
			//System.out.println(res.get(i));
		}
		
		System.out.println(mySQLColumnDAO.getTypeByName("TimeLineType"));

		System.out.println(DAO.isNameExist("Columntest", "column"));

		Workspace parentWorkspace = new Workspace("salut");
		User boardOwner = new User(1, "name", "firstName", "email", "profileDescription", "phoneNumber");
		Board parentBoard = new Board(0, "test", parentWorkspace, boardOwner);

		Column resAdd = mySQLColumnDAO.addColumn("sasasasa", parentBoard, "TimeLineType");

		System.out.println(resAdd);
	}

}
