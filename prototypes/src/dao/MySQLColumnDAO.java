package dao;

import business_logic.board.types.Type;
import business_logic.board.types.TypeFactory;
import business_logic.board.Board;
import business_logic.board.Column;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class MySQLColumnDAO extends ColumnDAO {

	/**
	 * add a column to a board
	 * @param columnName name of column
	 * @param board the column will be added to
	 * @param typeName the String of the abstractType {@link Type}
	 * @return a column {@link Column}
	 */
	@Override
	public Column<? extends Type> addColumn(String columnName, Board board, String typeName) {

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
			// Get connection
			stmt = DAO.getConnection().prepareStatement(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		String req = "INSERT INTO `column`"
				+ " (idBoard, idColumnType, columnName) VALUES ("
				+ DAO.stringFormat(board.getBoard_id() + "") + ", "
				+ DAO.stringFormat(getTypeByName(typeName).getIdType() + "") + ", "
				+ DAO.stringFormat(columnName)
				+  ")";


		try {
			assert stmt != null;
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

		// GET the typeId of column

		Statement state = null;
		req = "SELECT idColumnType FROM `column`"
				+ "WHERE idColumn = " + DAO.stringFormat(columnId + "");
		try {
			//TODO : NICOLAS
			assert false;
			state.executeUpdate(req);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

		// Add the column id to board_contains
		int typeId = -1;
		try {
			ResultSet rs = stmt.getGeneratedKeys();
			rs.next();
			typeId = rs.getInt(1);

		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}

		return new Column<>(board, columnName, columnId, DAO.getTypeById(typeId));
	}


	@Override
	public Boolean deleteColumn(Column<? extends Type> column) {
		return null;
	}

	/**
	 * getAllColumnTypes .
	 * @return column abtract types String that describe type of all the column types
	 */
	public ArrayList<Type> getAllColumnTypes() {
		
		ArrayList<Type> resultat = new ArrayList<>();
		
		// Result from database
		ResultSet rs = null;
		// Query statement
		Statement stmt = null;

		try {
			// Get connection from JDBCConnector
			stmt = DAO.getConnection().createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		String req = "SELECT *"
				+ " FROM type";

		try {
			assert stmt != null;
			if (stmt.execute(req)) {
				rs = stmt.getResultSet();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// if we have a result then move to the next line
		try {
			while(true){
				assert rs != null;
				if (!rs.next()) break;

				int id = rs.getInt("idType");
				String typeName = rs.getString("nameType");
				String description = rs.getString("descriptionType");
				
				
				resultat.add(TypeFactory.createType(id, typeName, description));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return resultat;
	}

	/**
	 * get the type given a name
	 * @param typeName can be TimelineType, textType
	 * @return the Type of the column {@link Type}
	 */
	public Type getTypeByName(String typeName) {
		
		Type resultat = null;
		
		// Result from database
		ResultSet rs = null;
		// Query statement
		PreparedStatement stmt;

		String query = "SELECT * "
				+ "FROM type "
				+ "WHERE nameType = ?";

		try {
			// Getconnection from JDBCConnector
			stmt = DAO.getConnection().prepareStatement(query);
		} catch (SQLException e) {
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
			e.printStackTrace();
			return null;
		}

		// if we have a result then move to the next line

		try {
			assert rs != null;
			if(rs.next()){
					
				int id = rs.getInt("idType");
				String dbTypeName = rs.getString("nameType");
				String description = rs.getString("descriptionType");

				resultat = TypeFactory.createType(id, dbTypeName, description);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultat;
	}

	/*public static void main(String[] args) {
		MySQLColumnDAO mySQLColumnDAO = new MySQLColumnDAO();
		
		ArrayList<Type> res = mySQLColumnDAO.getAllColumnTypes();
		
		for (int i = 0; i < res.size(); i++) {
			//System.out.println(res.get(i));
		}
		
		System.out.println(mySQLColumnDAO.getTypeByName("TimeLineType"));

		System.out.println(DAO.isNameExist("Columntest", "column"));

		Workspace parentWorkspace = new Workspace("salut");
		User boardOwner = new User(1, "name", "firstName", "email", "profileDescription", "phoneNumber");
		Board parentBoard = new Board(0, "test", parentWorkspace, boardOwner, new Date(), new Permission(0, "las", "sa"));

		Column resAdd = mySQLColumnDAO.addColumn("asas", parentBoard, "TimeLineType");

		System.out.println(resAdd);
	}*/

}
