package com.example.demo.importexcel.engine;

import java.lang.reflect.Field;

import com.example.demo.importexcel.annotation.ExcelColumn;

/**
* @ClassName: ImpotExcel
* @Description:
* @Author: York
* @Date: 2018/7/10 0010 9:51
* @Version: V1.0
*/
public class ImpotExcel {

	public void exportexcel(Class<?> cls){
        Field[] fs = cls.getDeclaredFields();
        for (Field f : fs){
        	ExcelColumn ef = f.getAnnotation(ExcelColumn.class);
            if (ef != null){
            	// TODO
            }
        }
    }
	
}
