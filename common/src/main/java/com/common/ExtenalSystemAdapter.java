package common;

import org.springframework.core.annotation.AliasFor;
import org.springframework.stereotype.Component;

import java.lang.annotation.*;

@Target({ElementType.TYPE}) //class에 달 수 있는 어노테이션
@Retention(RetentionPolicy.RUNTIME) //실행 중일때만 적용되게 해주고
@Documented
@Component
public @interface ExtenalSystemAdapter {
    @AliasFor(annotation = Component.class)
    String value() default "";
}
