package ace.authentication.base.define.constraint;

import javax.validation.Payload;
import javax.validation.constraints.Pattern;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @author Caspar
 * @contract 279397942@qq.com
 * @create 2020/7/26 13:27
 * @description
 */
@Pattern(regexp = "^(platform|user|seller)$", message = "请输入正确的" + AccountBizTypeConstraint.FIELD_NAME)
@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})
@Retention(RUNTIME)
public @interface AccountBizTypeConstraint {
    String FIELD_NAME = "账号类型";

    String message() default "";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
