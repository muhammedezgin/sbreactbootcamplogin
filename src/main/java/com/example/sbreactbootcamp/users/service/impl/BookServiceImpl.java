package com.example.sbreactbootcamp.users.service.impl;

import java.util.Collection;
import java.util.Optional;

import com.example.sbreactbootcamp.books.model.Books;
import com.example.sbreactbootcamp.users.domain.Book;
import com.example.sbreactbootcamp.users.repository.BookRepository;
import com.example.sbreactbootcamp.users.service.IPageService;
import com.example.sbreactbootcamp.users.service.IService;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;



@Service
public class BookServiceImpl implements IService<Book>, IPageService<Book> {

	@Autowired
	private BookRepository bookRepository;
	
	@Override
	public Collection<Book> findAll() {
		return (Collection<Book>) bookRepository.findAll();
	}

	@Override
	public Page<Book> findAll(Pageable pageable, String searchText) {
		return bookRepository.findAllBooks(pageable, searchText);
	}

	public Page<Book> findAll(Pageable pageable) {
		return bookRepository.findAll(pageable);
	}

	public Optional<Book> findById(Long id) {
		return bookRepository.findById(id);
	}

	@Override
	public Book saveOrUpdate(Book book) {
		return bookRepository.save(book);
	}

	@Override
	public String deleteById(Long id) {
		JSONObject jsonObject = new JSONObject();
		try {
			bookRepository.deleteById(id);
			jsonObject.put("message", "Book deleted successfully");
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return jsonObject.toString();
	}

}
