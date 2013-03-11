import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;
import java.util.StringTokenizer;

import databaseConnection.DBConnection;


public class TestDB {
	
	
	public void test(Properties p) throws SQLException, ClassNotFoundException
	{
		DBConnection db=new DBConnection(p);
		
		String insert="insert into employee (name,birthYear)" +
				" values('George',1983)";
		db.initialize();
		db.makeSingleUpdate(insert);
		db.close();
		
	}
	
	
	public void batchTest(Properties p) throws SQLException, ClassNotFoundException
	{
		DBConnection db=new DBConnection(p);
		db.initialize();
		String insert="insert into employee (name,birthYear) values (?,?)";
		PreparedStatement ps=db.preparedStatement(insert);
		
		String name=null;
		int birthYear;
		Scanner sc=new Scanner(System.in);
		String line=sc.nextLine();
		while(line.trim().length()>2)
		{
			StringTokenizer t=new StringTokenizer(line);
			name=t.nextToken();
			birthYear=Integer.parseInt(t.nextToken().trim());
			ps.setString(1, name);
			ps.setInt(2,birthYear);
			ps.addBatch();
			line=sc.nextLine();
		}
		sc.close();
		
		ps.executeBatch();
		ps.close();
		db.close();	
	}
	
	
	public void readTest(Properties p) throws ClassNotFoundException, SQLException
	{
		DBConnection db=new DBConnection(p);
		
		String sql="select name,birthYear from employee";
		
		db.initialize();
		ResultSet rs=db.makeSingleQuery(sql);
		ResultSetMetaData meta=rs.getMetaData();
		rs.beforeFirst();
		System.out.print("Col1:"+meta.getSchemaName(1));
		System.out.print(" Col2:"+meta.getSchemaName(2));
		while(rs.next())
		{
			String name=rs.getString(1);
			String birthYear=rs.getString(2);
			System.out.println(String.format("%s %s\n",name,birthYear));
		}
		rs.close();
		db.close();
		
	}
	
	
	public static void main(String args[]) 
	{
		TestDB t=new TestDB();
		Properties p=new Properties();
		try {
			p.load(new FileInputStream(new File("Properties.properties")));
			//t.readTest(p);
			t.batchTest(p);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
