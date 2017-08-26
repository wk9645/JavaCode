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
 * ���������ݿ�����ʱ��
 * 		1��Javabean�����������ݿ�ı�����һ��
 * 		2��������Ժͱ��е��ֶβ�һ��
 * 		3������û�кͱ���������ͬ������ʱ
 * 
 * ��ʱ����ʹ��xml���ã�Ҳ������ע��
 * @author asus
 *
 */
public class BaseDao2<T> {

	private String tableName;
	private Class<T> clazz;
	private String pri_name;
	
	//���췽���л�ȡ����������
	public BaseDao2(){
		Type type = this.getClass().getGenericSuperclass();
		
		ParameterizedType pType = (ParameterizedType) type; 
		
		Type[] types = pType.getActualTypeArguments();
		
		clazz = (Class<T>) types[0];
		
		
		//��ȡ����
		Table table = clazz.getAnnotation(Table.class);
		tableName = table.tableName();
		
		//��ȡ�����ֶΣ�ͨ��������ȡ����@Id������
		Field[] fields = clazz.getDeclaredFields();
		
		for (Field field : fields) {
			
			field.setAccessible(true);
			
			//��ȡ����Id���ԣ������Ϊ����Ϊ����
			Id id = field.getAnnotation(Id.class);
			
			if(id !=null){
				
				Column columnName = field.getAnnotation(Column.class);
				
				pri_name = columnName.columnName();
				break;
			}
		}
		
		
	}
	
	//����id��ȡ��¼
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
 * ��ȡһ������
 */

class BeanHandler<T> implements ResultSetHandler<T>{

	private Class<T> clazz;   //ָ������ΪT
	
	//����Ҫ���������ֽ���
	
	public BeanHandler(Class<T> clazz){
		
		this.clazz = clazz;
	}
	
	@Override
	public T handle(ResultSet rs) throws SQLException {
		
		try {
			T t = clazz.newInstance();
			//����н����
			if(rs.next()){
				
				Field[] fields = clazz.getDeclaredFields();//��ȡ�����ֶ�
				
				for (Field field : fields) {
					
					String attrName = field.getName();  //��ȡ������
					
					//��ȡע���ֵ,�����ݿ���ֶ���
					Column column = field.getAnnotation(Column.class);
					String columnName = column.columnName();  
					
					//��ȡ�ֶ�ֵ
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
 * ��ȡ��������
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
					
					//��ȡ������
					String attrName = field.getName();
					
					//��ȡ���ݿ��ֶ�
					
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
