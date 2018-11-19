package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import beans.Client;
import beans.Shoe;
import beans.ShoeRequest;
import util.HibernateUtil;

public class ShoeRequestDaoImp implements ShoeRequestDao {

	@Override
	public boolean add(ShoeRequest shoereq) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		int saved = (int) s.save(shoereq);
		tx.commit();
		s.close();
		if (saved > 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean resolve(ShoeRequest shoereq) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		s.update(shoereq);
		Shoe request = shoereq.getShoe_requested();
		Shoe toTrade = shoereq.getShoe_to_trade();
		shoereq.setStatus(1);
		request.setClient(shoereq.getClient_requester());
		toTrade.setClient(shoereq.getClient_owner());
		request.setShoeStatus(1);
		toTrade.setShoeStatus(1);
		s.update(request);
		s.update(toTrade);
		tx.commit();
		ShoeRequest changed = s.get(ShoeRequest.class, shoereq.getId());
		if (changed.getClient_owner().equals(shoereq.getClient_owner())) {
			return true;
		}
		return false;
	}

	@Override
	public boolean deny(ShoeRequest shoereq) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		shoereq.setStatus(2);
		s.update(shoereq);
		tx.commit();
		ShoeRequest changed = s.get(ShoeRequest.class, shoereq.getId());
		if (changed.getClient_owner().equals(shoereq.getClient_owner())) {
			return true;
		}
		return false;
	}

	@Override
	public List<ShoeRequest> getAllByShoe(Shoe shoe) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ShoeRequest> getAllBelongingToClient(Client client) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ShoeRequest> getAllMadeByClient(Client client) {
		// TODO Auto-generated method stub
		return null;
	}

}
