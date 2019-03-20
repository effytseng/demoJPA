package com.example.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the school_account database table.
 * 
 */
@Entity
@Table(name="school_account")
@NamedQuery(name="SchoolAccount.findAll", query="SELECT s FROM SchoolAccount s")
public class SchoolAccount implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String name;

	private String password;

	private String uid;

	public SchoolAccount() {
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

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUid() {
		return this.uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

}