package library.model.vo;

import java.sql.Date;

public class BookDel extends Book {
	
	private Date delDate; // 삭제 시간

	public BookDel() {}
	
	public BookDel(String bookNo, String bookTitle, String author, String publisher, String genre) {
		super(bookNo, bookTitle, author, publisher, genre);
	}

	public Date getDelDate() {
		return delDate;
	}

	public void setDelDate(Date delDate) {
		this.delDate = delDate;
	}

	@Override
	public String toString() {
		return super.toString() + "\t" + delDate;
	}
	
	
	
	
	
	
}
