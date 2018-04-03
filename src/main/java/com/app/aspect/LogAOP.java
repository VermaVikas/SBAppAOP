package com.app.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class LogAOP {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	//What kind of method calls I would intercept
	//execution(* PACKAGE.*.*(..))
	//Weaving & Weaver
	//public void before(JoinPoint joinPoint, Result rs){
	@Before("com.app.aspect.CommonJoinPointConfig.controllerExecution()")
	public void before(JoinPoint joinPoint){
		//Advice
		logger.info(" :: before :: Controller Called");
		logger.info(" :: before :: joinPoint.getSignature: ", joinPoint.getSignature());
		logger.info(" :: before :: joinPoint.getArgs: ", joinPoint.getArgs());
		logger.info(" :: before :: Allowed execution for {}", joinPoint);
	}
	
	@After(value = "com.app.aspect.CommonJoinPointConfig.controllerExecution()")
	public void after(JoinPoint joinPoint) {
		logger.info(" :: after :: joinPoint.getSignature: ", joinPoint.getSignature());
		logger.info(" :: after :: joinPoint.getArgs: ", joinPoint.getArgs());
		logger.info(" :: after :: Allowed execution for {}", joinPoint);
	}
	
	@AfterReturning(value = "com.app.aspect.CommonJoinPointConfig.controllerExecution()",  returning = "result")
	public void afterReturning(JoinPoint joinPoint, Object result) {
		logger.info(" :: afterReturning :: {} returned with value {}", joinPoint, result);
	}
	
	@Around("com.app.aspect.CommonJoinPointConfig.controllerExecution()")
	public void around(ProceedingJoinPoint joinPoint) throws Throwable {
		long startTime = System.currentTimeMillis();

		joinPoint.proceed();

		long timeTaken = System.currentTimeMillis() - startTime;
		logger.info(" :: around :: Time Taken by {} is {}", joinPoint, timeTaken);
	}
	
}
