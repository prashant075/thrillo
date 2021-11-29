package com.semanticsquare.thrillo;

import com.semanticsquare.thrillo.entities.Bookmark;
import com.semanticsquare.thrillo.entities.User;
import com.semanticsquare.thrillo.managers.BookmarkManager;
import com.semanticsquare.thrillo.managers.UserManager;

public class Launch {
	private static User[] users;
	private static Bookmark[][] bookmarks;

	private static void loadData() {
		// TODO Auto-generated method stub
		System.out.println("1. Loading Data ...");
		DataStore.loadData();

		users = UserManager.getInstance().getUsers();
		bookmarks = BookmarkManager.getInstance().getBookmarks();

		//System.out.println("Printing User Data ...");
		//printUserData();
		//printBookmarkData();
	}

	private static void printUserData() {
		for (User user : users) {
			System.out.println(user);
		}

	}

	private static void printBookmarkData() {
		for (Bookmark[] bookmarklist : bookmarks) {
			for (Bookmark bookmark : bookmarklist) {
				System.out.println(bookmark);
			}
		}
	}
	private static void start() {
		//System.out.println("\n2. Bookmarking ..");
		for(User user: users){
			View.browse(user, bookmarks);
		}
		
	}
	public static void main(String[] args) {
		loadData();
		start();

	}

	

}
