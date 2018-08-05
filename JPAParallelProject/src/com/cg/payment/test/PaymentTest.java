package com.cg.payment.test;
import static org.junit.Assert.*;

import org.junit.Test;

import com.cg.payment.beans.Payments;
import com.cg.payment.exception.PaymentException;
import com.cg.service.IPaymentService;
import com.cg.service.PaymentService;

public class PaymentTest { 

	private IPaymentService service= new PaymentService();
	
	@Test
	public void testCreateAccountForMobile() {
	Payments ac = new Payments();
	ac.setMobile_no("9999");
	ac.setCustomer_name("Ramesh");
	ac.setEmail_id("ramesh@gmail.com");
	ac.setBalance(200.0);
	try {
	service.createAccount(ac);
	} catch (PaymentException e) {
	assertEquals("Mobile number should contain 10 digits", e.getMessage());
	}
	}
	 
	@Test
	public void testCreateAccountForName() {
	Payments ac = new Payments();
	ac.setMobile_no("9999999999");
	ac.setCustomer_name("ravi123");
	ac.setEmail_id("ravi@gmail.com");
	ac.setBalance(500.0);
	try {
	service.createAccount(ac);
	} catch (PaymentException e) {
	assertEquals("Name should start with Capital letter and should contain only alphabets", e.getMessage());
	}
	}
	 
	@Test
	public void testCreateAccountForNameIsEmpty() {
	Payments ac = new Payments();
	ac.setMobile_no("9999999999");
	ac.setCustomer_name("");
	ac.setEmail_id("deepak@gmail.com");
	ac.setBalance(200.0);
	try {
	service.createAccount(ac);
	} catch (PaymentException e) {
	assertEquals("Name cannot be empty", e.getMessage());
	}
	}	 
	@Test
	public void testCreateAccountForEmailId() {
	Payments ac = new Payments();
	ac.setMobile_no("9999999999");
	ac.setCustomer_name("Ramesh");
	ac.setEmail_id("ramesh@@23gmail.com");
	ac.setBalance(200.0);
	try {
	service.createAccount(ac);
	} catch (PaymentException e) {
	assertEquals("Enter valid emailid", e.getMessage());
	}
	}
	@Test
	public void testCreateAccount() {
	Payments ac = new Payments();
	ac.setMobile_no("9999999999");
	ac.setCustomer_name("Ramesh");
	ac.setEmail_id("deepu@gmail.com");
	ac.setBalance(200.0);
	 
	try {
	String s=service.createAccount(ac);
	assertNotNull(s);
	} catch (PaymentException e) { 
	}	 
	}
	 
	/*@Test
	public void testShowBalanceForMobileNo() {
	try {
	service.showBalance("95059");
	} catch (AccountException e) {
	assertEquals("Mobile number should contain 10 digits",e.getMessage());
	}
	}
	 
	@Test
	public void testShowBalanceForMobileNoDoesNotExist() {
	try {
	service.showBalance("8888887777");
	} catch (AccountException e) {
    assertEquals("the mobile number is not there in the data base",e.getMessage());
	}
	}*/
	
	/*@Test
	public void testShowBalanceForMobileNoCorrectCase() {
	try {
	service.showBalance("1231231231");
	} catch (AccountException e) {
    assertEquals("the mobile number is not there in the data base",e.getMessage());
	}
	}*/
	
	@Test
	public void testDepositForMobileNo() {
	Payments ac=new Payments();
	ac.setMobile_no("95059345");
	try {
	service.deposit(ac.getMobile_no(), 230);
	} catch (PaymentException e) {
	assertEquals("Mobile number should contain 10 digits",e.getMessage());
	}
	}
	/*@Test
	public void testDepositForMobileNoDoesNotExist() {
	Account ac=new Account();
	ac.setMobile_no("9505934512");
	try {
	service.deposit(ac.getMobile_no(), 230);
	} catch (AccountException e) {
	assertEquals("the mobile number is not there in the data base",e.getMessage());
	}
	}
	@Test
	public void testDepositForDepositAmt1() {
	Account ac=new Account();
	ac.setMobile_no("9999999999");
	try {
	service.deposit(ac.getMobile_no(), -230);
	} catch (AccountException e) {
	assertEquals("deposit amount must be greater than zero",e.getMessage());
	}
	}
	@Test
	public void testDepositForDepositAmt1IsZero() {
	Account ac=new Account();
	ac.setMobile_no("9999999999");
	try {
	service.deposit(ac.getMobile_no(), 0);
	} catch (AccountException e) {
	assertEquals("deposit amount must be greater than zero",e.getMessage());
	}
	}
	 
	@Test
	public void testDeposit() {
	Account ac=new Account();
	ac.setMobile_no("9999999999");
	try {
	Account ac1=service.deposit("9999999999", 500);
	assertNotNull(ac1);
	} catch (AccountException e) {
	 
	//System.out.println(e.getMessage());
	}
	}
	 
	@Test
	public void testWithDrawForMobileNo() {
	Account ac=new Account();
	ac.setMobile_no("95059345");
	try {
	service.withdraw(ac.getMobile_no(), 230);
	} catch (AccountException e) {
	assertEquals("Mobile number should contain 10 digits",e.getMessage());
	}
	}
	@Test
	public void testWithdrawForMobileNoDoesNotExist() {
	Account ac=new Account();
	ac.setMobile_no("9505934512");
	try {
	service.withdraw(ac.getMobile_no(), 230);
	} catch (AccountException e) {
	assertEquals("the mobile number is not there in the data base",e.getMessage());
	}
	}
	@Test
	public void testWithdrawForAmt() {
	Account ac=new Account();
	ac.setMobile_no("9999999999");
	try {
	service.withdraw(ac.getMobile_no(), -230);
	} catch (AccountException e) {
	assertEquals("Amount should be greater than zero",e.getMessage());
	}
	}
	
	@Test
	public void testWithdrawForAmtIsZero() {
	Account ac=new Account();
	ac.setMobile_no("9999999999");
	try {
	service.withdraw(ac.getMobile_no(), 0);
	} catch (AccountException e) {
	assertEquals("Amount should be greater than zero",e.getMessage());
	}
	}*/
	 
