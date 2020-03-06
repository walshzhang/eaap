package iteach.eaap.architecturestyles.hexagonal.adapter.outbound;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import iteach.eaap.architecturestyles.hexagonal.application.port.outbound.BookRepository;
import iteach.eaap.architecturestyles.hexagonal.domain.Book;

public interface JpaBookRepository extends BookRepository, JpaRepository<Book, Integer>  {
	@Override
	default List<Book> queryAll() {
		return findAll();
	}
	
	@Override
	default void insertOne(Book book) {
		save(book);
	}
}
