package org.jsp.bank.dao;

import org.jsp.bank.model.BankUserDetails;

public interface admindao 
{
	boolean AdminLogin(String admin_bankemail_id,int admin_password);
	void userregistration(BankUserDetails b);
	void UserDetails();
	void deleteuserDetails(int accnum);

}
