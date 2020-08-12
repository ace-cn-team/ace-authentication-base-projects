package ace.authentication.base.define.dao.enums.accountevent;

import ace.fw.enums.BaseEnum;
import ace.fw.util.AceEnumUtils;
import lombok.Getter;

/**
 * @author Caspar
 * @contract 279397942@qq.com
 * @create 2020/6/28 15:58
 * @description 事件类型, 0-注册,1-登入,2-登出,3-修改密码
 */
public enum AccountEventEventTypeEnum implements BaseEnum<Integer> {
    REGISTER(0, "注册"),

    LOGIN(1, "登入"),

    LOGOUT(2, "登出"),

    MODIFY_PASSWORD(3, "修改密码"),

    ;

    @Getter
    private Integer code;
    @Getter
    private String desc;

    AccountEventEventTypeEnum(Integer code, String desc) {

        this.code = code;
        this.desc = desc;
    }

    public static AccountEventEventTypeEnum resolve(Integer eventType) {
        return AceEnumUtils.getEnum(AccountEventEventTypeEnum.class, eventType);
    }
}
