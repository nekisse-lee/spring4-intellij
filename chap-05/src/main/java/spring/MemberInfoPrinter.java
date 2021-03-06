package spring;

import org.springframework.beans.factory.annotation.Autowired;

public class MemberInfoPrinter {

	private MemberDao memDao;
	private MemberPrinter printer;

	@Autowired
	public void setMemberDao(MemberDao memberDao) {
		System.out.println("MemberInfoPrinter 주입: " + memberDao);
		this.memDao = memberDao;
	}

	@Autowired
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
