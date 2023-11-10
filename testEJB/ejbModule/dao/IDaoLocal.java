package dao;

import java.util.List;

import jakarta.ejb.Local;

@Local
public interface IDaoLocal<T> {
	T create (T o);
	void delete(T o);
	T update (T o);
	T findById(int id);
	List<T> findAll();
}