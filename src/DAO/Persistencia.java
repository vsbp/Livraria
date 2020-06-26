package DAO;

import java.util.List;

public interface Persistencia<T> {
	public int create(T obj); // grava

//	public List<T> read(); // retorna todos
//
//	public boolean update(T obj); // atualiza
//
//	public boolean delete(T obj); // exclui
//
//	public T findByCodigo(int id); // retorna somente 1
}
