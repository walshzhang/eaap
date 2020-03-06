package iteach.eaap.architecturestyles.layer.api;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import iteach.eaap.architecturestyles.layer.domain.Book;
import iteach.eaap.architecturestyles.layer.domain.BookService;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class BookController {
	private BookService service;
	
	@GetMapping("/books")
	public List<Book> getBooks() {
		return service.allBooks();
	}
	
	@PostMapping("/books")
	public void addBook(@RequestBody Book book) {
		service.addBook(book);
	}
}
