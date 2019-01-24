/** 
 * <pre>项目名称:easyui_demo 
 * 文件名称:SendPage.java 
 * 包名:com.jk.pojo 
 * 创建日期:2018-11-29上午10:58:49 
 * Copyright (c) 2018, wzstart@126.com All Rights Reserved.</pre> 
 */  
package com.jk.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**   
 * 业精于勤荒于嬉,行成于思毁于随   
 * 创建人：wzstart    
 * 创建时间：2018-11-29 上午10:58:49 
 * 
 *  发送给datagrid控件的数据
 *  属性的名字必须是  total  rows
 */
@Data
@AllArgsConstructor//全部参数的构造方法
@NoArgsConstructor//一定要写无参的构造方法
public class SendPage {

	
	private Integer total;
	
	private List rows;
	
}
