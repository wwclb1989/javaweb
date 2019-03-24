package cn.itcast.jdbc;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class UserDaoImpl implements UserDao {

	private JdbcTemplate jdbcTemplate;
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public int addUser(User user) {
		String sql = "insert into t_user(username,password) values(?,?)";
		Object[] obj = new Object[] {
				user.getUsername(),
				user.getPassword()
		};
		int flag = this.jdbcTemplate.update(sql, obj);
		return flag;
	}

	@Override
	public int updateUser(User user) {
		String sql = "update t_user set username=?,password=? where userid=?";
		Object [] params = new Object [] {
				user.getUsername(),
				user.getPassword(),
				user.getUserid()
		};
		int flag = jdbcTemplate.update(sql, params);
		return flag;
	}

	@Override
	public int deleteUserById(int id) {
		//定义SQL语句
		String sql = "delete from t_user where userid=?";
		//获取返回结果
		int flag = jdbcTemplate.update(sql, id);
		return flag;
	}

	@Override
	public User findUserById(int id) {
		String sql = "select * from t_user where userid=?";
		RowMapper<User> rowMapper = BeanPropertyRowMapper.newInstance(User.class); //spring5是如何
		return this.jdbcTemplate.queryForObject(sql, rowMapper, id);
	}

	@Override
	public List<User> findAllUser() {
		String sql = "select * from t_user";
		RowMapper<User> rowMapper = BeanPropertyRowMapper.newInstance(User.class);
		return this.jdbcTemplate.query(sql, rowMapper);
	}

}
