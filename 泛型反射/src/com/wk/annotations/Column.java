package com.wk.annotations;

import java.lang.annotation.Target;
import static java.lang.annotation.ElementType.FIELD;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/*
 * ÁÐÃû³Æ
 */

@Retention(RetentionPolicy.RUNTIME)
@Target({FIELD})
public @interface Column {

	String columnName();
}
