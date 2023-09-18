package com.payment.service;

import java.util.ArrayList;
import java.util.List;

import com.payment.models.*;
import com.payment.models.TransactionDetails;

/**
 *
 * @author Yogesh Chafle
 */
public interface PaymentService {
	/**
	 *
	 * @author Yogesh Chafle
	 */

	TransactionDetails createTransaction(Double amount);

}
