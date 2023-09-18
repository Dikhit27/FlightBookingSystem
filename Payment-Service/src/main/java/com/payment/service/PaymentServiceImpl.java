package com.payment.service;

import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.payment.models.TransactionDetails;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import com.razorpay.Order;


/**
 *
 * @author Yogesh Chafle
 */
@Service
public class PaymentServiceImpl implements PaymentService {
	/**
	 *
	 * @author Yogesh Chafle
	 */

	private static final String KEY = "rzp_test_hmUEXh3KzHRntS";
	private static final String KEY_SECRET = "ARCLghVJQuetCyrP6RTLl5lL";
	private static final String CURRENCY = "INR";

	/**
	 * Method to create transaction
	 */
	public TransactionDetails createTransaction(Double amount) {

		try {
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("amount", (amount * 100));
			jsonObject.put("currency", CURRENCY);

			RazorpayClient razorpayClient = new RazorpayClient(KEY, KEY_SECRET);

			Order order = razorpayClient.orders.create(jsonObject);
			TransactionDetails transactionDetails = prepareTrasactionDetails(order);
			return transactionDetails;
		} catch (RazorpayException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Method to prepare transaction details
	 */
	public TransactionDetails prepareTrasactionDetails(Order order) {
		String orderId = order.get("id");
		String currency = order.get("currency");
		int amount = order.get("amount");
		System.out.println(order);
		TransactionDetails transactionDetails = new TransactionDetails(orderId, currency, amount,KEY);
		return transactionDetails;
	}

}

