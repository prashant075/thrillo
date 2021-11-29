package com.semanticsquare.thrillo.entities;

import static org.junit.Assert.*;

import org.junit.Test;

import com.semanticsquare.thrillo.managers.BookmarkManager;

public class WebLinkTest {

	@Test
	public void testIsKidFriendlyEligible() {
		//Test 1 porn in url ---false
	WebLink webLink=	BookmarkManager.getInstance().createWebLink(2000, "Taming Tiger, Part 2",
				"http://www.javaworld.com/article/2072759/core-java/taming-porn--part-2.html",
				"http://www.javaworld.com");
	 boolean isKidFriendlyEligible=webLink.isKidFriendlyEligible();
	 assertFalse("Not for Child must return false", isKidFriendlyEligible);
		
		
		//Test 2 porn in title --false
	 
	 webLink=	BookmarkManager.getInstance().createWebLink(2000, "Taming porn, Part 2",
				"http://www.javaworld.com/article/2072759/core-java/taming-tiger--part-2.html",
				"http://www.javaworld.com");
	 isKidFriendlyEligible=webLink.isKidFriendlyEligible();
	 assertFalse("Not for Child title must return false", isKidFriendlyEligible);
		
		//Test 3 adult in host --- false
	 webLink=	BookmarkManager.getInstance().createWebLink(2000, "Taming tiger, Part 2",
				"http://www.javaworld.com/article/2072759/core-java/taming-tiger--part-2.html",
				"http://www.adult.com");
	 isKidFriendlyEligible=webLink.isKidFriendlyEligible();
	 assertFalse("Not for Child adult must return false", isKidFriendlyEligible);
		
		
		//Test 4 adult in url , not in the host --true
	 webLink=	BookmarkManager.getInstance().createWebLink(2000, "Taming tiger, Part 2",
				"http://www.javaworld.com/article/2072759/core-java/taming-adult--part-2.html",
				"http://www.javaworld.com");
	 isKidFriendlyEligible=webLink.isKidFriendlyEligible();
	 assertTrue("Not for Child adult in URL, but not in host must return true", isKidFriendlyEligible);
		
		//Test 5 adult in title only -- true
	 
	 webLink=	BookmarkManager.getInstance().createWebLink(2000, "Taming adult, Part 2",
				"http://www.javaworld.com/article/2072759/core-java/taming-tiger--part-2.html",
				"http://www.javaworld.com");
	 isKidFriendlyEligible=webLink.isKidFriendlyEligible();
	 assertTrue("Not for Child adult in Title, must return true", isKidFriendlyEligible);
	}

}
