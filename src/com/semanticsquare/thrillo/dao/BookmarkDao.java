package com.semanticsquare.thrillo.dao;

import com.semanticsquare.thrillo.DataStore;
import com.semanticsquare.thrillo.entities.Bookmark;
import com.semanticsquare.thrillo.entities.UserBookmark;

public class BookmarkDao {
	public Bookmark[][] getBookmark(){
		return DataStore.getBookmarks();
	}

	public void saveUserBookmark(UserBookmark userbookmark) {
		DataStore.add(userbookmark);
		
	}

}
