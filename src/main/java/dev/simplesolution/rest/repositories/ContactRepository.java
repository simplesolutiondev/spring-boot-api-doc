package dev.simplesolution.rest.repositories;

import java.util.List;

import dev.simplesolution.rest.entities.Contact;

public interface ContactRepository {
	List<Contact> getAll();
	Contact getById(Long id);
	Contact save(Contact newContact);
	Contact update(Contact newContact);
	void delete(Long id);
}