package com.chuchi;


import javax.persistence.*;

@Entity
@Table(name = "person")
public class Person {



@Id
@GeneratedValue
private long id;

@Column()
private String userName;


@Column(nullable = false)
private String password;

public Person(String userName, String password) {
	this.userName = userName;
	this.password = password;
	
}

public long getId() {
	return id;
}

public String getUserName() {
	return userName;
}

public void setUserName(String userName) {
	this.userName = userName;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

// setters and getters

}