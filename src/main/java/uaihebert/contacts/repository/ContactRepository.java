package uaihebert.contacts.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import uaihebert.contacts.model.Contact;

public interface ContactRepository extends
		PagingAndSortingRepository<Contact, Integer> {
	Page<Contact> findByNameLike(Pageable pageable, String name);
}