package com.dhruba.java.datastructures.tree;

public class ContactmanagerTreeTest {
	
	BasicBinaryTree<Contact> contacts = new BasicBinaryTree<Contact>();
	
	public static void main(String[] args) {
		ContactmanagerTreeTest app = new ContactmanagerTreeTest();
		
		app.loadContacts();
		
		app.searchContacts();
		
		app.cleanupContacts();
	}
	
	private void cleanupContacts() {
		// we do not need to populate phone number since we check just last name
		contacts.delete(new Contact("Dhruba", "Nag", null));//having one to right
		System.out.println("Size after deleting = " + contacts.size());
		contacts.delete(new Contact("Dayita", "Das", null));//having one to left
		System.out.println("Size after deleting = " + contacts.size());
		contacts.delete(new Contact("Tam", "Lieber", null));//having both children to left and right
		System.out.println("Size after deleting = " + contacts.size());
		contacts.delete(new Contact("Abe", "Lincoln", null));//root
		System.out.println("Size after deletion = " + contacts.size());
		
	}

	private void searchContacts() {
		// we do not need to populate phone number since we check just last name
		System.out.println("Is Dhruba Nag in Binary Tree ? " + contacts.contains(new Contact("Dhruba", "Nag", null)));
		System.out.println("Is Dayita Das in Binary Tree ? " + contacts.contains(new Contact("Dayita", "Das", null)));
		
	}

	private void loadContacts() {
		contacts.add(new Contact("Abe", "Lincoln", "123-555-5555"));
		contacts.add(new Contact("Dhruba", "Nag", "342-897-8097"));
		contacts.add(new Contact("Tam", "Lieber", "445-900-6789"));
		contacts.add(new Contact("Dayita", "Das", "445-986-6789"));
		contacts.add(new Contact("Jason", "Statham", "421-986-6789"));
		contacts.add(new Contact("Jan", "Hos", "421-986-6765"));
		contacts.add(new Contact("Roy", "Fox", "891-986-6789"));
		System.out.println("Size after loading = " + contacts.size());
	}
	
	private class Contact implements Comparable<Contact> {

		private String firstName;
		private String lastName;
		private String phoneNumber;

		public Contact(String firstName, String lastName, String phoneNumber) {
			this.firstName = firstName;
			this.lastName = lastName;
			this.phoneNumber = phoneNumber;
		}

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public String getPhoneNumber() {
			return phoneNumber;
		}

		public void setPhoneNumber(String phoneNumber) {
			this.phoneNumber = phoneNumber;
		}

		@Override
		public int compareTo(Contact other) {
			return this.lastName.compareTo(other.lastName);
		}

		@Override
		public String toString() {
			return "Contact [firstName=" + firstName + ", lastName=" + lastName + ", phoneNumber=" + phoneNumber + "]";
		}

	}
}
