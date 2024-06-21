package org.jsp.bank.model;

import java.time.LocalDate;

public class BankUserDetails 
{
	private int userid;
	private String username;
	private String userbankemailid;
	private String useremailid;
	private int userpassword;
	private String usergender;
	private String useraddress;
	private LocalDate userdateofbirth;
	private int useraccountnum;
	private double useramount;
	private String usermobilenumber;
	private String ifscode;
	
	public BankUserDetails() 
	{
		
	}

	public BankUserDetails(int userid, String userbankemailid, String useremailid, int userpassword, String usergender,
			String useraddress, LocalDate userdateofbirth, int useraccountnum, double useramount,
			String usermobilenumber, String ifscode) {
		super();
		this.userid = userid;
		this.userbankemailid = userbankemailid;
		this.useremailid = useremailid;
		this.userpassword = userpassword;
		this.usergender = usergender;
		this.useraddress = useraddress;
		this.userdateofbirth = userdateofbirth;
		this.useraccountnum = useraccountnum;
		this.useramount = useramount;
		this.usermobilenumber = usermobilenumber;
		this.ifscode = ifscode;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getUserbankemailid() {
		return userbankemailid;
	}

	public void setUserbankemailid(String userbankemailid) {
		this.userbankemailid = userbankemailid;
	}

	public String getUseremailid() {
		return useremailid;
	}

	public void setUseremailid(String useremailid) {
		this.useremailid = useremailid;
	}

	public int getUserpassword() {
		return userpassword;
	}

	public void setUserpassword(int userpassword) {
		this.userpassword = userpassword;
	}

	public String getUsergender() {
		return usergender;
	}

	public void setUsergender(String usergender) {
		this.usergender = usergender;
	}

	public String getUseraddress() {
		return useraddress;
	}

	public void setUseraddress(String useraddress) {
		this.useraddress = useraddress;
	}

	public LocalDate getUserdateofbirth() {
		return userdateofbirth;
	}

	public void setUserdateofbirth(LocalDate userdateofbirth) {
		this.userdateofbirth = userdateofbirth;
	}

	public int getUseraccountnum() {
		return useraccountnum;
	}

	public void setUseraccountnum(int useraccountnum) {
		this.useraccountnum = useraccountnum;
	}

	public double getUseramount() {
		return useramount;
	}

	public void setUseramount(double useramount) {
		this.useramount = useramount;
	}

	public String getUsermobilenumber() {
		return usermobilenumber;
	}

	public void setUsermobilenumber(String usermobilenumber) {
		this.usermobilenumber = usermobilenumber;
	}

	public String getIfscode() {
		return ifscode;
	}

	public void setIfscode(String ifscode) {
		this.ifscode = ifscode;
	}

	public void setUsername(String username2) {
		// TODO Auto-generated method stub
		
	}
	
	
	

}
