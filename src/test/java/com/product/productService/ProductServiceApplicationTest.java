package com.product.productService;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.product.dao.ProductDao;
import com.product.dao.ProductDaoImpl;
import com.product.model.Manufacturer;
import com.product.model.Order;
import com.product.model.Product;
import com.product.service.ProductServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceApplicationTest {

	@Mock
	private ProductDao productDao;

	@Mock
	private ProductDaoImpl productDaoImpl;

	@InjectMocks
	private ProductServiceImpl productServiceImpl;

	private List<Product> productList;
	private Product product1;
	private Product product2;

	@Before
	public void preRequisiteDataCreation() {

		/* Data Creation */
		List<String> othersize = new ArrayList<String>();
		Map<String, Integer> details = new HashMap<String, Integer>();
		details.put("quantity",1);
		details.put("sold",2);
		othersize.add("Rick");
		othersize.add("Ron");
		othersize.add("Victor");
		Manufacturer manufacturer = Manufacturer.builder()
				.manufactureId(100)
				.manufactureName("ProductManu..")
				.tinNo(1234).build();
		product1 = Product.builder()
				.name("Sita")
				.id(1).size("12")
				.color("Pink")
				.othersize(othersize)
				.Details(details)
				.manufacturer(manufacturer)
				.build();
		product2 = Product.builder()
				.name("Sapna")
				.id(1)
				.size("12")
				.color("Pink")
				.othersize(othersize)
				.Details(details)
				.manufacturer(manufacturer)
				.build();
	}

	@Test
	public void getAllProductAscTest() {

		/* Given */
		List<Product> productList = new ArrayList<Product>();
		productList.add(product1);
		productList.add(product2);
		when(productDaoImpl.findProductByNameLikeOrderByNameAsc("S")).thenReturn(productList);

		/* When */
		List<Product> productNewList = productServiceImpl.getAllProducts(Order.ASC,"S");

		/* Then */
		Assert.assertEquals(productNewList, productList);
	}

	@Test
	public void getAllProductDescTest() {

		/* Given */
		List<Product> productList = new ArrayList<Product>();
		productList.add(product2);
		productList.add(product1);
		when(productDaoImpl.findProductByNameLikeOrderByNameDesc("S")).thenReturn(productList);

		/* When */
		List<Product> productNewList = productServiceImpl.getAllProducts(Order.DESC,"S");

		/* Then */
		Assert.assertEquals(productNewList, productList);
	}

	@Test
	public void getProductById() {

		/* Given */
		when(productDaoImpl.getProductById(1)).thenReturn(Optional.of(product1));

		/* When */
		Optional<Product> product = productDaoImpl.getProductById(1);

		/* Then */
		Assert.assertEquals(Optional.of(product1).get(),product.get());
	}

	@Test
	public void productNotFoundById() {

		/* Given */
		when(productDaoImpl.getProductById(1)).thenReturn(Optional.empty());

		/* When */
		Optional<Product> product = productDaoImpl.getProductById(1);

		/* Then */
		Assert.assertEquals(Optional.empty(),product);
	}

	@Test
	public void deleteAllProduct() {

		/* When */
		productServiceImpl.deleteallProducts();

		/* Then */
		Mockito.verify(productDao).deleteAllProducts();
	}

	@Test
	public void deleteProductById() {

		/* When */
		productServiceImpl.deleteProductbyId(1);

		/* Then */
		Mockito.verify(productDao).deleteProductById(1);
	}

	@Test
	public void verifyProductCreatedSuccessfully() {

		/* When */
		productServiceImpl.createProduct(product1);

		/* Then */
		Mockito.verify(productDao, Mockito.atLeastOnce()).save(product1);
	}

	@Test
	public void productUpdate() {

		/* When */
		productServiceImpl.updateProduct(product1);

		/* Then */
		Assert.assertEquals(product1.getId(),1);
	}
}
