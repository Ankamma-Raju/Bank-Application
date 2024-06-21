package org.jsp.bank.dao;
import java.sql.Connection;
	import java.sql.Date;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;
	import java.util.Random;
	import java.util.Scanner;

	import javax.xml.crypto.Data;

	import org.jsp.bank.model.BankUserDetails;
	public class admindaoimp implements admindao
	{
		Scanner sc=new Scanner(System.in);
		final private String select="select * from bank_admin where admin_email_id=? and admin_password=?";
		final private String insert="insert into bank_user_deatils(user_name, user_bankemail_id, user_password, user_gender, user_address, user_date_of_birth, user_acc_num, user_amount, user_moblie_num, user_ifscode)values(?,?,?,?,?,?,?,?,?,?)";
		final private String select1="select * from bank_user_deatils where user_name ='kanna'";
		final private String delete="delete from bank_user_deatils where user_acc_num=?";
		String url="jdbc:mysql://localhost:3306/advancejavaproject?user=root&password=12345";
		@Override
		public boolean AdminLogin(String admin_bankemail_id, int admin_password)
		{
			try
			{
			Connection c=DriverManager.getConnection(url);
			System.out.println("establish connected");
			PreparedStatement ps=c.prepareStatement(select);
		    ps.setString(1, admin_bankemail_id);
		    ps.setInt(2, admin_password);
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
		}
		
		public void userregistration(  BankUserDetails b) 
		{
			try
			{
				Connection c=DriverManager.getConnection(url);
				System.out.println("etablish connected");
				PreparedStatement  ps=c.prepareStatement(insert);
				ps.setString(1, b.getUsername());
				//ps.setString(2,b.getUserbankemailid());
				//ps.setString(3, b.getUseremailid());
				Random random=new Random();
			    int emailid=random.nextInt(100);
			    if(emailid<10)
			    {
			    	emailid+=10;
			    }
			    String bankemailid=b.getUsername()+emailid+"@gmail.com";
			    ps.setString(2, bankemailid);
			    int password=random.nextInt(10000);
			    if(password<1000)
			    {
			    	password+=1000;
			    }
			    ps.setInt(3, password);
			    ps.setString(4, b.getUsergender());
			    ps.setString(5, b.getUseraddress());
			    ps.setDate(6, Date.valueOf(b.getUserdateofbirth())); 
			  int r = random.nextInt(10000000);
			  if(r<10000000)
			  {
				  r+=10000000;
			  }
			    ps.setInt(7,r);
			    ps.setDouble(8,b.getUseramount());
			    ps.setString(9, b.getUsermobilenumber());
			    ps.setString(10,"IFSCTECHA53");
			  int result =ps.executeUpdate();
			  if(result!=0)
			  {
				  System.out.println("data inserted suceesfully");
			  }
			  else
			  {
				  System.out.println("no data found");
			  }
			}
			  catch(SQLException e)
			  {
				  e.printStackTrace();
			  }	
		}
		public void UserDeatils()
		{
			try
			{
				Connection c=DriverManager.getConnection(url);
				Statement s=c.createStatement();
				ResultSet set=s.executeQuery(select1);
				if(set.isBeforeFirst())
				{
					while(set.next())
					{
						System.out.println("name of user:"+set.getString("user_name"));
						System.out.println("bank email id:"+set.getString("user_bankemail_id"));
						System.out.println("password of the user:"+set.getString("user_password"));
						System.out.println("mobile number of user:"+set.getString("user_moblie_num"));
						System.out.println("gender of user:"+set.getString("user_gender"));
						System.out.println("amount:"+set.getDouble("user_amount"));
					}
				}
					else 
					{
						System.out.println(" no data found");
						
					}
				}
			
			catch(SQLException e)
			{
				e.printStackTrace();
			}
			
		}
		@Override
		public void deleteuserDetails(int accnum) 
		{
			try
			{
		   Connection c=DriverManager.getConnection(url);
		   PreparedStatement ps=c.prepareStatement(delete);
		   ps.setInt(1, accnum);
		 int result = ps.executeUpdate();
		 if(result!=0)
		 {
			 System.out.println("Account deleted");
		 }
		 else
		 {
			 System.out.println("no data found");
		 }
		   
			
		}
		catch(SQLException e)
			{
			 e.printStackTrace();
			}
		}

		@Override
		public void UserDetails() {
			// TODO Auto-generated method stub
			
		}

		
		}
	
	