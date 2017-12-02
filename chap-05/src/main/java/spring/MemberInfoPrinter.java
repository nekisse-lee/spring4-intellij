package spring;

import org.springframework.beans.factory.annotation.Autowired;

public class MemberInfoPrinter {

	private MemberDao memDao;
	private MemberPrinter printer;

	public void setMemberDao(MemberDao memberDao) {
		this.memDao = memberDao;
	}

	public void setPrinter(MemberPrinter printer) {
		System.out.println("setPrinter: " + printer);
		this.printer = printer;
	}

	public void printMemberInfo(String email) {
		Member member = memDao.selectByEmail(email);
		if (member == null) {
			System.out.println("데이터 없음\n");
			return;
		}
		printer.print(member);
		System.out.println();
	}
}
