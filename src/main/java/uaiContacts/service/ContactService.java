package uaiContacts.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import uaiContacts.model.Contact;
import uaiContacts.repository.ContactRepository;
import uaiContacts.vo.ContactListVO;

@Service
@Transactional
public class ContactService {

	@Autowired
	private ContactRepository contactRepository;

	@Transactional(readOnly = true)
	public ContactListVO findAll(int page, int maxResults) {
		Page<Contact> result = this.executeQueryFindAll(page, maxResults);

		if (this.shouldExecuteSameQueryInLastPage(page, result)) {
			int lastPage = result.getTotalPages() - 1;
			result = this.executeQueryFindAll(lastPage, maxResults);
		}

		return this.buildResult(result);
	}

	public void save(Contact contact) {
		this.contactRepository.save(contact);
	}

	@Secured("ROLE_ADMIN")
	public void delete(int contactId) {
		this.contactRepository.delete(contactId);
	}

	@Transactional(readOnly = true)
	public ContactListVO findByNameLike(int page, int maxResults, String name) {
		Page<Contact> result = this.executeQueryFindByName(page, maxResults,
				name);

		if (this.shouldExecuteSameQueryInLastPage(page, result)) {
			int lastPage = result.getTotalPages() - 1;
			result = this.executeQueryFindByName(lastPage, maxResults, name);
		}

		return this.buildResult(result);
	}

	private boolean shouldExecuteSameQueryInLastPage(int page,
			Page<Contact> result) {
		return this.isUserAfterOrOnLastPage(page, result)
				&& this.hasDataInDataBase(result);
	}

	private Page<Contact> executeQueryFindAll(int page, int maxResults) {
		final PageRequest pageRequest = new PageRequest(page, maxResults,
				this.sortByNameASC());

		return this.contactRepository.findAll(pageRequest);
	}

	private Sort sortByNameASC() {
		return new Sort(Sort.Direction.ASC, "name");
	}

	private ContactListVO buildResult(Page<Contact> result) {
		return new ContactListVO(result.getTotalPages(),
				result.getTotalElements(), result.getContent());
	}

	private Page<Contact> executeQueryFindByName(int page, int maxResults,
			String name) {
		final PageRequest pageRequest = new PageRequest(page, maxResults,
				this.sortByNameASC());

		return this.contactRepository.findByNameLike(pageRequest, "%" + name
				+ "%");
	}

	private boolean isUserAfterOrOnLastPage(int page, Page<Contact> result) {
		return page >= result.getTotalPages() - 1;
	}

	private boolean hasDataInDataBase(Page<Contact> result) {
		return result.getTotalElements() > 0;
	}
}