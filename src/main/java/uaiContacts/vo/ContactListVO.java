package uaiContacts.vo;

import java.util.List;

import uaiContacts.model.Contact;

public class ContactListVO {
	private int pagesCount;
	private long totalContacts;

	private String actionMessage;
	private String searchMessage;

	private List<Contact> contacts;

	public ContactListVO() {
	}

	public ContactListVO(int pages, long totalContacts, List<Contact> contacts) {
		this.pagesCount = pages;
		this.contacts = contacts;
		this.totalContacts = totalContacts;
	}

	public int getPagesCount() {
		return this.pagesCount;
	}

	public void setPagesCount(int pagesCount) {
		this.pagesCount = pagesCount;
	}

	public List<Contact> getContacts() {
		return this.contacts;
	}

	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}

	public long getTotalContacts() {
		return this.totalContacts;
	}

	public void setTotalContacts(long totalContacts) {
		this.totalContacts = totalContacts;
	}

	public String getActionMessage() {
		return this.actionMessage;
	}

	public void setActionMessage(String actionMessage) {
		this.actionMessage = actionMessage;
	}

	public String getSearchMessage() {
		return this.searchMessage;
	}

	public void setSearchMessage(String searchMessage) {
		this.searchMessage = searchMessage;
	}
}