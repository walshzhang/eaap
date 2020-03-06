package iteach.eaap.architecturestyles.hexagonal.adapter.inbound;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import iteach.eaap.architecturestyles.hexagonal.application.port.inbound.BookUseCase;
import iteach.eaap.architecturestyles.hexagonal.domain.Book;
import lombok.AllArgsConstructor;

/**
 * inbound adapter：提供 api 服务
 * 由外部系统调用，可访问级别调整为 protected
 */
@RestController
@RequestMapping("/api")
@AllArgsConstructor
class RestBookController { 
	private BookUseCase usecase;
	
	@GetMapping("books")
	public List<Book> allBooks() {
		return usecase.viewAllBooks();
	}
	
	@PostMapping("books")
	public void addBook(@RequestBody Book book) {
		usecase.addBook(book);
	}
}
