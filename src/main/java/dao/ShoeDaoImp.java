package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import beans.Shoe;
import util.HibernateUtil;

public class ShoeDaoImp implements ShoeDao {

	@Override
	public List<Shoe> getAll() {
		Session s = HibernateUtil.getSession();
//		Query<Shoe> query = s.createQuery("from Shoe");
		List<Shoe> shoes = s.createQuery("from Shoe").list();
		s.close();
		return shoes;
	}

	@Override
	public List<Shoe> getByColor(String color) {
		color = color.toUpperCase();
		Session s = HibernateUtil.getSession();
		List<Shoe> shoesOfColor = s.createQuery("from Shoe where color like '%"+ color + "'").list();
		s.close();
		return shoesOfColor;
	}

	@Override
	public List<Shoe> getByType(String type) {
		Session s = HibernateUtil.getSession();
		List<Shoe> shoesofType = s.createQuery("from Shoes where color="+ type).list();
		s.close();
		return shoesofType;
	}

	@Override
	public List<Shoe> getBySize(Double size) {
		Session s = HibernateUtil.getSession();
		List<Shoe> shoesOfSize = s.createQuery("from Shoes where size like '%"+ size + "'").list();
		s.close();
		return shoesOfSize;
	}
	
	

	@Override
	public List<Shoe> getByBrand(String brand) {
		brand = brand.toUpperCase();
		Session s = HibernateUtil.getSession();
		List<Shoe> shoesOfBrand = s.createQuery("from Shoe where brand like '%"+ brand + "'").list();
		s.close();
		return shoesOfBrand;
	}

//	@Override
//	public List<Shoe> getByPricerange(Integer lower_bound, Integer upper_bound) {
//		Session s = HibernateUtil.getSession();
//		CriteriaBuilder cb = s.getCriteriaBuilder();
//		CriteriaQuery<Shoe> cq = cb.createQuery(Shoe.class);
//		Root<Shoe> root = cq.from(Shoe.class);
//		cq.select(root);
//		cq.where(cb.)
//		List<Shoe> shoes = new ArrayList<>();
//		List<Shoe> shoesInPriceRange = s.createCriteria(Shoe.class)
//										.add(Restrictions.ge("price", lower_bound))
//										.add(Restrictions.le("price", upper_bound))
//										.setProjection(Property.forName("price"))
//										.uniqueResult()
//										.list()
//		return shoes;									
//	}

	@Override
	public Shoe getOneShoe(Shoe shoe) {
		Session s = HibernateUtil.getSession();
		Shoe the_shoe = s.get(Shoe.class, shoe.getId());
		s.close();
		return the_shoe;
	}

	@Override
	public void update(Shoe shoe) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		s.update(shoe);
		tx.commit();
		s.close();
		
	}

	@Override
	public void remove(Shoe shoe) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		s.remove(shoe);
		tx.commit();
		s.close();
	}

	@Override
	public void add(Shoe shoe) {
		shoe.setColor(shoe.getColor().toUpperCase());
		shoe.setBrand(shoe.getBrand().toUpperCase());
		
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		s.save(shoe);
		tx.commit();
		s.close();
	}

	@Override
	public List<Shoe> getByPricerange(Double lower_bound, Double upper_bound) {
		Session s = HibernateUtil.getSession();
		String hql = "from Shoe where price between :a and :b";
		List<Shoe> shoesInPriceRange = s.createQuery(hql)
										.setParameter("a", lower_bound)
										.setParameter("b", upper_bound)
										.list();
		s.close();
		return shoesInPriceRange;
	}

	@Override
	public List<Shoe> getBySizerange(Double lower_bound, Double upper_bound) {
		Session s = HibernateUtil.getSession();
		String hql = "from Shoe where shoesize between :a and :b";
		List<Shoe> shoesInRange = s.createQuery(hql)
										.setParameter("a", lower_bound)
										.setParameter("b", upper_bound)
										.list();
		s.close();
		return shoesInRange;
	}

}
