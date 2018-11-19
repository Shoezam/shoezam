package util;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import beans.Client;
import beans.Shoe;
import beans.ShoeRequest;
import dao.ClientDaoImp;
import dao.ShoeDaoImp;
import dao.ShoeRequestDaoImp;

public class Driver {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSession();
		session.close();
//		
		ClientDaoImp cd = new ClientDaoImp();
		ShoeDaoImp sd = new ShoeDaoImp();
		ShoeRequestDaoImp sr = new ShoeRequestDaoImp();
//		
//		testing create client
		Client pam = new Client("Pam", "Beasely", "pamb@pratinstitutde.edu", "password", "213 cherry lane", 38383, "USA", "909-999-9999");
		Client jim = new Client("Jim", "Halpern", "jh@dundermifflin.biz", "password", "213 cherry lane", 38383, "USA", "909-999-9999");
		cd.create(jim);
		cd.create(pam);
		List<Client> clients = cd.getAll();
		System.out.println("Clients fetched from DB: " + clients);
//		System.out.println("Client fetched from DB:  "+ gotten);
//		Give jim some shoes
		sd.add(new Shoe(jim, "Air Jordans", "Nike", 8.5, 300.70, "Yellow", 0));
		List<Shoe> shoes = sd.getAll();
		System.out.println("Shoes fetched from db: " + shoes);
		sd.add(new Shoe(jim, "Classic", "Addidas", 12.5, 245.00, "Red", 0));
		sd.add(new Shoe(jim, "Downshifter", "Nike", 10.0, 50.00, "Green", 1));
		sd.add(new Shoe(jim, "Air Max Infuriate", "Nike", 12.5, 57.00, "White", 0));
		sd.add(new Shoe(jim, "Cloadfoam", "Addidas", 10.0, 210.05, "White", 0));
		sd.add(new Shoe(pam, "Air Jordans", "Nike", 9.5, 1200.0, "Blue", 0));
		List<Shoe> testShoes = new ArrayList<>();
		
//		get one shoe SUCCESS!
//		Shoe fetched = sd.getOneShoe(new Shoe(3));
//		System.out.println("Fetched on shoe from DB: " + fetched);
//		edit shoe SUCCESS!
//		sd.update(new Shoe(3, jim, "Air Max Infuriate", "Nike", 12.5, 4000.00, "Maroon"));
//		Shoe edited = sd.getOneShoe(new Shoe(3));
//		System.out.println("Edited shoe: " + edited);
//		testShoes = sd.getAll();
//		remove a shoe SUCCESS
//		sd.remove(new Shoe(3));
		
		
//		System.out.println(sd.getAll());
//		get shoes by color: SUCCESS!
//		System.out.println(sd.getByColor("white"));
//		get shoes by brand: SUCCESS!
//		System.out.println(sd.getByBrand("Nike"));
//		get shoes in price range: SUCCESS!
//		System.out.println(sd.getByPricerange(49.00, 250.00));
//		get shoes in size range:
//		System.out.println(sd.getBySizerange(8.0, 11.0));
		
//		********* Shoe requests *********
//		make a new request for a shoe: SUCCESS!
		Shoe nikes = sd.getOneShoe(new Shoe(1));
		Shoe airJs = sd.getOneShoe(new Shoe(6));
		ShoeRequest shoreq = new ShoeRequest(jim, pam, nikes, airJs, "I'd love to trade shoes with you Jim.");
//		ShoeRequest resolved = new ShoeRequest(1, pam, jim, nikes, airJs, "I'd love to trade shoes with you Jim.");
		sr.add(shoreq);
//		approve a request: SUCCESS!
//		boolean success = sr.resolve(resolved);
//		System.out.println(success);
//		deny a request: SUCCESS!
		ShoeRequest denied = new ShoeRequest(1, pam, jim, nikes, airJs, "I'd love to trade shoes with you Jim.");
		boolean success = sr.deny(denied);
	}
}
