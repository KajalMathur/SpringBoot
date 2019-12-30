package com.product.productService;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.product.dao.CustomerDao;
import com.product.dao.DefaultProductDao;
import com.product.exception.NotFoundException;
import com.product.model.Address;
import com.product.model.Customer;
import com.product.model.CustomerProductResponse;
import com.product.model.Manufacturer;
import com.product.model.Product;
import com.product.service.CustomerProductServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerProductServiceApplicationTest {

	@Mock
	private CustomerDao customerDao;

	@Mock
	private DefaultProductDao defaultProductDao;

	@InjectMocks
	private CustomerProductServiceImpl customerProductServiceImpl;

	private Product product;
	private Customer customer;

	@Before
	public void preRequisiteDataCreation() {

		/* Product data creation */
		ImmutableList<String> othersize = ImmutableList.of("Rick", "Ron", "Victor");
		ImmutableMap<String, Integer> details = ImmutableMap.of("quantity",1, "sold",2);
		Manufacturer manufacturer = Manufacturer.builder()
				.manufactureId(100)
				.manufactureName("ProductManu..")
				.tinNo(1234)
				.build();
		product = Product.builder()
				.name("Sita")
				.id(1)
				.size("12")
				.color("Pink")
				.othersize(othersize)
				.Details(details)
				.manufacturer(manufacturer)
				.build();

		/* Customer Data creation */
		Date date = java.util.Calendar.getInstance().getTime();
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.YEAR, 2);
		Date expiryDate = c.getTime();
		Address address = Address.builder()
				.streetName("Abc1")
				.state("Haryana")
				.country("India")
				.build();
		customer = Customer.builder()
				.firstName("Ram")
				.lastName("shaerma")
				.joiningDate(date)
				.expiryDate(expiryDate)
				.address(address).build();
	}

	@Test
	public void verifyFindCustomerProductById() {

		/* Given */
		when(defaultProductDao.findById(1)).thenReturn(Optional.of(product));
		when(customerDao.getCustomerResponseById(1)).thenReturn(customer);

		/* When */
		CustomerProductResponse customerProductResponse = customerProductServiceImpl.getcustomerProductById(1, 1);

		/* Then */
		Assert.assertEquals(customerProductResponse.getProduct().getId(), 1);
		Assert.assertEquals(customerProductResponse.getCustomerResponse().getFirstName(), "Ram");
	}

	@Test
	public void verifyFindCustomerProductResponseIfProductNotPresent() {

		boolean thrown = false;

		/* Given */
		when(defaultProductDao.findById(0)).thenReturn(Optional.empty());
		when(customerDao.getCustomerResponseById(1)).thenReturn(customer);

		/* When */
		try {
			customerProductServiceImpl.getcustomerProductById(1, 0);
		} catch (NotFoundException ex) {
			thrown = true;
			assertEquals(ex.getMessage(), "Product Not Found , Type : Product , Id =0");
		}

		/* Then */
		Assert.assertEquals(true, thrown);
	}
	
	@Test
	public void verifyFindCustomerProductResponseIfCustomerNotPresent() {

		boolean thrown = false;

		/* Given */
		when(defaultProductDao.findById(1)).thenReturn(Optional.of(product));
		when(customerDao.getCustomerResponseById(2)).thenThrow(new NotFoundException("Customer Not Found , Type : Customer , id=2"));

		/* When */
		try {
			customerProductServiceImpl.getcustomerProductById(2, 1);
		} catch (NotFoundException ex) {
			thrown = true;
			assertEquals(ex.getMessage(), "Customer Not Found , Type : Customer , id=2");
		}

		/* Then */
		Assert.assertEquals(true, thrown);
	}
}
