package com.example.contactbook.model;

public class Contact {
	private int id;
	private String firstName;
	private String lastName;
	private String company;

	public Contact() {
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	@Override
	public String toString() {
		return new StringBuilder().append("Contact{").append("id='").append(id).append('\'').append(", firstName='")
								  .append(firstName).append('\'').append(", lastName='").append(lastName).append('\'')
								  .append(", company='").append(company).append('\'').append('}').toString();
	}
}
