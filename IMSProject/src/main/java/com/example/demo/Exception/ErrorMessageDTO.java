package com.example.demo.Exception;

public class ErrorMessageDTO {
private String message;
private int status;
public ErrorMessageDTO() {
	
}
public ErrorMessageDTO(String message,int status) {
	this.message=message;
	this.status=status;
}
public void setMessage(String message)
{
	this.message=message;
}
public String getMessage() {
	return message;
}
public void setStatus(int status) {
	this.status=status;
}
public int getsetStatus()
{
	return status;
}
}
