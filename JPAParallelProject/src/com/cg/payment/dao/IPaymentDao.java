package com.cg.payment.dao;

import com.cg.payment.beans.Payments;
import com.cg.payment.exception.PaymentException;


public interface IPaymentDao {
	public String createAccount(Payments account) throws PaymentException;
	public double showBalance(String mobileNo) throws PaymentException;
	Payments deposit(String mobileNo,double balance) throws PaymentException;
	Payments withdraw(String mobileNo,double balance) throws PaymentException;
    Payments printTransactionDetails(String mobileNo) throws PaymentException;
   public boolean fundTransfer(String sourceMobileNo,String destMobileNo,double transferAmount) throws PaymentException;
}
