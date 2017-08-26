package com.wk.reflectGen;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.wk.utils.JdbcUtil;


/**
 * 
 * 泛型反射
 * @author asus
 *
 * @param <T> 任意类型
 */
public class BaseDao<T> {
	
	private Class clazz;
	
	private String className;
	
	//在构造函数中获取当前运行类的参数化类型
	public BaseDao(){
		
		
		/*
		 * this代表当前运行类        	AdminDao
		 * this.getClass()代表当前运行类的字节码			AdminDao.class		
		 * this.getClass().getGenericSuperclass()代表当前运行类的父类		BaseDao<Admin>		
		 * 
		 */
		
		
		Type type = this.getClass().getGenericSuperclass();
		
		//强制转换为参数化类型
		ParameterizedType pType = (ParameterizedType) type;
		
		//获取参数化类型中的实际类型定义
		
		Type[] types = pType.getActualTypeArguments();
		
		//获取数组的第一个元素
		clazz = (Class)types[0];
		
		//获取类名
		className = clazz.getName();
		
	}
	
	
	
	//通过id搜索
	public T findById(int id) throws SQLException{
		
		String sql = "select *from admin where id=?";
		
		Connection conn = JdbcUtil.getConnection();
		
		QueryRunner qr = new QueryRunner();
		
		//clazz指:类.class
		
		T t = qr.query(conn, sql, new BeanHandler<T>(clazz), id);
		
		return t;
		
	}
	
	public List<T> findAll() throws SQLException{
		
		String sql = "select *from admin";
		
		Connection conn = JdbcUtil.getConnection();
		
		QueryRunner qr = new QueryRunner();
		
		 return qr.query(conn, sql, new BeanListHandler<T>(clazz));
	}
	
	
}
