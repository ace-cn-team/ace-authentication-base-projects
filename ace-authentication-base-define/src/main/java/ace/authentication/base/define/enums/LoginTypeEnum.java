package ace.authentication.base.define.enums;

import ace.fw.enums.BaseEnum;
import lombok.Getter;

/**
 * @author Caspar
 * @contract 279397942@qq.com
 * @create 2020/2/14 5:49
 * @description 账号来源
 */
public enum LoginTypeEnum implements BaseEnum<String> {
    MOBILE("mobile", "手机号码"),
    USER_NAME("username", "账号"),
    ;
    @Getter
    private String code;
    @Getter
    private String desc;

    LoginTypeEnum(String code, String desc) {

        this.code = code;
        this.desc = desc;
    }

}
