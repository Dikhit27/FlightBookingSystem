 package com.payment.controller;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.payment.models.TransactionDetails;
import com.payment.service.PaymentServiceImpl;


/**
*
* @author Yogesh Chafle
*/
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/payment")
public class PaymentController {
	/**
	 *
	 * @author Yogesh Chafle
	 */
	
	/**
	 * Initialized the logger object
	 */
	
	private static Logger log = Logger.getLogger(PaymentController.class);
		
	/**
	 * PaymentServiceImpl autowired
	 */
	@Autowired
	public PaymentServiceImpl service;
	
	

	/**
	 * Method to create transaction
	 */
	@GetMapping("/createTransaction/{amount}")
	public TransactionDetails createTransaction(@PathVariable("amount")Double amount) {
		log.info("Transaction is created successfully");
		return  service.createTransaction(amount);
		
	}
	
	 
	
	
	
}
