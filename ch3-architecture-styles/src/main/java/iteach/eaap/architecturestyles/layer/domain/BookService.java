package iteach.eaap.architecturestyles.layer.domain;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import iteach.eaap.architecturestyles.layer.persistence.BookRepository;
import lombok.AllArgsConstructor;

@Service
@Transactional
@AllArgsConstructor
public class BookService {
	private BookRepository repository;

	public List<Book> allBooks() {
		return repository.findAll();
	}

	public void addBook(Book book) {
		repository.save(book);
	}
}
