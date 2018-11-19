package dao;

import java.util.List;

import beans.Shoe;

public interface ShoeDao {
	
	public List<Shoe> getAll();
	public List<Shoe> getByColor(String color);
	public List<Shoe> getByType(String type);
	public List<Shoe> getBySize(Double size);
	public List<Shoe> getByBrand(String brand);
	public List<Shoe> getByPricerange(Double lower_bound, Double upper_bound);
	public List<Shoe> getBySizerange(Double lower_bound, Double upper_bound);
	public Shoe getOneShoe(Shoe shoe);
	public void update(Shoe shoe);
	public void remove(Shoe shoe);
	public void add(Shoe shoe);

}
