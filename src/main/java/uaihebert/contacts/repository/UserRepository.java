package uaihebert.contacts.repository;

import org.springframework.data.repository.CrudRepository;

import uaihebert.contacts.model.User;

public interface UserRepository extends CrudRepository<User, Integer> {
	User findByEmail(String email);
}
