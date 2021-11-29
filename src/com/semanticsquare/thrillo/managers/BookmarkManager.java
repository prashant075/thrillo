package com.semanticsquare.thrillo.managers;

import com.semanticsquare.thrillo.dao.BookmarkDao;
import com.semanticsquare.thrillo.entities.Book;
import com.semanticsquare.thrillo.entities.Bookmark;
import com.semanticsquare.thrillo.entities.Movie;
import com.semanticsquare.thrillo.entities.User;
import com.semanticsquare.thrillo.entities.UserBookmark;
import com.semanticsquare.thrillo.entities.WebLink;

public class BookmarkManager {
	private static BookmarkManager bookmarkmanager = new BookmarkManager();
	private static BookmarkDao dao = new BookmarkDao();

	private BookmarkManager() {
	}

	public static BookmarkManager getInstance() {
		return bookmarkmanager;
	}

	public Movie createMoive(long id, String title, String profileUrl, int releaseYear, String[] cast,
			String[] directors, String genre, double imdbRating) {
		Movie movie = new Movie();
		movie.setCast(cast);
		movie.setDirectors(directors);
		movie.setGenre(genre);
		movie.setId(id);
		movie.setImdbRating(imdbRating);
		movie.setProfileUrl(profileUrl);
		movie.setReleaseYear(releaseYear);
		movie.setTitle(title);

		return movie;

	}

	public Book createBook(long id, String title, int publicationYear, String publisher, String[] authors, String genre,
			double amazonRating) {
		Book book = new Book();
		book.setAuthors(authors);
		book.setGenre(genre);
		book.setPublicationYear(publicationYear);
		book.setId(id);
		book.setTitle(title);
		book.setPublisher(publisher);
		book.setAmazonRating(amazonRating);

		return book;

	}

	public WebLink createWebLink(long id, String title, String url, String host) {
		WebLink weblink = new WebLink();
		weblink.setHost(host);
		weblink.setId(id);
		weblink.setTitle(title);
		weblink.setUrl(url);

		return weblink;

	}

	public Bookmark[][] getBookmarks() {
		return dao.getBookmark();
	}

	public void saveUserBookmark(User user, Bookmark bookmark) {
		UserBookmark userbookmark = new UserBookmark();
		userbookmark.setUser(user);
		userbookmark.setBookmark(bookmark);

		dao.saveUserBookmark(userbookmark);

	}

	public void setKidFriendlyStatus(User user, String kidFriendlyStatus, Bookmark bookmark) {
		bookmark.setKidFriendlyStatus(kidFriendlyStatus);
		bookmark.setKidFriendlyMarkedBy(user);
		System.out.println(
				"Kid friendly status: " + kidFriendlyStatus + ", " + "Marked by:" + user.getEmail() + ", " + bookmark);

	}

	public void share(User user, Bookmark bookmark) {
		bookmark.setSharedby(user);
		System.out.println("Data to be Shared: ");

		if (bookmark instanceof Book) {
			System.out.println(((Book) bookmark).getItemData());
		} else if (bookmark instanceof WebLink) {
			System.out.println(((WebLink) bookmark).getItemData());
		}

	}

}
