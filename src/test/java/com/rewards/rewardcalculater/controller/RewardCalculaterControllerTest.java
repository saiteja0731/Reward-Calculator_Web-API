package com.rewards.rewardcalculater.controller;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rewards.rewardcalculater.entity.Customer;
import com.rewards.rewardcalculater.entity.Transaction;
import com.rewards.rewardcalculater.model.Rewards;
import com.rewards.rewardcalculater.service.RewardServiceImpl;

import net.bytebuddy.agent.VirtualMachine.ForHotSpot.Connection.Response;



@AutoConfigureMockMvc
@SpringBootTest(classes = RewardCalculaterControllerTest.class)
public class RewardCalculaterControllerTest {

	@Mock
	private RewardCalculaterController rewardCalculaterController;

	@Mock
	private ObjectMapper objectMapper;
	

	@Test
	public void testEmployee() throws Exception {
		Rewards rewards = rewardMockData();
		
		ResponseEntity<Object> responseEntity = new ResponseEntity<>(
				rewards,
			    HttpStatus.OK
			);
		Mockito.when(rewardCalculaterController.getPointsByCustomerId(1l)).thenReturn(responseEntity);
		Rewards	rewardResponse=	(Rewards)responseEntity.getBody();
		assertEquals(1l, rewardResponse.getCustomerId()); 		

	}
	@Test 
	public void test_getPointsByCustomerId_success() throws Exception {
		Transaction transaction = transactionMockData(); 
	
		ResponseEntity<Object> responseEntity = new ResponseEntity<>(
				transaction,
			    HttpStatus.OK
			);
		Mockito.when(rewardCalculaterController.getTransactionById(1l)).thenReturn(responseEntity);
		Transaction	transactionResponse=	(Transaction)responseEntity.getBody();
		assertEquals(123, transactionResponse.getTransactionAmount()); 		
	}
	@Test 
	public void test_getPointsByCustomerId() throws Exception {
		Customer customer = customerMockData(); 
		
		ResponseEntity<Object> responseEntity = new ResponseEntity<>(
				customer,
			    HttpStatus.OK
			);
		Mockito.when(rewardCalculaterController.getTransactionById(1l)).thenReturn(responseEntity);
		Customer	customerResponse=	(Customer)responseEntity.getBody();
		assertEquals("Micheal", customerResponse.getCustomerName()); 		
	
	}
	private Customer customerMockData() {
         Customer customer=new Customer();
         customer.setCustomerId(1l);
         customer.setCustomerName("Micheal");
         
		return customer;
	}
	private Rewards rewardMockData() {
		Rewards	rewards=new Rewards (); 
		rewards.setCustomerId(1l);
		rewards.setLastMonthRewards(123); 
		rewards.setLastSecondMonthRewards(0);
		rewards.setLastThirdMonthRewards(0); 
		rewards.setTotalRewards(0);
		return rewards;
	}
	private Transaction transactionMockData() {
		Transaction	transaction=new Transaction (); 
		transaction.setCustomerId(1l);
		transaction.setTransactionAmount(123);
		return transaction;
	}


}
