package iteach.eaap.architecturestyles.hexagonal.application.port.outbound;

import java.util.List;

import iteach.eaap.architecturestyles.hexagonal.domain.Book;


public interface BookRepository {
	List<Book> queryAll();
	void insertOne(Book book);
}
