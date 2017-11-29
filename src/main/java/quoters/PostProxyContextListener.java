package quoters;

import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class PostProxyContextListener implements ApplicationListener<ContextRefreshedEvent> {
    @Setter(onMethod = @__(@Autowired))
    ConfigurableListableBeanFactory configurableListableBeanFactory;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        ApplicationContext applicationContext = contextRefreshedEvent.getApplicationContext();
        for (String name : applicationContext.getBeanDefinitionNames()) {
            BeanDefinition beanDefinition = configurableListableBeanFactory.getBeanDefinition(name);
            String originalBeanClassName = beanDefinition.getBeanClassName();
            try {
                Class<?> originalClass = Class.forName(originalBeanClassName);
                for (Method method: originalClass.getMethods()) {
                    if (method.isAnnotationPresent(PostProxy.class)) {
                        Object bean = applicationContext.getBean(name);
                        try {
                            Method currentMethod = bean.getClass().getMethod(method.getName(), method.getParameterTypes());
                            currentMethod.invoke(bean);
                        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
                            e.printStackTrace();
                        }
                    }
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
