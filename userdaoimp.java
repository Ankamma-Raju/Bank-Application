package org.jsp.bank.dao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Random;
import java.util.Scanner;


public class userdaoimp  implements userdao
{
	Scanner scanner=new Scanner(System.in);
	final private String selectaccountandpassword="select * from bank_user_details where user_account_number=? and user_password=?";
	String url="jdbc:mysql://localhost:3306/advancejavaproject?user=root&password=12345";
	
	final private String select="select * from bank_user_deatils where user_bankemail_id =? and user_password=?";
	final private String update="update bank_user_details set user_amount=? where user_password=?";
	final private String inserintostatement="insert into statement values(?,?,?,?,?,?,?,?)";
	
	public  boolean userLogIn(String user_bankemail_id,int user_password) 
	{
		try
		{
		Connection c=DriverManager.getConnection(url);
		PreparedStatement ps=c.prepareStatement(select);
		ps.setString(1, user_bankemail_id);
		ps.setInt(2, user_password);
		ResultSet set=ps.executeQuery();
		if(set.next())
		{
			return true;
		}
		else
		{
			return false;
		}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return false;
		//System.out.println("user login");
	}
		public void debit(int accountnumber,int password)
		{
			try
			{
			Connection connection=DriverManager.getConnection(url);
			PreparedStatement ps = connection.prepareStatement(selectaccountandpassword);
			ps.setInt(1, accountnumber);
			ps.setInt(2, password);
		    ResultSet set=ps.executeQuery();
		    if(set.next())
		    {
		    	System.out.println("enter your amount");
		    	double amount=scanner.nextDouble();
		    	if(amount>=0)
		    	{
		    		double databaseamount=set.getDouble("user_amount");
		    		if(databaseamount>=amount)
		    		{
		    			double remainamount = databaseamount-amount;
		    			PreparedStatement ps1=connection.prepareStatement(update);
		    			ps1.setDouble(2, password);
		    			int result=ps1.executeUpdate();
		    			if(result!=0)
		    			{
		    				PreparedStatement ps2=connection.prepareStatement(inserintostatement);
		    				ps2.setString(1,"debit");
		    				ps2.setDate(2,Date.valueOf(LocalDate.now()));
		    				ps2.setString(3,"online");
		    				Random random = new Random();
		    				int transcationId=random.nextInt(10000000);
		    				if(transcationId<10000000)
		    				{
		    					transcationId +=10000000;
		    				}
		    				ps2.setInt(4, transcationId);
		    				ps2.setString(5, amount+"da");
		    				int id=set.getInt("user_id");
		
		    				ps2.setInt(6,id);
		    				ps2.setInt(7, accountnumber);
		    				ps2.setTime(8,Time.valueOf(LocalTime.now()));
		    				ps2.setString(9,remainamount+"cr");
		    				int update2=ps2.executeUpdate();
		    				if(update2!=0)
		    				{
		    					System.out.println("amount debited succesufully");
		    				}		
		    			}
		    			else
		    			{
		    				System.out.println("server 404");
		    			}
		    			
		    		}
		    		else
		    		{
		    			System.out.println("insufficient amount");
		    		}
		    	}
		    }
		    else
		    {
		    	System.out.println("invalid account details");
		    }
			}
		    catch(SQLException e)
		    {
		    	e.printStackTrace();
		    }
		}
	

	@Override
	public boolean userLogin(String user_bankemailid, int user_password) {
		// TODO Auto-generated method stub
		return false;
	}
}






















