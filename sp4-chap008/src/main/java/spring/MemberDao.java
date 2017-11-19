package spring;

import com.sun.tools.corba.se.idl.constExpr.Times;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.*;
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

	public void update(final Member member) {
		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement pstmt = con.prepareStatement(
						"insert into MEMBER (EMAIL, PASSWORD, NAME, REGDATE) values (?,?,?,?)");
				pstmt.setString(1, member.getEmail());
				pstmt.setString(2, member.getPassword());
				pstmt.setString(3, member.getName());
				pstmt.setTimestamp(4, new Timestamp(member.getRegisterDate().getTime()));
				return pstmt;
			}
		});


//		jdbcTemplate.update(
//				"update MEMBER set NAME = ?, PASSWORD = ? where EMAIL = ?",
//				member.getName(), member.getPassword(), member.getEmail());


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



	public int count(){
//		List<Integer> results = jdbcTemplate.query(
//				"select count(*) from MEMBER",
//				new RowMapper<Integer>() {
//					@Override
//					public Integer mapRow(ResultSet rs, int rowNum) throws SQLException {
//						return rs.getInt(1);
//					}
//				}
//		);
//		return results.get(0);

//		결과 행이 한 개의 컬럼만 가진 경우를 위한 메서드  queryForObject()메서드의 두번 째 파라미터는 칼럼을 읽어올 때 사용할 타입을 지정
//				예를 들어 평균을 구하는 경우라면
//				Double.class 타입을 사용

				Integer count = jdbcTemplate.queryForObject(
				"select count(*) from MEMBER", Integer.class);
		return count;
	}

}
