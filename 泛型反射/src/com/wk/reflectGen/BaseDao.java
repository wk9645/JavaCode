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
 * ���ͷ���
 * @author asus
 *
 * @param <T> ��������
 */
public class BaseDao<T> {
	
	private Class clazz;
	
	private String className;
	
	//�ڹ��캯���л�ȡ��ǰ������Ĳ���������
	public BaseDao(){
		
		
		/*
		 * this����ǰ������        	AdminDao
		 * this.getClass()����ǰ��������ֽ���			AdminDao.class		
		 * this.getClass().getGenericSuperclass()����ǰ������ĸ���		BaseDao<Admin>		
		 * 
		 */
		
		
		Type type = this.getClass().getGenericSuperclass();
		
		//ǿ��ת��Ϊ����������
		ParameterizedType pType = (ParameterizedType) type;
		
		//��ȡ�����������е�ʵ�����Ͷ���
		
		Type[] types = pType.getActualTypeArguments();
		
		//��ȡ����ĵ�һ��Ԫ��
		clazz = (Class)types[0];
		
		//��ȡ����
		className = clazz.getName();
		
	}
	
	
	
	//ͨ��id����
	public T findById(int id) throws SQLException{
		
		String sql = "select *from admin where id=?";
		
		Connection conn = JdbcUtil.getConnection();
		
		QueryRunner qr = new QueryRunner();
		
		//clazzָ:��.class
		
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
