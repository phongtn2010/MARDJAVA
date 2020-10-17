package com.nsw.backend.configuration;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Configuration
@Aspect
@Component
@Profile(value = {"dev", "blameo_test"})
public class AspectPerformanceWatcher {

    public static final Logger logger = LoggerFactory.getLogger(AspectPerformanceWatcher.class);

    @Autowired
    private Environment environment;

    //@SuppressWarnings("unchecked")
    @Around("execution(* com.nsw.backend.mard.service.*..*(..)) || " +
            "execution(* com.nsw.backend.mard.p01.*..*(..)) || " +
            "execution(* com.nsw.backend.mard.p06.*..*(..)) || " +
            "execution(* com.nsw.backend.mard.p07.*..*(..)) || " +
            "execution(* com.nsw.backend.mard.p08.*..*(..)) || " +
            "execution(* com.nsw.backend.mard.p09.*..*(..))")
    public Object calculatePerformance(ProceedingJoinPoint pjp) throws Throwable {
        final long start = System.currentTimeMillis();
        // Execution of target method
        final Object result = pjp.proceed();
        final long duration = System.currentTimeMillis() - start;
        // Get the definition of annotation and of this admissible threshold (warning duration)
        //final PerformanceWatcher performanceWatcher = (PerformanceWatcher) pjp.getSourceLocation().getWithinType().getAnnotation(PerformanceWatcher.class);

        // Check if the method's execution time exceeds the admissible threshold
        String delayTimes = environment.getRequiredProperty("TIMEOUT");
        Long delayTime = Long.valueOf(delayTimes);
        delayTime = 1000L;
        if (delayTime < duration) {
            logger.error("**** THE METHOD " + pjp.getSignature().getName() + " FROM " + pjp.getSignature().getDeclaringTypeName() + " TOOK " + duration + " MS (max " + delayTimes + " ms). ****");
        }//end-if

        return result;
    }
}
