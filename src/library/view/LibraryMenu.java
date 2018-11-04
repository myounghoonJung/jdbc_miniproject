package library.view;

import java.util.List;
import java.util.Scanner;

import library.controller.LibraryController;
import library.model.vo.Book;
import library.model.vo.User;

public class LibraryMenu {
	
	private Scanner sc = new Scanner(System.in);

	public void mainMenu() {
		
		String menu = "----- 도서 관리 프로그램 -----\n"
					+ " 1. 도서 추가/삭제\n"
					+ " 2. 회원 추가/삭제/변경\n"
					+ " 3. 도서 대출/반납\n"
					+ " 4. 도서 조회\n"
					+ " 5. 회원 조회\n"
					+ " 9. 프로그램 종료\n"
					+ "  메뉴 선택 >  ";
		
		do {
			System.out.print(menu);
			
			int choice = sc.nextInt();
			
			switch (choice) {
			case 1:
				bookADMenu();
				break;
			case 2:
				userADMenu();
				break;
			case 3:
				bookBRMenu();
				break;
			case 4:
				inquiryBookMenu();
				break;
			case 5:
				inquiryUserMenu();
				break;
			case 9: 
				System.out.print("정말로 종료하시겠습니까? (y/n)  ");
				char answer = sc.next().toLowerCase().charAt(0);
				if (answer == 'y') return;
				else break;
			default: System.out.println("잘못 입력하셨습니다.");
			}
		} while (true);
		
		
		
	}

	private void userADMenu() {
		
		String menu = "--- 회원 추가/삭제/변경 ---\n"
				+ " 1. 회원 추가\n"
				+ " 2. 회원 삭제\n"
				+ " 3. 회원 정보 변경\n"
				+ " 9. 이전 메뉴\n"
				+ "  메뉴 선택 >  ";
	
		do {
			System.out.print(menu);

			int choice = sc.nextInt();

			switch (choice) {
			case 1:
				new LibraryController().insertUser(inputUser());
				break;
			case 2:
				new LibraryController().deleteUser(inputUserId());
				break;
			case 3:
				updateUserMenu(inputUserId());
			case 9:
				return;
			default:
				System.out.println("잘못 입력하셨습니다.");
			}

		} while (true);
		
		
	}

	private void updateUserMenu(String userId) {
		
		String menu = "--- 회원 정보 변경 ---\n"
				+ " 1. 패스워드\n"
				+ " 2. 전화번호\n"
				+ " 9. 이전 메뉴종료\n"
				+ "  메뉴 선택 >  ";
	
		do {
			System.out.print(menu);

			int choice = sc.nextInt();
			String colName;
			String updateData;

			switch (choice) {
			case 1:
				colName = "userpw";
				System.out.print("새로운 패스워드 : ");
				updateData = sc.next();
				new LibraryController().updateUser(colName, updateData, userId);
				break;
			case 2:
				colName = "phone";
				System.out.print("새로운 전화번호 : ");
				updateData = sc.next();
				new LibraryController().updateUser(colName, updateData, userId);
				break;
			case 9:
				return;
			default:
				System.out.println("잘못 입력하셨습니다.");
			}
		} while (true);
	
		
	}

	private void bookADMenu() {
		
		String menu = "--- 도서 추가/삭제 ---\n"
				+ " 1. 도서 추가\n"
				+ " 2. 도서 삭제\n"
				+ " 9. 이전 메뉴\n"
				+ "  메뉴 선택 >  ";
	
		do {
			System.out.print(menu);

			int choice = sc.nextInt();

			switch (choice) {
			case 1:
				new LibraryController().insertBook(inputBook());
				break;
			case 2:
				new LibraryController().deleteBook(inputBookNo());
				break;
			case 9:
				return;
			default:
				System.out.println("잘못 입력하셨습니다.");
			}

		} while (true);
		
	}

	private void inquiryUserMenu() {
		String menu = "--- 회원 조회 ---\n"
				+ " 1. 전체 회원\n"
				+ " 2. 대출 중인 도서 (회원 아이디 필요)\n"
				+ " 3. 대출 이력 (회원 아이디 필요)\n"
				+ " 4. 탈퇴한 회원\n"
				+ " 9. 이전 메뉴\n"
				+ "  메뉴 선택 >  ";
	
		do {
			System.out.print(menu);

			int choice = sc.nextInt();

			switch (choice) {
			case 1:
				new LibraryController().inquiryUserAll();
				break;
			case 2:
				new LibraryController().inquiryBookOnBorrow(inputUserId());
				break;
			case 3:
				new LibraryController().inquiryBorrowLog(inputUserId());
				break;
			case 4:
				new LibraryController().inquiryUserQuit();
			case 9:
				return;
			default:
				System.out.println("잘못 입력하셨습니다.");
			}

		} while (true);
		
	}

