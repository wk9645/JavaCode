package com.wk.annotations;

import static java.lang.annotation.ElementType.FIELD;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/*
 * Ö÷¼üÃû
 */

@Retention(RetentionPolicy.RUNTIME)
@Target({FIELD})
public @interface Id {
	
	
}
