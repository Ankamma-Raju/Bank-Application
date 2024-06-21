package org.jsp.bank;
import java.time.LocalDate;
import java.util.Scanner;

import org.jsp.bank.dao.AdminHelperMethod;
import org.jsp.bank.dao.admindao;
import org.jsp.bank.dao.userHelperClass;
import org.jsp.bank.dao.userdao;
import org.jsp.bank.model.BankUserDetails;

/**
 * Hello world!
 *
 */
public class App 
{
	public static void main( String[] args )
    	     {
    	             admindao ad=AdminHelperMethod.adminmethod();
    		          userdao us=userHelperClass.userMethod();
    		          userdao.debit(5138819,5757);
    		          
    		          
    		          
    		          
    		          Scanner sc=new Scanner(System.in);
    		          boolean status = true;
    		          while(status) 
    		          {
    		    	  System.out.println("Enter Your Choice \n 1.Admin Login\n 2.User Login");
    			      int choice=sc.nextInt();
    		    	    switch (choice) { 
    				    case 1: 
    				    boolean adminstatus=true;
    				    int count=0;
    				    while(adminstatus)
    				    {
    				    System.out.println("enter email id");
    				    String admin_bankemail_id=sc.next();
    				    System.out.println("enter password");
    				    int admin_password=sc.nextInt();
    				  if( ad.AdminLogin(admin_bankemail_id, admin_password))
    				  {
    					   adminstatus=false;
    					  System.out.println(""
    					  		+ "\n.1.User registration "
    					  		+ "\n2.user Deatils "
    					  		+ "\n 3.update User Deatils "
    					  		+ "\n 4. Delete UserDeatils");
    					  int next=sc.nextInt();
    					  switch(next)
    					  {
    					  case 1:
    					    BankUserDetails b=new BankUserDetails ();
//    		                ad.userresgistartion();
    					    System.out.println("enter user name");
    					    String username=sc.next();
    					    b.setUsername(username);
    					    System.out.println("enter email Id");
    					    String email=sc.next();
    					    b.setUseremailid(email);
    					    System.out.println("enter your gender");
    					    String gender=sc.next();
    					    b.setUsergender(gender);
    					    System.out.println("enter your address");
    					    String address=sc.next();
    					    b.setUseraddress(address);
    					    System.out.println("enter your date of birth");
    					    String dateofbirth=sc.next();
    					    b.setUserdateofbirth(LocalDate.parse(dateofbirth));
    					    System.out.println("enter your amount");
    					    double amount=sc.nextDouble();
    					    b.setUseramount(amount);
    					    System.out.println("enter your moblie number");
    					    String moblienum=sc.next();
    					    b.setUsermobilenumber(moblienum);
    					    ad.userregistration(b);
    					  break;
    					  case 2: 
    						  //System.out.println(" enter bank user id ");
    						  //String bankuserid=sc.next();
    						  //System.out.println(" enter password ");
    						  //int password=sc.nextInt();
    						  //ad.
    						  ad.UserDetails();
    					System.out.println(" All User deatils ");
    					  break;
    					  case 3:  System.out.println("Updation User deatils ");
    					  break;
    					  case 4:
    						  System.out.println("enter account number");
    						  int accountnum=sc.nextInt();
    						  ad.deleteuserDetails(accountnum);
    						  
    						  System.out.println("Delete User deatils");
    					  break;
    					  default:System.out.println("enter  valied choice");
    					  }
    				  }
    				  else
    				  {
    				      System.out.println("invalied deatils");
    				      count++;
    				      
    				      }
    				  if(count==3)
    				  {
    					  adminstatus=false;
    				  }
    				    status = false;
    				    }
    					break;
    				    case 2:
    				    	 System.out.println(" enter bank user id ");
    						  String bankuserid=sc.next();
    						  System.out.println(" enter password ");
    						  int password=sc.nextInt();
    				    	//us.userLogIn(bankuserid, password);
    				    	if (us.userLogin(bankuserid, password))
    				    	{
    							//System.out.println("Login Successfull");
    				    		System.out.println("Enter "
    				    				+ "\n 1.For Balance Enquiry "
    				    				+ "\n 2.For Withdraw "
    				    				+ "\n 3.For Credit"
    				    				+ "\n 4.For Change Password "
    				    				+ "\n 5.For Check Statement "
    				    				+ "\n 6.For Mobile To Mobile Transaction");
    						}
    				    	else {
    				    		System.out.println(" Please enter valid details ");
    				    	}
    				    	
    				    	//us.userLogIn("sai", 1456);
    				    status=false;
    				    break;
    				    default:System.out.println("enter the valid choice");
    				    break;
    				  }
    			       System.out.println("Do You Want To Continue\n Yes \n No");
    			       String choice1=sc.next();
    			       if(choice1.equalsIgnoreCase("Yes"))
    			       {
    			    	   status=true;   
    			       }
    			       else
    			       {
    			    	   System.out.println("Thank You Visit Again....!!!");
    			    	   status = false;
    			       }
    		          }
    	     }
}