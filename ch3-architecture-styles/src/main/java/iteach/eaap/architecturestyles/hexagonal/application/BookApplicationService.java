package iteach.eaap.architecturestyles.hexagonal.application;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import iteach.eaap.architecturestyles.hexagonal.application.port.inbound.BookUseCase;
import iteach.eaap.architecturestyles.hexagonal.application.port.outbound.BookRepository;
import iteach.eaap.architecturestyles.hexagonal.domain.Book;
import lombok.AllArgsConstructor;

/**
 * BookUsecase (inbound port) 的实现类
 * 在 inbound adapter 调用 BookUsecase 时，
 * 此类的对象将被注入到 inbound adapter 对象中。
 * 
 * <b>此处可见修饰符为 protected，因为此对象由容器管理，
 * 对外部应该不可见</b>
 */
@Service
@Transactional
@AllArgsConstructor
class BookApplicationService implements BookUseCase {
	private BookRepository repository;

	@Override
	public List<Book> viewAllBooks() {
		return repository.queryAll();
	}

	@Override
	public void addBook(Book book) {
		repository.insertOne(book);
	}
}
