package library.controller;

import java.util.List;

import library.model.exception.LibraryException;
import library.model.service.LibraryService;
import library.model.vo.Book;
import library.model.vo.BookDel;
import library.model.vo.User;
import library.view.LibraryMenu;

public class LibraryController {

	public void insertBook(Book book) {
		
		try {
			int result = new LibraryService().insertBook(book);
			
			if (result > 0) {
				new LibraryMenu().displaySuccess("도서 추가 완료!");
			}
			else {
				new LibraryMenu().displayError("도서 추가 실패!");
			}
			
		} catch (LibraryException e) {
			e.printStackTrace();
		}
		
	}
	
	public void deleteBook(String bookNo) {

		try {
			int result = new LibraryService().deleteBook(bookNo);
			
			if (result > 0) {
				new LibraryMenu().displaySuccess("도서 삭제 완료!");
			}
			else {
				new LibraryMenu().displayError("도서 삭제 실패!");
			}
			
		} catch (LibraryException e) {
			e.printStackTrace();
		}
		
	}

	public void insertUser(User user) {

		try {
			int result = new LibraryService().insertUser(user);
			
			if (result > 0) {
				new LibraryMenu().displaySuccess("회원 추가 완료!");
			}
			else {
				new LibraryMenu().displayError("회원 추가 실패!");
			}
			
		} catch (LibraryException e) {
			e.printStackTrace();
		}
		
	}
	
	public void deleteUser(String userId) {
		
		try {
			int result = new LibraryService().deleteUser(userId);
			
			if (result > 0) {
				new LibraryMenu().displaySuccess("회원 삭제 완료!");
			}
			else {
				new LibraryMenu().displayError("회원 삭제 실패!");
			}
			
		} catch (LibraryException e) {
			e.printStackTrace();
		}
		
		
	}
	

	public void borrowBook(String userId, String bookNo) {

		try {
			int result = new LibraryService().borrowBook(userId, bookNo);
			
			if (result > 0) {
				new LibraryMenu().displaySuccess("도서 대출 완료!");
			}
			else {
				new LibraryMenu().displayError("도서 대출 실패!");
			}
			
		} catch (LibraryException e) {
			e.printStackTrace();
		}
		
	}

	public void returnBook(String bookNo) {

		try {
			int result = new LibraryService().returnBook(bookNo);
			
			if (result > 0) {
				new LibraryMenu().displaySuccess("도서 반납 완료!");
			}
			else {
				new LibraryMenu().displayError("도서 반납 실패!");
			}
			
		} catch (LibraryException e) {
			e.printStackTrace();
		}
		
		
	}

	public void inquiryBookAll() {
		
		List<Book> list;
		
		try {
			list = new LibraryService().inquiryBookAll();
			
			if (!list.isEmpty()) {
				new LibraryMenu().displayBookList(list);
			}
			else {
				new LibraryMenu().displayNoData();
			}
		} catch (LibraryException e) {
			e.printStackTrace();
		}
		
	}

	public void inquiryBookOnBorrow() {
		
		List<Book> list;
		
		try {
			list = new LibraryService().inquiryBookOnBorrow();
			
			if (!list.isEmpty()) {
				new LibraryMenu().displayBookList(list);
			}
			else {
				new LibraryMenu().displayNoData();
			}
		} catch (LibraryException e) {
			e.printStackTrace();
		}
		
		
	}

	public void inquiryBookDel() {

		List<Book> list;
		
		try {
			list = new LibraryService().inquiryBookDel();
			
			if (!list.isEmpty()) {
				new LibraryMenu().displayBookDelList(list);
			}
			else {
				new LibraryMenu().displayNoData();
			}
		} catch (LibraryException e) {
			e.printStackTrace();
		}
		
	}

	public void updateUser(String colName, String updateData, String userId) {
		try {
			int result = new LibraryService().updateUser(colName, updateData, userId);
			
			if (result > 0) {
				new LibraryMenu().displaySuccess("회원 정보 변경 완료!");
			}
			else {
				new LibraryMenu().displayError("회원 정보 변경 실패!");
			}
			
		} catch (LibraryException e) {
			e.printStackTrace();
		}
	}

	public void inquiryUserAll() {
		List<User> list;
		
		try {
			list = new LibraryService().inquiryUserAll();
			
			if (!list.isEmpty()) {
				new LibraryMenu().displayUserList(list);
			}
			else {
				new LibraryMenu().displayNoData();
			}
		} catch (LibraryException e) {
			e.printStackTrace();
		}
		
	}

	public void inquiryBookOnBorrow(String userId) {
		List<Book> list;
		
		try {
			list = new LibraryService().inquiryBookOnBorrow(userId);
			
			if (!list.isEmpty()) {
				new LibraryMenu().displayBookList(list);
			}
			else {
				new LibraryMenu().displayNoData();
			}
		} catch (LibraryException e) {
			e.printStackTrace();
		}
		
	}

	public void inquiryBorrowLog(String userId) {
		List<Book> list;
		
		try {
			list = new LibraryService().inquiryBorrowLog(userId);
			
			if (!list.isEmpty()) {
				new LibraryMenu().displayBookList(list);
			}
			else {
				new LibraryMenu().displayNoData();
			}
		} catch (LibraryException e) {
			e.printStackTrace();
		}
		
	}

	public void inquiryUserQuit() {
		List<User> list;
		
		try {
			list = new LibraryService().inquiryUserQuit();
			
			if (!list.isEmpty()) {
				new LibraryMenu().displayUserQuitList(list);
			}
			else {
				new LibraryMenu().displayNoData();
			}
		} catch (LibraryException e) {
			e.printStackTrace();
		}
		
	}


	

	

}
