package dev.simplesolution.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import dev.simplesolution.rest.entities.Contact;
import dev.simplesolution.rest.repositories.ContactRepository;

@RestController
public class ContactController {
	
	@Autowired
	private ContactRepository contactRepository;
	
	@GetMapping("/contacts")
	public List<Contact> getAll() {
		return contactRepository.getAll();
	}

	@GetMapping("/contacts/{id}")
	public Contact getContactById(@PathVariable Long id) {
		return contactRepository.getById(id);
	}
	
	@PostMapping("/contacts")
	public Contact createNewContact(@RequestBody Contact newContact) {
		return contactRepository.save(newContact);
	}
	
	@PutMapping("/contacts/{id}")
	public Contact updateContact(@RequestBody Contact newContact, @PathVariable Long id) {
		newContact.setId(id);
		return contactRepository.update(newContact);
	}
	
	@DeleteMapping("/contacts/{id}")
	public void deleteContact(@PathVariable Long id) {
		contactRepository.delete(id);
	}
}