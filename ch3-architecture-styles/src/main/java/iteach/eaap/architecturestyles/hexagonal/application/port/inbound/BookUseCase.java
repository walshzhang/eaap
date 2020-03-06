package iteach.eaap.architecturestyles.hexagonal.application.port.inbound;

import java.util.List;

import iteach.eaap.architecturestyles.hexagonal.domain.Book;

public interface BookUseCase {
	List<Book> viewAllBooks();
	void addBook(Book book);
}
