package databaseConnection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import company.Employee;
/**
 * The Factory should be the interface where Objects are created and they are mapped to entries in the database
 * 
 * @author orestis
 *
 */
public class Factory {
	
	DBConnection db;
	
	
	public Factory(Properties properties) throws ClassNotFoundException, SQLException
	{
		 db=new DBConnection(properties);
	}
	
	public  Employee  createEmployee(String name, int birthYear) throws ClassNotFoundException, SQLException
	{
		Employee e=new Employee(name,birthYear);
		String query=String.format("insert into employee " +
				"(name,birthYear) values ('%s', %d)",name,birthYear); 
		db.initialize();
		db.makeSingleUpdate(query);
		db.close();
		
		return e;
	}
	
	public Employee getEmployee(int id) throws ClassNotFoundException, SQLException
	{
		
		String birthYearString="birthYear";//done for demonstration reasons
		
		String query=String.format("Select name,%s from employee where id=%d",birthYearString,id);
		db.initialize();
		ResultSet rs=db.makeSingleQuery(query);
		String name=null;
		int birthYear=-1;
		while(rs.next())
		{
			name=rs.getString(1);
			birthYear=rs.getInt(2);
		}
		
		Employee e=new Employee(name,birthYear);
		rs.close();
		db.close();
		
		return e;
	
		
	}
	
	public void deleteEmployee()
	{
		;
	}
	public void updateEmployee()
	{
		;
	}

}
