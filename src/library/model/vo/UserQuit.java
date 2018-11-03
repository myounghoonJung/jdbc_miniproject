package library.model.vo;

import java.sql.Date;

public class UserQuit extends User {
	
	private Date quitDate; // 탈퇴 시간

	
	public UserQuit() {}
	
	public UserQuit(String userId, String userPw, String userName, String gender, int age, String phone,
			int borrowHistoryCount) {
		super(userId, userPw, userName, gender, age, phone, borrowHistoryCount);
	}

	public Date getQuitDate() {
		return quitDate;
	}
	public void setQuitDate(Date quitDate) {
		this.quitDate = quitDate;
	}

	@Override
	public String toString() {
		return super.toString() + "\t" + quitDate;
	}
	
	
	
}
