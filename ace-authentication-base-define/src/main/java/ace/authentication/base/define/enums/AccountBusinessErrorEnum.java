package ace.authentication.base.define.enums;

import ace.fw.enums.BaseEnum;
import lombok.Getter;

/**
 * @author Caspar
 * @contract 279397942@qq.com
 * @create 2020/3/17 15:10
 * @description
 */
public enum AccountBusinessErrorEnum implements BaseEnum<String> {
    EXIST_ACCOUNT("120001", "账号已存在"),
    NOT_EQUAL_SMS_VERIFY_CODE("120002", "请输入正确的验证码"),
    EXIST_NOT_ACCOUNT("120003", "账号不存在"),
    EXPIRE_ACCOUNT("120004", "账号已过期"),
    DISABLE_ACCOUNT("120005", "账号已失效"),
    LOCK_ACCOUNT("120006", "账号已锁定"),
    MUST_CHANGE_PASSWORD("120007", "账号需要修改密码"),
    NOT_EXIST_ACCOUNT_PROFILE("120008", "账号详情信息缺失"),
    PASSWORD_NOT_EQUAL("120009", "请输入正确的账号与密码");
    @Getter
    private String code;
    @Getter
    private String desc;

    AccountBusinessErrorEnum(String code, String desc) {

        this.code = code;
        this.desc = desc;
    }
}
