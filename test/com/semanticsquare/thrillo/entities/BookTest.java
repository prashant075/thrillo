package com.semanticsquare.thrillo.entities;

import static org.junit.Assert.*;

import org.junit.Test;

import com.semanticsquare.thrillo.constants.BookGenre;
import com.semanticsquare.thrillo.managers.BookmarkManager;

public class BookTest {

	@Test
	public void testIsKidFriendlyEligible() {
	Book book=	BookmarkManager.getInstance().createBook(4000,"Walden",1854,"Wilder Publications",new String[]{"Henry","David","Thoreau"},BookGenre.PHILOSOPHY,4.3);
	boolean isKidFriendlyEligible=book.isKidFriendlyEligible();
	assertFalse("Not for Child PHILOSOPHY Book", isKidFriendlyEligible);
	
	book = BookmarkManager.getInstance().createBook(4000,"Walden",1854,"Wilder Publications",new String[]{"Henry","David","Thoreau"},BookGenre.SELF_HELP,4.3);
	isKidFriendlyEligible=book.isKidFriendlyEligible();
	assertFalse("Not for Child Self help Book", isKidFriendlyEligible);
	}

}
