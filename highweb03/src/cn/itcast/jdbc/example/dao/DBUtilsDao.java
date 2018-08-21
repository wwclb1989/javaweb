package cn.itcast.jdbc.example.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.itcast.jdbc.example.domain.User;
import cn.itcast.jdbc.utils.C3p0Utils;

public class DBUtilsDao {

	//查询所有，返回List集合
	public List findAll() throws SQLException {
		QueryRunner runner = new QueryRunner(C3p0Utils.getDataSource());
		String sql = "select * from user";
		List list = (List) runner.query(sql, new BeanListHandler(User.class));
		return list;
	}
	
	//查询单个，返回对象
	public User find(int id) throws SQLException {
		QueryRunner runner = new QueryRunner(C3p0Utils.getDataSource());
		String sql = "select * from user where id=?";
		User user = (User) runner.query(sql, new BeanHandler(User.class), new Object[]{id});
		return user;
	}
	
	//添加用户的操作
	public Boolean insert(User user) throws SQLException {
		QueryRunner runner = new QueryRunner(C3p0Utils.getDataSource());
		String sql = "insert into user (name,password) values (?,?)";
		int num = runner.update(sql, new Object[] {user.getName(),user.getPassword()});
		if (num > 0) {
			return true;
		}
		return false;
	}
	
	//修改用户的操作
	public Boolean update(User user) throws SQLException {
		QueryRunner runner = new QueryRunner(C3p0Utils.getDataSource());
		String sql = "update user set name=?,password=? where id=?";
		int num = runner.update(sql, new Object[] {user.getName(), user.getPassword(), user.getId()});
		if (num > 0) {
			return true;
		}
		return false;
	}
	
	//删除用户的操作
	public Boolean delete(int id) throws SQLException {
		QueryRunner runner = new QueryRunner(C3p0Utils.getDataSource());
		String sql = "delete from user where id=?";
		int num = runner.update(sql, id);
		if (num > 0) {
			return true;
		}
		return false;
	}
}
