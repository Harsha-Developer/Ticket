package com.agilecrm.model;

public class Coustomer 
{
private int id;
private String name;
private String email;
private long mobNum;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public long getMobNum() {
	return mobNum;
}
public void setMobNum(long mobNum) {
	this.mobNum = mobNum;
}
@Override
public String toString() {
	return "Coustomer [id=" + id + ", name=" + name + ", email=" + email + ", mobNum=" + mobNum + "]";
}

}
