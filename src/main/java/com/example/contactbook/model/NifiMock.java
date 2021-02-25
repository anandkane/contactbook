package com.example.contactbook.model;

public class NifiMock {
	private int id;
	private String applicationId;
	private String desiredProgram;
	private String firstName;
	private String lastName;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(String applicationId) {
		this.applicationId = applicationId;
	}

	public String getDesiredProgram() {
		return desiredProgram;
	}

	public void setDesiredProgram(String desiredProgram) {
		this.desiredProgram = desiredProgram;
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

	@Override
	public String toString() {
		return "NifiMock{" +
				"applicationId='" + applicationId + '\'' +
				", desiredProgram='" + desiredProgram + '\'' +
				", firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				'}';
	}
}
