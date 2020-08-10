package hu.springbootrestfuljpa.books.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import hu.springbootrestfuljpa.books.model.Book;
import hu.springbootrestfuljpa.books.repository.BookRepository;

public class BookControllerTest {
	
		@Mock
		private BookRepository bookRepository;
		
		@InjectMocks
		BookController BookController;
		
		@Before
		public void init() {
			MockitoAnnotations.initMocks(this);
			
		}
		
		@Test
		public void retrieveAllBooksTest() {
			final Book book = new Book();
			Mockito.when(bookRepository.findAll()).thenReturn(Arrays.asList(book));
			
			final List<Book> response = BookController.retrieveAllBooks();
			
			assertNotNull(response); // revisa que retorne un nulo 
			
			assertFalse(response.isEmpty());// revisa que no este vacio
			
			assertEquals(response.size(), 1); // revisamos  la dimensiones de la lista que mayor igual 1
			
		}
		
		
		@Test
		public void retrieveBookTest() {
			final Integer id = 1 ;
			final Book book = new Book();
			Mockito.when(bookRepository.findById(id)).thenReturn(Optional.of(book));
			
			int idBusqueda = id;
			final ResponseEntity<Book> response = BookController.retrieveBook(idBusqueda); 
			assertNotNull(response);
			

			final ResponseEntity<Book> respuesta = new ResponseEntity<Book>(HttpStatus.ACCEPTED);
			assertEquals(respuesta.,response);
			
		}
		
		
		
		
		
}
