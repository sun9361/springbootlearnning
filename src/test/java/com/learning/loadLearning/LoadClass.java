package com.learning.loadLearning;

import java.util.Set;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;

public class LoadClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClassPathScanningCandidateComponentProvider provider = new ClassPathScanningCandidateComponentProvider(true);
		Set<BeanDefinition> beanDefinitions = provider.findCandidateComponents("org/spring/springboot");
		for(BeanDefinition beanDefinition : beanDefinitions) {
		    System.out.println(beanDefinition.getBeanClassName() 
		                    + "\t" + beanDefinition.getResourceDescription()
		                    + "\t" + beanDefinition.getClass());
		}
	}

}