	private void inquiryBookMenu() {
		String menu = "--- 도서 조회 ---\n"
				+ " 1. 전체 도서\n"
				+ " 2. 대출 중인 도서\n"
				+ " 3. 삭제한 도서\n"
				+ " 9. 이전 메뉴\n"
				+ "  메뉴 선택 >  ";
	
		do {
			System.out.print(menu);

			int choice = sc.nextInt();

			switch (choice) {
			case 1:
				new LibraryController().inquiryBookAll();
				break;
			case 2:
				new LibraryController().inquiryBookOnBorrow();
				break;
			case 3:
				new LibraryController().inquiryBookDel();
				break;
			case 9:
				return;
			default:
				System.out.println("잘못 입력하셨습니다.");
			}

		} while (true);
		
	}

	private void bookBRMenu() {
		String menu = "--- 도서 대출/반납 ---\n"
					+ " 1. 대출\n"
					+ " 2. 반납\n"
					+ " 9. 이전 메뉴\n"
					+ "  메뉴 선택 >  ";
		
		do {
			System.out.print(menu);
			
			int choice = sc.nextInt();
			
			switch (choice) {
			case 1:
				new LibraryController().borrowBook(inputUserId(), inputBookNo());
				break;
			case 2:
				new LibraryController().returnBook(inputBookNo());
				break;
			case 9:
				return;
			default: System.out.println("잘못 입력하셨습니다.");
			}
			
			
		} while (true);
	}

	private String inputUserId() {
		System.out.print("회원 아이디 : ");
		return sc.next();
	}

	private String inputBookNo() {
		System.out.print("도서번호 : ");
		sc.nextLine();
		return sc.nextLine();
	}

	private User inputUser() {
		
		System.out.print("아이디 : ");
		String userId = sc.next();
		System.out.print("패스워드 : ");
		String userPw = sc.next();
		System.out.print("이름 : ");
		String userName = sc.next();
		System.out.print("성별 ('M','F'): ");
		String gender = sc.next().toUpperCase().charAt(0)+"";
		System.out.print("나이 : ");
		int age = sc.nextInt();
		System.out.print("전화번호 (- 포함하여) : ");
		String phone = sc.next();
		
		return new User(userId, userPw, userName, gender, age, phone);
	}

	private Book inputBook() {
		
		System.out.print("도서번호 : ");
		String bookNo = sc.next();
		System.out.print("도서명 : ");
		sc.nextLine();
		String bookTitle = sc.nextLine();
		System.out.print("저자 : ");
		String author = sc.next();
		System.out.print("출판사 : ");
		String publisher = sc.next();
		System.out.print("장르 : ");
		String genre = sc.next();
		
		return new Book(bookNo, bookTitle, author, publisher, genre);
	}

	public void displaySuccess(String message) {
		System.out.println("성공 : " + message);
	}

	public void displayError(String message) {
		System.out.println("에러 : " + message);
	}

	public void displayBookList(List<Book> list) {
		System.out.println("==================================================================================================================================\n"
						 + "bookNo\tbookTitle\tauthor\tpublisher\tgenre\tborrowdate\treturndate\tstatus\tborrowUserId\n"
						 + "==================================================================================================================================");
		
		for (Book b : list) {
			System.out.println(b);
		}
	}
	
	public void displayBookDelList(List<Book> list) {
		System.out.println("==================================================================================================================================\n"
						 + "bookNo\tbookTitle\tauthor\tpublisher\tgenre\tdelDate\n"
						 + "==================================================================================================================================");
		
		for (Book b : list) {
			System.out.println(b);
		}
	}
	
	public void displayBorrowLogList(List<Book> list) {
		System.out.println("==================================================================================================================================\n"
						 + "logNo\tlogDate\tbookNo\tbookTitle\tauthor\tpublisher\tgenre\tborrowdate\treturndate\tstatus\tborrowUserId\n"
						 + "==================================================================================================================================");
		
		for (Book b : list) {
			System.out.println(b);
		}
	}

	public void displayNoData() {
		System.out.println("데이터가 없습니다.");
	}

	public void displayUserList(List<User> list) {
		System.out.println("==================================================================================================================================\n"
						 + "userId\tuserPw\tuserName\tgender\tage\tphone\tborrowPresentCount\tborrowHistoryCount\tenrollDate\n"
						 + "==================================================================================================================================");

		for (User u : list) {
			System.out.println(u);
		}

	}
	
	public void displayUserQuitList(List<User> list) {
		System.out.println("==================================================================================================================================\n"
						 + "userId\tuserPw\tuserName\tgender\tage\tphone\tborrowHistoryCount\tenrollDate\tquitDate\n"
						 + "==================================================================================================================================");
		
		for (User u : list) {
			System.out.println(u);
		}
		
	}

}