	@Test
	public void testFundTransferForMobileNo() {
	Payments ac=new Payments();
	Payments ac2=new Payments();
	ac.setMobile_no("95059345");
	ac2.setMobile_no("1234");
	try {
	service.fundTransfer(ac.getMobile_no(),ac2.getMobile_no(), 230);
	} catch (PaymentException e) {
	assertEquals("Mobile number should contain 10 digits",e.getMessage());
	}
	}
	/*@Test
	public void testFundTransferForMobileNoDoesNotExist() {
	Account ac=new Account();
	Account ac2=new Account();
	ac.setMobile_no("9505934512");
	ac2.setMobile_no("9505934782");
	try {
	service.fundTransfer(ac.getMobile_no(), ac2.getMobile_no(),  230);
	} catch (AccountException e) {
	assertEquals("the mobile number is not there in the data base",e.getMessage());
	}
	}
	@Test
	public void testFundTransferForAmt() {
	Account ac=new Account();
	Account ac2=new Account();
	ac.setMobile_no("9999999999");
	ac2.setMobile_no("8888888888");
	try {
	service.fundTransfer(ac.getMobile_no(), ac2.getMobile_no(),  -230);
	} catch (AccountException e) {
	// TODO Auto-generated catch block
	assertEquals("Amount should be greater than zero",e.getMessage());
	}
	}
	@Test
	public void testFundTransfer() {
	Account ac=new Account();
	Account ac2=new Account();
	ac.setMobile_no("9999999999");
	ac2.setMobile_no("8888888888");
	try {
	assertTrue(service.fundTransfer(ac.getMobile_no(), ac2.getMobile_no(),  230));
	} catch (AccountException e) {
	}
	}*/
	@Test
	public void testPrinttransactionDetails() {
	Payments ac=new Payments();
	ac.setMobile_no("8888888888");
	try {
	Payments acc=service.printTransactionDetails(ac.getMobile_no());
	assertNotNull(acc);
	} catch (PaymentException e) {
	//System.out.println(e.getMessage());
	}
	}
	
	@Test
	public void testPrinttransactionDetailsForMobile() {
		Payments ac=new Payments();
		ac.setMobile_no("950593");
		try {
		Payments acc=service.printTransactionDetails(ac.getMobile_no());
		} catch (PaymentException e) {
		assertEquals("Mobile number should contain 10 digits",e.getMessage());
		}
	}
	
	@Test
	public void testPrinttransactionDetailsForMobileDoesNotExist() {
		Payments ac=new Payments();
		ac.setMobile_no("1234567890");
		try {
		Payments acc=service.printTransactionDetails(ac.getMobile_no());
		} catch (PaymentException e) {
		assertEquals("the mobile number is not there in the data base",e.getMessage());
		}
	}
	
	@Test
	public void testFundTransferForFirstMobile() {
	Payments ac=new Payments();
	Payments ac2=new Payments();
	ac.setMobile_no("950592");
	ac2.setMobile_no("9848468242");
	try {
		service.fundTransfer(ac.getMobile_no(),ac2.getMobile_no(),230);
	} catch (PaymentException e) {
		assertEquals("Mobile number should contain 10 digits",e.getMessage());
	}
	}
	
	@Test
	public void testFundTransferForSecondMobile() {
	Payments ac=new Payments();
	Payments ac2=new Payments();
	ac.setMobile_no("9999999999");
	ac2.setMobile_no("9848");
	try {
		service.fundTransfer(ac.getMobile_no(),ac2.getMobile_no(),230);
	} catch (PaymentException e) {
		assertEquals("Mobile number should contain 10 digits",e.getMessage());
	}
	}
	
	/*@Test
	public void testFundTransferForFirstMobileExist() {
	Account ac=new Account();
	Account ac2=new Account();
	ac.setMobile_no("9999888888");
	ac2.setMobile_no("9999999999");
	try {
		service.fundTransfer(ac.getMobile_no(),ac2.getMobile_no(),230);
	} catch (AccountException e) {
		assertEquals("the mobile number is not there in the data base",e.getMessage());
	}
	}
	
	@Test
	public void testFundTransferForSecondMobileExist() {
	Account ac=new Account();
	Account ac2=new Account();
	ac.setMobile_no("9999999999");
	ac2.setMobile_no("8888888888");
	try {
		service.fundTransfer(ac.getMobile_no(),ac2.getMobile_no(),-230);
	} catch (AccountException e) {
		assertEquals("Amount should be greater than zero",e.getMessage());
	}
	}
	*/
	
	
	
}
