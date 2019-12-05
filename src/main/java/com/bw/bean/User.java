package com.bw.bean;

public class User {
 private Integer uid;
 private String phone;
 private String email;
 private String nickname;
 private Integer age;
public User() {
	super();
	// TODO Auto-generated constructor stub
}
public User(Integer uid, String phone, String email, String nickname, Integer age) {
	super();
	this.uid = uid;
	this.phone = phone;
	this.email = email;
	this.nickname = nickname;
	this.age = age;
}
public Integer getUid() {
	return uid;
}
public void setUid(Integer uid) {
	this.uid = uid;
}
public String getPhone() {
	return phone;
}
public void setPhone(String phone) {
	this.phone = phone;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getNickname() {
	return nickname;
}
public void setNickname(String nickname) {
	this.nickname = nickname;
}
public Integer getAge() {
	return age;
}
public void setAge(Integer age) {
	this.age = age;
}
@Override
public String toString() {
	return "User [uid=" + uid + ", phone=" + phone + ", email=" + email + ", nickname=" + nickname + ", age=" + age
			+ "]";
}
 
}
