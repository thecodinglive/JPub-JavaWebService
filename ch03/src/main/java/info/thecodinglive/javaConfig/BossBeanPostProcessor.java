package info.thecodinglive.javaconfig;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class BossBeanPostProcessor implements BeanPostProcessor {
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("before init bean type: " + bean.getClass());
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		if (bean instanceof Boss && beanName.equals("boss")) {
			System.out.println("after init bean type: " + bean.getClass());
			((Boss) bean).createdHandler();
		}
		return bean;
	}
}
