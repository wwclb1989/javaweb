package cn.itcast.jdbc.example;

import java.sql.SQLException;

import cn.itcast.jdbc.example.dao.AccountDao;
import cn.itcast.jdbc.example.domain.Account;
import cn.itcast.jdbc.utils.JDBCUtils;

public class Business {

	public static void transfer(String sourceAccountName, String toAccountName, float money) {
		try {
			JDBCUtils.startTransaction();
			AccountDao dao = new AccountDao();
			Account accountfrom = dao.find(sourceAccountName);
			Account accountto = dao.find(toAccountName);
			//完成转账操作
			if (money < accountfrom.getMoney()) {
				accountfrom.setMoney(accountfrom.getMoney() - money);
			} else {
				System.out.println("转出账户余额不足");
				throw new Exception();
			}
			accountto.setMoney(accountto.getMoney() + money);
			dao.update(accountfrom);
			dao.update(accountto);
			JDBCUtils.commit();
			System.out.println("提交成功");
		} catch (Exception e) {
			System.out.println("提交失败");
			JDBCUtils.rollback();
			e.printStackTrace();
		} finally {
			JDBCUtils.close();
		}
	}
	
	public static void main(String[] args) {
		transfer("a", "b", 200);
	}
}
