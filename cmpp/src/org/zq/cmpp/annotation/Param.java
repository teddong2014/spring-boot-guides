package org.zq.cmpp.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * ������������CMPPЭ���еĲ�����Ϣ
 * 
 * @author EddyZhou(zhouqian1103@gmail.com)
 * 
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Param {

	int length() default 0;

	boolean dynamic() default false;

	boolean encode() default false;

	boolean encrypt() default false;

	boolean decode() default false;
}
