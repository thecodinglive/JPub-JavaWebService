package info.thecodinglive.javaconfig;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

@Component
public class BeanScopeModifier implements BeanFactoryPostProcessor {
	public BeanScopeModifier() {
		System.out.println("beanScopeModifier 초기화");
	}

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		if (beanFactory.containsBeanDefinition("boss")) {
			BeanDefinition beanDefinition = beanFactory.getBeanDefinition("boss");
			beanDefinition.setScope(BeanDefinition.SCOPE_PROTOTYPE);
		}
	}
}
