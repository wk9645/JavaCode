package com.wk.annotations;

import java.lang.annotation.Target;
import static java.lang.annotation.ElementType.TYPE;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/*
 * ��������Ϣ
 */

@Retention(RetentionPolicy.RUNTIME)
@Target ({TYPE})
public @interface Table {
	
	String tableName();
}
