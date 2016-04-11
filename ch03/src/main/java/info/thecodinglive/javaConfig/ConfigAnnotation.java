package info.thecodinglive.javaConfig;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Import(MessageConfig.class)
public @interface  ConfigAnnotation {
}
