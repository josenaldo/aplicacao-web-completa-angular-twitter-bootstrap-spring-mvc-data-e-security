package uaiContacts.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Contact {

	@Id
	@GeneratedValue
	private int id;
	private String name;
	private String phoneNumber;
	private String email;

	public Contact() {

	}

	public Contact(String name, String phoneNumber, String email, int id) {
		super();
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public boolean equals(Object object) {
		if (object instanceof Contact) {
			Contact contact = (Contact) object;
			return contact.id == this.id;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return this.id;
	}
}
