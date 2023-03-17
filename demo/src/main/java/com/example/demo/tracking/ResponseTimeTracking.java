package com.example.demo.tracking;

import java.sql.Time;
import java.time.LocalDateTime;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.domain.Tracking;
import com.example.demo.repositories.TrackingRepository;

@Aspect
@Component
public class ResponseTimeTracking {
@Autowired
private TrackingRepository trackingRepository;

	/*
	@Before(value = "execution(* com.example.demo.api.*.*(..))")
     public void before(JoinPoint jPoint) {
		
		System.out.println("API: "+jPoint.getSignature().getName()+" &  Start Time-------------" +System.currentTimeMillis());
		
	}
	
	@After(value = "execution(* com.example.demo.api.*.*(..))")
    public void after() {
		System.out.println("EndTime-------------" +System.currentTimeMillis());
		
	}
	*/
	
	@Around(value = "execution(* com.example.demo.api.*.*(..))")
    public Object around(ProceedingJoinPoint jPoint) throws Throwable {
		Tracking tracking = new Tracking ();
		
	
		Long startTime=System.currentTimeMillis();;
		//System.out.println("API: "+jPoint.getSignature().getName()+" &  StartTime------------" +startTime);
		tracking.setStartTime(LocalDateTime.now());
		tracking.setApiName(jPoint.getSignature().getName());
		Object obj = jPoint.proceed();
		Long endTime=System.currentTimeMillis();
		//System.out.println("API: "+jPoint.getSignature().getName()+" &  EndTime------------" +endTime);
		//System.out.println("API: "+jPoint.getSignature().getName()+" &  ResponseTime------------" +(endTime-startTime));
		tracking.setResponseTime((endTime-startTime));
		trackingRepository.save(tracking);
		return obj;
	}


}
