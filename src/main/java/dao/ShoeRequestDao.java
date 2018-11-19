package dao;

import java.util.List;

import beans.Client;
import beans.Shoe;
import beans.ShoeRequest;

public interface ShoeRequestDao {

	public boolean add(ShoeRequest shoereq);
	public boolean resolve(ShoeRequest shoereq);
	public boolean deny(ShoeRequest shoereq);
	public List<ShoeRequest> getAllByShoe(Shoe shoe);
	public List<ShoeRequest> getAllBelongingToClient(Client client);
	public List<ShoeRequest> getAllMadeByClient(Client client);
}
