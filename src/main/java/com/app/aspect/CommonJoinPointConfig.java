package com.app.aspect;

import org.aspectj.lang.annotation.Pointcut;

public class CommonJoinPointConfig {
	
	@Pointcut("execution(* com.app.controller.*.*(..))")
	public void controllerExecution(){}
	
	/*@Pointcut("execution(* com.app.controller.*.*(..))")
	public void businessLayerExecution(){}*/
	
}
