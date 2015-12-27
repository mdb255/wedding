package com.mdb255.wedding.domain.viewmodel;

public class GenericResponseViewModel {

	private boolean isSuccessful;
	private String errorMessage;
	
	public GenericResponseViewModel() {
	}
	
	public GenericResponseViewModel(boolean isSuccessful, String errorMessage) {
		this.isSuccessful = isSuccessful;
		this.errorMessage = errorMessage;
	}

	public boolean isSuccessful() {
		return isSuccessful;
	}

	public void setSuccessful(boolean isSuccessful) {
		this.isSuccessful = isSuccessful;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
}
