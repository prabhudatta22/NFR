/**
 ******************************************************************************
 * 							  	STAYING SHARP
 *  							CONFIDENTIAL
 *							
 * *****************************************************************************
 */

package org.TA.TANFR.customlisteners;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

/**
 * The Class AnnotationTransformer.
 */
public class AnnotationTransformer implements IAnnotationTransformer {

 	@Override
	    public void transform(ITestAnnotation annotation, @SuppressWarnings("rawtypes") Class testClass, @SuppressWarnings("rawtypes") Constructor testConstructor, Method testMethod) {
	        annotation.setRetryAnalyzer(RetryListeners.class);
	    }
	

}
