package cn.itcast.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import cn.itcast.dao.UserDao;
import cn.itcast.domain.User;

public class UserDaoImpl implements UserDao {

	private JdbcTemplate jdbcTemplate;
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public void save(User user) {
		//sql语句
		String sql = "insert into t_user(username,password) values(?,?)";
		//获取参数
		Object [] params = new Object[]{
			user.getUsername(),
			user.getPassword()
		};
		//执行插入
		jdbcTemplate.update(sql, params);
	}

	@Override
	public void update(User user) {
		//sql语句
		String sql = "update t_user set username=?,password=? where userid=?";
		//获取参数
		Object [] params = new Object[]{
			user.getUsername(),
			user.getPassword(),
			user.getUserid()
		};
		//执行更新
		jdbcTemplate.update(sql, params);
	}

	@Override
	public void delete(User user) {
		//sql语句
		String sql = "delete from t_user where userid=?";
		//执行删除
		jdbcTemplate.update(sql, user.getUserid());
	}

	@Override
	public User findById(Integer id) {
		//定义SQL语句
		String sql =  "select * from t_user where userid=?";
		//将结果集通过Java的反射机制映射到Java对象中
		RowMapper<User> rowMapper = BeanPropertyRowMapper.newInstance(User.class);
		//执行查询,返回单行记录
		return this.jdbcTemplate.queryForObject(sql, rowMapper, id);
	}

	@Override
	public List<User> findAll() {
		//定义SQL语句
		String sql = "select * from t_user";
		//将结果集通过Java的反射机制映射到Java对象中
		RowMapper<User> rowMapper = BeanPropertyRowMapper.newInstance(User.class);
		//执行查询,返回一个集合
		return this.jdbcTemplate.query(sql, rowMapper);
	}

}
