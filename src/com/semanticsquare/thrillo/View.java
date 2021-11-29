package com.semanticsquare.thrillo;

import com.semanticsquare.thrillo.constants.KidFriendlyStatus;
import com.semanticsquare.thrillo.constants.UserType;
import com.semanticsquare.thrillo.controllers.BookmarkController;
import com.semanticsquare.thrillo.entities.Bookmark;
import com.semanticsquare.thrillo.entities.User;
import com.semanticsquare.thrillo.managers.BookmarkManager;
import com.semanticsquare.thrillo.partner.Shareable;

public class View {

	/*
	 * public static void bookmark(User user, Bookmark[][] bookmarks) {
	 * 
	 * System.out.println("\n" + user.getEmail() + " is Bookmarking");
	 * 
	 * for (int i = 0; i < DataStore.USER_BOOKMARK_LIMIT; i++) { int typeOffset
	 * = (int) (Math.random() * DataStore.BOOKMARK_TYPES_COUNT); int
	 * bookmarkOffset = (int) (Math.random() *
	 * DataStore.BOOKMARK_COUNT_PER_TYPE);
	 * 
	 * Bookmark bookmark = bookmarks[typeOffset][bookmarkOffset];
	 * 
	 * BookmarkController.getInstance().saveUserBookmark(user, bookmark);
	 * 
	 * System.out.println(bookmark); } }
	 */

	public static void browse(User user, Bookmark[][] bookmarks) {

		System.out.println("\n" + user.getEmail() + " is browsing items ...");
		int bookmarkCount = 0;

		for (Bookmark[] bookmarklist : bookmarks) {
			for (Bookmark bookmark : bookmarklist) {
				if (bookmarkCount < DataStore.USER_BOOKMARK_LIMIT) {
					boolean isBookmark = getBookmarkDecision(bookmark);
					if (isBookmark) {
						bookmarkCount++;

						BookmarkController.getInstance().saveUserBookmark(user, bookmark);

						System.out.println("New Item Bookmarked --" + bookmark);
					}
				}

				

				if (user.getUserType().equals(UserType.EDITOR) || user.getUserType().equals(UserType.CHIEF_EDITOR)) {
					
					// Mark as kid - friendly
					if (bookmark.isKidFriendlyEligible()
							&& bookmark.getKidFriendlyStatus().equals(KidFriendlyStatus.UNKNOWN)) {
						String kidFriendlyStatus =getKidFriendlyStatusDecision(bookmark);
						if(!kidFriendlyStatus.equals(KidFriendlyStatus.UNKNOWN)){
							BookmarkController.getInstance().setKidFriendlyStatus(user,kidFriendlyStatus,bookmark);
						}
					}
					
					//Sharing !!
					
					if(bookmark.getKidFriendlyStatus().equals(KidFriendlyStatus.APPROVED)
							&& bookmark instanceof Shareable){
					boolean eShared=getShareDecision();
					if(eShared){
						BookmarkController.getInstance().Share(user, bookmark);
					}
						
					}
				}
			}
		}

	}
	//TODO: We User Input in I/O Chapter
	private static boolean getShareDecision() {
		return Math.random() < 0.5 ? true : false;
		
	}

	private static String getKidFriendlyStatusDecision(Bookmark bookmark) {
		return Math.random() < 0.4 ? KidFriendlyStatus.APPROVED
				: (Math.random() >= 0.4 && Math.random() < 0.8) ? KidFriendlyStatus.REJECTED
						: KidFriendlyStatus.UNKNOWN;

	}

	private static boolean getBookmarkDecision(Bookmark bookmark) {
		return Math.random() < 0.5 ? true : false;

	}
}
