package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import business_logic.board.AbstractType;
import business_logic.board.Board;
import business_logic.board.Column;

public class MySQLColumnDAO extends ColumnDAO {

	@Override
	public Board addColumn(String columnName, Board board, String typeName) {
		// TODO Auto-generated method stub
		return null;
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

	@Override
	public AbstractType getColumnType(int columnId) {
		
		AbstractType resultat = null;
		
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

		String req = "SELECT idColumnType "
				+ "FROM `column` "
				+ "WHERE idColumn = " + DAO.stringFormat(columnId + "");

		try {
			if (stmt.execute(req)) {
				rs = stmt.getResultSet();
			}
		} catch (SQLException e) {
			// TODO explain connection lost
			e.printStackTrace();
		}

		// if we have a result then move to the next line
		
		int id = -1;
		try {
			if(rs.next()) {
				id = rs.getInt("idColumnType");
			}
			
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		if (id != -1) {
			req = "SELECT * "
					+ "FROM type "
					+ "WHERE idType = " + DAO.stringFormat(id + "");

			try {
				if (stmt.execute(req)) {
					rs = stmt.getResultSet();
				}
			} catch (SQLException e) {
				// TODO explain connection lost
				e.printStackTrace();
			}
			
			try {
				if(rs.next()){
					
					id = rs.getInt("idType");
					String typeName = rs.getString("nameType");
					String description = rs.getString("descriptionType");
					
					
					resultat = new AbstractType(id, typeName, description);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return resultat;
		}
		
		return null;
	}
	
	public static void main(String[] args) {
		MySQLColumnDAO mySQLColumnDAO = new MySQLColumnDAO();
		
		ArrayList<AbstractType> res = mySQLColumnDAO.getAllColumnTypes();
		
		for (int i = 0; i < res.size(); i++) {
			System.out.println(res.get(i));
		}
		
		System.out.println(mySQLColumnDAO.getColumnType(0));
	}

}
