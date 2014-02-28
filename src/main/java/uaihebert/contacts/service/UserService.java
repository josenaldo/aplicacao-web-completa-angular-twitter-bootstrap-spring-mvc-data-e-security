package uaihebert.contacts.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uaihebert.contacts.model.User;
import uaihebert.contacts.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public User findByEmail(String email) {
		return this.userRepository.findByEmail(email);
	}
}
