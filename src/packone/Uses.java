package packone;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Random;

public class Uses {
	static Connection connection;
	static CallableStatement loginProcedure;
	public static Connection getConnection() {
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankdb?user=root&password=");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
	}
	static CallableStatement loginProcedure() {
		Uses.getConnection();
		try {
			loginProcedure=connection.prepareCall("call login(?,?,?)");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return loginProcedure;
	}
	//tpin produdures
	static CallableStatement tPinProcedure() {
		Uses.getConnection();
		try {
			loginProcedure=connection.prepareCall("call checktpin(?,?,?)");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return loginProcedure;
	}
	
	
	
	public static boolean checkcif(String number) {
		getConnection();
		boolean result=false;
		try {
			CallableStatement ps =connection.prepareCall("{call checkcif(?,?)}");
			ps.setString(1, number);
			ps.registerOutParameter(2, Types.INTEGER);
			ps.execute();
			int i=ps.getInt(2);
			result=i==0?true:false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	public static boolean checkAccountNumber(String number) {
		getConnection();
		boolean result=false;
		try {
			CallableStatement ps =connection.prepareCall("{call checkAccountNumber(?,?)}");
			ps.setString(1, number);
			ps.registerOutParameter(2, Types.INTEGER);
			ps.execute();
			int i=ps.getInt(2);
			result=i==0?true:false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	public static boolean isEmailAlreadyAvailable(String number) {
		getConnection();
		boolean result=false;
		try {
			CallableStatement ps =connection.prepareCall("{call isEmailAlreadyAvailable(?,?)}");
			ps.setString(1, number);
			ps.registerOutParameter(2, Types.INTEGER);
			ps.execute();
			int i=ps.getInt(2);
			result=i==0?false:true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	public static String generateTransactionId() {
		String transactionId=fifteenDigit();
		getConnection();
		try {
			CallableStatement ps =connection.prepareCall("{call isTransactionAlreadyAvailable(?,?)}");
			ps.setString(1, transactionId);
			ps.registerOutParameter(2, Types.INTEGER);
			ps.execute();
			int i=ps.getInt(2);
			while (i!=0) {
				transactionId=fifteenDigit();
				ps.setString(1, transactionId);
				ps.registerOutParameter(2, Types.INTEGER);
				ps.execute();
				i=ps.getInt(2);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return transactionId;
	}
	public static boolean isAadhaarAlreadyAvailable(String number) {
		getConnection();
		boolean result=false;
		try {
			CallableStatement ps =connection.prepareCall("{call isAadhaarAlreadyAvailable(?,?)}");
			ps.setString(1, number);
			ps.registerOutParameter(2, Types.INTEGER);
			ps.execute();
			int i=ps.getInt(2);
			result=i==0?false:true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	public static String tenDigit() {
		Random rnd = new Random();
		int number = rnd.nextInt(99999);
		int number2 = rnd.nextInt(99999);
		return String.format("%04d", number)+String.format("%04d", number2);
	}
	public static String fifteenDigit() {
		Random rnd = new Random();
		int number = rnd.nextInt(99999);
		int number2 = rnd.nextInt(99999);
		int number3=rnd.nextInt(99999);
		return String.format("%04d", number)+String.format("%04d", number2)+String.format("%04d", number3);
	}
	
	public static long getBalance(String accountNumber) {
		long balance=0;
		getConnection();
		try {
			CallableStatement cs=connection.prepareCall("{call getBalance(?,?)}");
			cs.setString(1, accountNumber);
			cs.registerOutParameter(2, Types.BIGINT);
			cs.execute();
			balance=cs.getLong(2);
			
		} catch (SQLException e) {}
		
		return balance;
	}
	public static ArrayList<Transactions> getTransactions(String accountNumber){
		connection=getConnection();
		ArrayList<Transactions> list=new ArrayList<Transactions>();
		try {
		Statement statement=connection.createStatement();
		ResultSet rSet=statement.executeQuery("select * from transaction where accountnumber='"+accountNumber+"';");
		while (rSet.next()) {
			Transactions transactions=new Transactions();
			transactions.setId(rSet.getString(1));
			transactions.setType(rSet.getString(3));
			transactions.setAccountNumber(rSet.getString(4));
			transactions.setTime(rSet.getString(5));
			transactions.setDescription(rSet.getString(6));
			transactions.setAmount(rSet.getString(4));
			list.add(transactions);
			
		}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public static void main(String[] args) {
		System.out.println(checkAccountNumber("6259363024"));
	}
	public static String getotpin(String cif) {
		String balance="";
		getConnection();
		try {
			CallableStatement cs=connection.prepareCall("{call getotpin(?,?)}");
			cs.setString(1, cif);
			cs.registerOutParameter(2, Types.VARCHAR);
			cs.execute();
			balance=cs.getString(2);
			
		} catch (SQLException e) {}
		
		return balance;
	}
}
