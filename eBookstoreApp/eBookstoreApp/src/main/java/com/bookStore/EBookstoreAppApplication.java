package com.bookStore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import com.bookStore.entity.Book;
import com.bookStore.repository.BookRepository;

@EnableDiscoveryClient
@SpringBootApplication
public class EBookstoreAppApplication implements CommandLineRunner{

	@Autowired
	@Qualifier("bookRepository")
	private BookRepository bookRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(EBookstoreAppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		bookRepository.save(new Book("Pursuit Of Happiness", "Oxford Publisher", "343424211", 222, 2007));
		bookRepository.save(new Book("AJDJSDS", "Oxford Publisher", "6546456464", 421, 2003));
		bookRepository.save(new Book("ASLDMF MF", "Oxford Publisher", "1232315", 189, 2015));
		bookRepository.save(new Book("LDLALDKDNF DMD", "Oxford Publisher", "89768686", 312, 2010));

	}

}
