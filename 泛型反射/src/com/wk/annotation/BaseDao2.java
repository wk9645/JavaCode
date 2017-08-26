package com.wk.annotation;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;

import com.wk.annotations.Column;
import com.wk.annotations.Id;
import com.wk.annotations.Table;
import com.wk.utils.JdbcUtil;

/**
 * 
 * 当查找数据库数据时：
 * 		1、Javabean的类名与数据库的表名不一致
 * 		2、类的属性和表中的字段不一致
 * 		3、类中没有和表中主键相同的属性时
 * 
 * 此时可以使用xml配置，也可以用注解
 * @author asus
 *
 */
public class BaseDao2<T> {

	private String tableName;
	private Class<T> clazz;
	private String pri_name;
	
	//构造方法中获取参数化类型
	public BaseDao2(){
		Type type = this.getClass().getGenericSuperclass();
		
		ParameterizedType pType = (ParameterizedType) type; 
		
		Type[] types = pType.getActualTypeArguments();
		
		clazz = (Class<T>) types[0];
		
		
		//获取表名
		Table table = clazz.getAnnotation(Table.class);
		tableName = table.tableName();
		
		//获取主键字段，通过遍历获取带有@Id的属性
		Field[] fields = clazz.getDeclaredFields();
		
		for (Field field : fields) {
			
			field.setAccessible(true);
			
			//获取带有Id属性，如果不为空则为主键
			Id id = field.getAnnotation(Id.class);
			
			if(id !=null){
				
				Column columnName = field.getAnnotation(Column.class);
				
				pri_name = columnName.columnName();
				break;
			}
		}
		
		
	}
	
	//根据id获取记录
	public T findById(int id){
		
		try {
			String sql = "select *from "+tableName+" where "+pri_name+"=?";
			Connection conn = JdbcUtil.getConnection();
			
			QueryRunner qr = new QueryRunner();
			
			return qr.query(conn, sql, new BeanHandler<T>(clazz),id);
		} catch (SQLException e) {
			
			throw new RuntimeException(e);
		} 
	}
	
	
	public List<T> findAll(){
		try {
			String sql = "select *from "+tableName;
			
			Connection conn = JdbcUtil.getConnection();
			
			QueryRunner qr = new QueryRunner();
			return qr.query(conn, sql, new BeanListHandler<T>(clazz));
		} catch (SQLException e) {
			throw new RuntimeException();
		}
		
	}
	
}

/*
 * 获取一条数据
 */

class BeanHandler<T> implements ResultSetHandler<T>{

	private Class<T> clazz;   //指定类型为T
	
	//保存要传入的类的字节码
	
	public BeanHandler(Class<T> clazz){
		
		this.clazz = clazz;
	}
	
	@Override
	public T handle(ResultSet rs) throws SQLException {
		
		try {
			T t = clazz.newInstance();
			//如果有结果集
			if(rs.next()){
				
				Field[] fields = clazz.getDeclaredFields();//获取所有字段
				
				for (Field field : fields) {
					
					String attrName = field.getName();  //获取属性名
					
					//获取注解的值,即数据库的字段名
					Column column = field.getAnnotation(Column.class);
					String columnName = column.columnName();  
					
					//获取字段值
					Object columnValue = rs.getObject(columnName);
					BeanUtils.copyProperty(t, attrName, columnValue);
				}
				
			}
			
			return t;
		} catch (Exception e) {
			throw new RuntimeException(e);
		} 
		
	}

}

/*
 * 获取所有数据
 */

class BeanListHandler<T> implements ResultSetHandler<List<T>>{

	private Class<T> clazz;
	
	public BeanListHandler(Class<T> clazz) {
		
		this.clazz = clazz;
	}

	@Override
	public List<T> handle(ResultSet rs) throws SQLException {
		
		try {
			List<T> list = new ArrayList<>();
			
			while(rs.next()){
				
				T t = clazz.newInstance();
				
				Field[] fields = clazz.getDeclaredFields();
				
				for (Field field : fields) {
					
					//获取属性名
					String attrName = field.getName();
					
					//获取数据库字段
					
					Column column = field.getAnnotation(Column.class);
					String columnName = column.columnName();
					
					Object columnValue = rs.getObject(columnName);
					
					Connection conn = JdbcUtil.getConnection();
					BeanUtils.copyProperty(t, attrName, columnValue);
					
					list.add(t);
				}
				
			}
			
			return list;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
}
