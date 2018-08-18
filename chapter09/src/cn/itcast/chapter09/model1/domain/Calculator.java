package cn.itcast.chapter09.model1.domain;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class Calculator {

	private String firstNum;
	private String secondNum;
	private char operator;
	private Map<String, String> errors = new HashMap<>();
	public String getFirstNum() {
		return firstNum;
	}
	public void setFirstNum(String firstNum) {
		this.firstNum = firstNum;
	}
	public String getSecondNum() {
		return secondNum;
	}
	public void setSecondNum(String secondNum) {
		this.secondNum = secondNum;
	}
	public char getOperator() {
		return operator;
	}
	public void setOperator(char operator) {
		this.operator = operator;
	}
	public Map<String, String> getErrors() {
		return errors;
	}
	public void setErrors(Map<String, String> errors) {
		this.errors = errors;
	}
	/*
	 * calculator()方法根据传入的运算数和符号进行运算
	 */
	public String calculate() {
		BigDecimal result = null;
		BigDecimal first = new BigDecimal(firstNum);
		BigDecimal second = new BigDecimal(secondNum);
		switch (operator) {
		case '+':
			result = first.add(second);
			break;
		case '-':
			result = first.subtract(second);
			break;
		case '*':
			result = first.multiply(second);
			break;
		case '/':
			if ("0".equals(secondNum)) {
				throw new RuntimeException("除数不能为0!");
			}
			result = first.divide(second);
			break;
		}
		return result.toString();
	}
	
	public boolean validate() {
		//flag是标识符,如果数据合法flag为true,反之为false
		boolean flag = true;
		Pattern p = Pattern.compile("\\d+");
		if (firstNum == null || "".equals(firstNum)) {
			errors.put("firstNum", "第一个运算数不能为空");
			flag = false;
		} else if (!p.matcher(firstNum).matches()) {
			errors.put("firstNum", "第一个运算数必须为数字");
			flag = false;
		}
		
		if (secondNum == null || "".equals(secondNum)) {
			errors.put("secondNum", "第二个运算数不能为空");
			flag = false;
		} else if (!p.matcher(secondNum).matches()) {
			errors.put("secondNum", "第二个运算数必须为数字");
			flag = false;
		}
		return flag;
		
	}
}
