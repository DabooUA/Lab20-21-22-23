package com.gc.controller;

import java.util.ArrayList; 

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.gc.dto.ProductDto;
import com.gc.dto.UserDto;

/*
 * author: Serhiy Bardysh
 *
 */

@Controller
public class HomeController {

	// this method is currently returning all of the table info later this will be
	// pulled out into an arraylist method to be reused
	@RequestMapping("/")
	public ModelAndView helloWorld() {

		Configuration config = new Configuration().configure("hibernate.cfg.xml");
		/*
		 * The SessionFactory is a factory of session and client of Connection Provider.
		 * It holds second level cache (optional) of data
		 */
		SessionFactory sessionFactory = config.buildSessionFactory();
		/*
		 * A Session is used to get a physical connection with a database. The Session
		 * object is lightweight and designed to be instantiated each time an
		 * interaction is needed with the database. Persistent objects are saved and
		 * retrieved through a Session object.
		 * 
		 * The session objects should not be kept open for a long time because they are
		 * not usually thread safe and they should be created and destroyed them as
		 * needed. The main function of the Session is to offer, create, read, and
		 * delete operations for instances of mapped entity classes.
		 */
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Criteria crit = session.createCriteria(ProductDto.class); // the strikethrough indicates this is deprecated
		ArrayList<ProductDto> list = (ArrayList<ProductDto>) crit.list(); 
		tx.commit();
		session.close();

		return new ModelAndView("index", "cList", list);
	}
	@RequestMapping("/welcome")
	public ModelAndView helloWorld2() {

		Configuration config = new Configuration().configure("hibernate.cfg.xml");
		/*
		 * The SessionFactory is a factory of session and client of Connection Provider.
		 * It holds second level cache (optional) of data
		 */
		SessionFactory sessionFactory = config.buildSessionFactory();
		/*
		 * A Session is used to get a physical connection with a database. The Session
		 * object is lightweight and designed to be instantiated each time an
		 * interaction is needed with the database. Persistent objects are saved and
		 * retrieved through a Session object.
		 * 
		 * The session objects should not be kept open for a long time because they are
		 * not usually thread safe and they should be created and destroyed them as
		 * needed. The main function of the Session is to offer, create, read, and
		 * delete operations for instances of mapped entity classes.
		 */
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Criteria crit = session.createCriteria(ProductDto.class); // the strikethrough indicates this is deprecated
		ArrayList<ProductDto> list = (ArrayList<ProductDto>) crit.list(); 
		tx.commit();
		session.close();

		return new ModelAndView("welcome", "cList", list);
	}

	@RequestMapping("/searchbyproduct")
	public ModelAndView searchCity(@RequestParam("itemName") String itname) {

		Configuration cfg = new Configuration().configure("hibernate.cfg.xml");

		SessionFactory sessionFact = cfg.buildSessionFactory();

		Session selectCustomers = sessionFact.openSession();

		selectCustomers.beginTransaction();

		// Criteria is used to create the query
		Criteria c = selectCustomers.createCriteria(ProductDto.class);

		// adding additional search criteria to the query
		// the first parameter is referencing the table column that we want to search
		// against
		c.add(Restrictions.like("code", "%" + itname + "%"));

		ArrayList<ProductDto> customerList = (ArrayList<ProductDto>) c.list();

		return new ModelAndView("welcome", "cList", customerList);
	}

	// mapping needed to send to a form to add a new product
	@RequestMapping("/addItem")
	public String newProduct() {
		return "addprodform";
	}

	@RequestMapping("/addnewproduct")
	public String addNewCustomer(@RequestParam("itemName") String itname, @RequestParam("description") String desc,
			@RequestParam("quantity") int quantity,@RequestParam("itemPrice") double price, Model model) {

		Configuration cfg = new Configuration().configure("hibernate.cfg.xml");

		SessionFactory sessionFact = cfg.buildSessionFactory();

		Session session = sessionFact.openSession();

		Transaction tx = session.beginTransaction();

		ProductDto newProduct = new ProductDto();

		newProduct.setItemName(itname);
		newProduct.setDescription(desc);
		newProduct.setQuantity(quantity);
		newProduct.setItemPrice(price);

		session.save(newProduct);
		tx.commit();
		session.close();

		model.addAttribute("newStuff", newProduct);
		return "addprodsuccess";
	}

	@RequestMapping("/registerform")
	public String addNewUser(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName, @RequestParam("email") String email,
			@RequestParam("phoneNum") int phoneNum,@RequestParam("password") String userPassword, Model model) {

		Configuration cfg = new Configuration().configure("hibernate.cfg.xml");

		SessionFactory sessionFact = cfg.buildSessionFactory();

		Session session = sessionFact.openSession();

		Transaction tx = session.beginTransaction();

		UserDto newUser = new UserDto();

		newUser.setFirstName(firstName);
		newUser.setLastName(lastName);
		newUser.setEmail(email);
		newUser.setPhoneNum(phoneNum);
		newUser.setuserPassword(userPassword);

		session.save(newUser);
		tx.commit();
		session.close();

		model.addAttribute("newStuff", newUser);
		return "addprodsuccess";
	}
	@RequestMapping("/delete")
	public ModelAndView deleteCustomer(@RequestParam("id") String itemName) {

		// temp Object will store info for the object we want to delete
		ProductDto temp = new ProductDto();
		temp.setItemName(itemName);

		Configuration cfg = new Configuration().configure("hibernate.cfg.xml");

		SessionFactory sessionFact = cfg.buildSessionFactory();

		Session codes = sessionFact.openSession();

		codes.beginTransaction();

		codes.delete(temp); // delete the object from the list

		codes.getTransaction().commit(); // delete the row from the database table

		ArrayList<ProductDto> prodList = getAllProducts();

		return new ModelAndView("index", "cList", prodList);
	}

	// this mapping is needed to pass the parameter as a hidden field to the update
	// form
	@RequestMapping("/update")
	public ModelAndView updateForm(@RequestParam("itemName") String itemName2) {

		return new ModelAndView("updateprodform", "itemName", itemName2);
	}

	@RequestMapping("/updateproduct")
	public ModelAndView updateProduct(@RequestParam("itemName") String itemName, @RequestParam("quantity") int quantity,
			@RequestParam("description") String desc, @RequestParam("itemPrice") double price) {

		// temp Object will store info for the object we want to update
		ProductDto temp = new ProductDto();
		temp.setItemName(itemName);		
		temp.setDescription(desc);
		temp.setQuantity(quantity);
		temp.setItemPrice(price);

		Configuration cfg = new Configuration().configure("hibernate.cfg.xml");

		SessionFactory sessionFact = cfg.buildSessionFactory();

		Session codes = sessionFact.openSession();

		codes.beginTransaction();

		codes.update(temp); // update the object from the list

		codes.getTransaction().commit(); // update the row from the database table

		ArrayList<ProductDto> prodList = getAllProducts();

		return new ModelAndView("index", "cList", prodList);
	}

	private ArrayList<ProductDto> getAllProducts() {
		Configuration config = new Configuration().configure("hibernate.cfg.xml");
		SessionFactory sessionFactory = config.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Criteria crit = session.createCriteria(ProductDto.class);
		ArrayList<ProductDto> list = (ArrayList<ProductDto>) crit.list();
		tx.commit();
		session.close();
		return list;
	}

}
