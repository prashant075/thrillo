package com.semanticsquare.thrillo.entities;

import static org.junit.Assert.*;

import org.junit.Test;

import com.semanticsquare.thrillo.constants.MovieGenre;
import com.semanticsquare.thrillo.managers.BookmarkManager;

public class MovieTest {

	@Test
	public void testIsKidFriendlyEligible() {
		Movie movie =BookmarkManager.getInstance().createMoive(3000,"Citizen Kane"," ",1941,new String[]{"Orson Welles","Joseph Cotten"},new String[]{"Orson Welles"},MovieGenre.HORROR,8.5);
		boolean isKidFriendlyEligible=movie.isKidFriendlyEligible();
		assertFalse("Not for Child Horror Movie", isKidFriendlyEligible);
		
		 movie =BookmarkManager.getInstance().createMoive(3000,"Citizen Kane"," ",1941,new String[]{"Orson Welles","Joseph Cotten"},new String[]{"Orson Welles"},MovieGenre.THRILLERS,8.5);
		 isKidFriendlyEligible=movie.isKidFriendlyEligible();
		assertFalse("Not for Child Thrill Movie", isKidFriendlyEligible);
	
	}

}
