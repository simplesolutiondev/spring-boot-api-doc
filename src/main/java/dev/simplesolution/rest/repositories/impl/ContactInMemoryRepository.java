package dev.simplesolution.rest.repositories.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import dev.simplesolution.rest.entities.Contact;
import dev.simplesolution.rest.repositories.ContactRepository;

@Service
public class ContactInMemoryRepository implements ContactRepository {
	
	private static List<Contact> contacts = new ArrayList<>();
	
	public ContactInMemoryRepository() {
		// initialize test data
		contacts.add(new Contact(1L, "John", "Doe", "john@simplesolution.dev", "123-456-789", "address 123, street 1, city 1"));
		contacts.add(new Contact(2L, "Emerson", "Wilks", "emerson@simplesolution.dev", "123-456-788", "address 456, street 2, city 1"));
		contacts.add(new Contact(3L, "Wade", "Savage", "wade@simplesolution.dev", "123-456-787", "address 789, street 3, city 1"));
		contacts.add(new Contact(4L, "Star", "Lott", "star@simplesolution.dev", "123-456-786", "address 234, street 4, city 1"));
		contacts.add(new Contact(5L, "Claudia", "James", "claudia@simplesolution.dev", "123-456-785", "address 678, street 5, city 1"));
	}

	@Override
	public List<Contact> getAll() {
		return contacts;
	}

	@Override
	public Contact getById(Long id) {
		Contact result = contacts.stream()
				.filter(contact -> contact.getId().equals(id))
				.findAny()
				.orElse(null);
		return result;
	}

	@Override
	public Contact save(Contact newContact) {
		contacts.add(newContact);
		return newContact;
	}

	@Override
	public Contact update(Contact newContact) {
		Contact currentContact = contacts.stream()
				.filter(contact -> contact.getId().equals(newContact.getId()))
				.findAny()
				.orElse(null);
		currentContact.setFirstName(newContact.getFirstName());
		currentContact.setLastName(newContact.getLastName());
		currentContact.setEmail(newContact.getEmail());
		currentContact.setPhone(newContact.getPhone());
		currentContact.setAddress(newContact.getAddress());
		return currentContact; 
	}

	@Override
	public void delete(Long id) {
		Contact currentContact = contacts.stream()
				.filter(contact -> contact.getId().equals(id))
				.findAny()
				.orElse(null);
		contacts.remove(currentContact);
	}
}