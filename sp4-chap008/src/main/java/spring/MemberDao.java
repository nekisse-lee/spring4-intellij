package spring;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

public class MemberDao {

	/*		MemberRowMapper 객체 생성      임의클래스 사용 안할시
	List<Member> results = jdbcTemplate.query(
			"select * from MEMBER where EMAIL =? and NAME=?",
			new MemberRowMapper(),
			email, name);
			*/


	private JdbcTemplate jdbcTemplate;

	public MemberDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}


	/*		설정 메서드 방식
	public setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}		*/

	public Member selectByEmail(String email) {
		/*
		List<Member> results = jdbcTemplate.query(
				"select * from MEMBER where EMAIL = ?",
				new RowMapper<Member>() {
					@Override
					public Member mapRow(ResultSet rs, int rowNum)
							throws SQLException {
						Member member = new Member(rs.getString("EMAIL"),
								rs.getString("PASSWORD"),
								rs.getString("NAME"),
								rs.getTimestamp("REGDATE"));
						member.setId(rs.getLong("ID"));
						return member;
					}
				},
				email);

		return results.isEmpty() ? null : results.get(0);
		*/

		//   중복코드 를 제거하기 위해 MemberRowMapper 클래스를 정의하고 사용
		List<Member> results = jdbcTemplate.query(
				"select * from MEMBER where EMAIL = ?",
				new MemberRowMapper(),
				email
		);
		return results.isEmpty() ? null : results.get(0);
	}

	public void insert(Member member) {
		//TODO 구현해야 함
	}

	public void update(Member member) {
		//TODO 구현해야 함
	}

	public Collection<Member> selectAll() {
		/*List<Member> results= jdbcTemplate.query("select * from Member",
				new RowMapper<Member>() {
					@Override
					public Member mapRow(ResultSet rs, int rowNum)
							throws SQLException {
						Member member = new Member(rs.getString("EMAIL"),
								rs.getString("PASSWORD"),
								rs.getString("NAME"),
								rs.getTimestamp("REGDATE"));
						member.setId(rs.getLong("ID"));
						return member;

					}
				});
		return results;*/


		//   중복코드 를 제거하기 위해 MemberRowMapper 클래스를 정의하고 사용
		List<Member> results = jdbcTemplate.query("select * from Member",
				new MemberRowMapper());
		return results;
	}

}
