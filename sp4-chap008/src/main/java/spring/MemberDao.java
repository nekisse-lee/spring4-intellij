package spring;

import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

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

	public void insert(final Member member) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement pstmt = con.prepareStatement(
						"insert into MEMBER (EMAIL, PASSWORD, NAME, REGDATE)" +
								"values(?,?,?,?)",
						new String[]{"ID"});
				pstmt.setString(1, member.getEmail());
				pstmt.setString(2, member.getPassword());
				pstmt.setString(3, member.getName());
				pstmt.setTimestamp(4,
						new Timestamp(member.getRegisterDate().getTime()));
				return pstmt;
			}
		}, keyHolder);
		Number keyValue = keyHolder.getKey();
		member.setId(keyValue.longValue());

	}

	public void update(Member member) {
		jdbcTemplate.update(
				"update MEMBER set NAME = ?, PASSWORD = ? where EMAIL = ? ",
				member.getName(), member.getPassword(), member.getEmail()
		);
// 			NAME = ? 는 member.getName(),   PASSWORD = ? 는 member.getPassword(), EMAIL = ? 는  member.getEmail()
//		로 쿼리의 인덱스 파라미터의 값으로 사용

			//경우의 따라 PreparedStatement 의 set 메서드를 사용해서 인덱스 파라미터 값을 설정해주어야 할 때가 있다
//		jdbcTemplate.update(new PreparedStatementCreator() {
//			@Override
//			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
//				PreparedStatement pstmt = con.prepareStatement(
//						"insert into MEMBER(EMAIL, PASSWORD, NAME,REGDATE) values (?,?,?,?)");
//				return pstmt;
//			}
//		});

	}

    public List<Member> selectAll() {
        List<Member> results = jdbcTemplate.query("select * from MEMBER",
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
        return results;
    }

		//   중복코드 를 제거하기 위해 MemberRowMapper 클래스를 정의하고 사용
//		List<Member> results = jdbcTemplate.query("select * from Member",
//				new MemberRowMapper());
//		return results;
//	}

	public int count(){
//		List<Integer> results = jdbcTemplate.query(
//				"select count(*) from MEMBER",
//				new RowMapper<Integer>() {
//
//					@Override
//					public Integer mapRow(ResultSet rs, int rowNum) throws SQLException {
//						return rs.getInt(1);
//					}
//				});
//		return results.get(0);


		// 결과 행이 한 개의 컬럼만 가진 경우를 위한 메서드!   두번째 파라미터는 칼럼을 읽어 올 때 사용할 타입을 지정!
		//만약 평균을 구하는 경우 Double.class 타입을 사용
		Integer count = jdbcTemplate.queryForObject(
				"select count(*) from MEMBER", Integer.class);
		return count;

		//실행 결과과 두개 이상의 컬럼을 가지고 있는 경우 RowMapper를 파라미터로 전달해서  값을 전달 받을 수 있다
		//기존의 query()문과 차이점은  리턴 타입이 List가 아니라 RowMapper로 변환해주는 타입 ( 아래 코드에서는 Member)라는 점이다
		// queryForObject()  메서드를 사용할때 주의점은 쿼리 실행 결과는 반드시!!!! 한 행이어야 한다 쿼리 실행 개수가 0이나 2 이상이면
		// IncorrectResultSizeDataAccessException 을 발생  ,  행의 개수가 0이면 EmptyResultDataAccessExcetpion 발생
//		Member member = jdbcTemplate.queryForObject(
//				"select * from MEMBER where ID = ?",
//				new RowMapper<Member>() {
//					@Override
//					public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
//						Member member = new Member(rs.getString("EMAIL"),
//								rs.getString("PASSWORD"),
//								rs.getString("NAME"),
//								rs.getTimestamp("REGDATE"));
//						member.setId(rs.getLong("ID"));
//						return member;
//					}
//				},
//				100);



	}

}
