package app;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;


import models.Cart;
import models.Item;
import utils.HibernateXMLUtil;

public class Application {

	public static void main(String[] args) {

		Session session = HibernateXMLUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();

		Cart cart = new Cart();
		cart.setName("One");
		cart.setTotal(Integer.valueOf(100));
		session.persist(cart);

		Item item = new Item();
		item.setTotal(Integer.valueOf(200));
		session.persist(item);

		Item item1 = new Item(Integer.valueOf(300));
		Item item2 = new Item(Integer.valueOf(400));
		Item item3 = new Item(Integer.valueOf(500));
		Item item4 = new Item(Integer.valueOf(600));

		session.persist(item1);
		session.persist(item2);
		session.persist(item3);
		session.persist(item4);

		Item item5 = new Item();
		item5.setTotal(Integer.valueOf(700));
		Item item6 = new Item();
		item6.setTotal(Integer.valueOf(800));
		Item item7 = new Item();
		item7.setTotal(Integer.valueOf(900));
		Item item8 = new Item();
		item8.setTotal(Integer.valueOf(1000));
		Set<Item> items = new HashSet<>(Arrays.asList(item5, item6, item7, item8));

		Cart cart1 = new Cart(Integer.valueOf(1100), "cart1");
		Cart cart2 = new Cart(Integer.valueOf(1200), "cart2");
		Cart cart3 = new Cart(Integer.valueOf(1300), "cart3");
		Cart cart4 = new Cart(Integer.valueOf(1400), "cart4");

		// cart1.setItems(items);

		session.persist(cart1);
		session.persist(cart2);
		session.persist(cart3);
		session.persist(cart4);

		transaction.commit();
		session.close();

	}
}