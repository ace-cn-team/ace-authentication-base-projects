package ace.authentication.base.define.dao.enums.account;

import ace.authentication.base.define.dao.model.entity.Account;
import ace.fw.enums.BaseEnum;
import lombok.Getter;

/**
 * @author Caspar
 * @contract 279397942@qq.com
 * @create 2020/2/19 16:10
 * @description {@link Account#STATE_REMARK} 状态，0-停用，1-启用，2-锁定，3-过期，4-需修改密码
 */
public enum AccountStateEnum implements BaseEnum<Integer> {
    DISABLE(0, "账号已停用"),
    ENABLE(1, "账号正常"),
    LOCKED(3, "账号已锁定"),
    EXPIRED(4, "账号已过期"),
    MUST_CHANGE_PASSWORD(5, "需修改密码"),
    ;
    @Getter
    private Integer code;
    @Getter
    private String desc;

    AccountStateEnum(Integer code, String desc) {

        this.code = code;
        this.desc = desc;
    }

}
