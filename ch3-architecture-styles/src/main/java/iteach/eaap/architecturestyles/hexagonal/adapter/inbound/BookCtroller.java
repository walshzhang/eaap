package iteach.eaap.architecturestyles.hexagonal.adapter.inbound;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import iteach.eaap.architecturestyles.hexagonal.application.port.inbound.BookUseCase;
import iteach.eaap.architecturestyles.hexagonal.domain.Book;
import lombok.AllArgsConstructor;

/**
 * inbound adapter：提供 web 服务
 * @author walsh
 *
 */
@Controller
@AllArgsConstructor
class BookController {
	private BookUseCase usecase;
	
	@GetMapping("/books")
	String getBook(Model model) {
		model.addAttribute("books", usecase.viewAllBooks());
		return "books";
	}
	
	@PostMapping("/books")
	String addBook(Book book) {
		usecase.addBook(book);
		return "redirect:/books";
	}
}
