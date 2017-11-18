package spring;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


//      MemberDao의   임의 클래스 이용한 코딩 방식을 원치 않을경우   RowMapper를 구현한 클래스 작성


public class MemberRowMapper implements RowMapper<Member> {
    @Override
    public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
        Member member = new Member(rs.getString("EMAIL"),
                rs.getString("PASSWORD"),
                rs.getString("NAME"),
                rs.getTimestamp("REGDATE"));
        member.setId(rs.getLong("ID"));
        return member;
    }
}

