package com.semanticsquare.thrillo.dao;

import com.semanticsquare.thrillo.DataStore;
import com.semanticsquare.thrillo.entities.User;

public class UserDao {
	public User[] getUser(){
		return DataStore.getUsers();
	}
}
