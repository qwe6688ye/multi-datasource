package com.study.multidatasource.aspect;

import com.study.multidatasource.annotation.DS;
import com.study.multidatasource.datasource.DataSourceContextHolder;
import com.study.multidatasource.datasource.DynamicDataSource;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Component
public class DataSourceAspect {

    @Pointcut("@annotation(com.study.multidatasource.annotation.DS)")
    public void DataSource(){
    }

    @Before("DataSource()")
    public void beforeSwitchDS(JoinPoint point){

        String dataSource = DataSourceContextHolder.DEFAULT_DS;

        Signature signature = point.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        Method method = methodSignature.getMethod();
        if(method.isAnnotationPresent(DS.class)) {
            DS annotation = method.getAnnotation(DS.class);
            dataSource = annotation.value();
        }
        DataSourceContextHolder.setDB(dataSource);


    }

    @After("DataSource()")
    public void afterSwitchDS(JoinPoint point){
        DataSourceContextHolder.clearDB();
    }
}
