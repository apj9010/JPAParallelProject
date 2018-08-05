package com.cg.service;

import com.cg.payment.beans.Payments;
import com.cg.payment.exception.PaymentException;

public interface IPaymentService {

	public String createAccount(Payments account) throws PaymentException;
	public double showBalance(String mobileNo) throws PaymentException;
	public Payments deposit(String mobileNo,double depositAmount) throws PaymentException;
	public Payments withdraw(String mobileNo,double withdrawAmount) throws PaymentException;
	public Payments printTransactionDetails(String mobileNo) throws PaymentException;
    public boolean fundTransfer(String sourceMobileNo,String destMobileNo,double transferAmount) throws PaymentException;
}
