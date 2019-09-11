package com.example.demo.importexcel.form;

import com.example.demo.importexcel.annotation.ExcelColumn;

import lombok.Data;

/**
* @ClassName: UserForm
* @Description: 
* @Author: York 
* @Date: 2018/7/10 0010 10:01
* @Version: V1.0
*/
@Data
public class UserForm {

	@ExcelColumn(1)
	public String name;
	
	@ExcelColumn(2)
	public String fullName;
	
	@ExcelColumn(3)
	public String gender;
	
	@ExcelColumn(4)
	public String phone;
	
}
