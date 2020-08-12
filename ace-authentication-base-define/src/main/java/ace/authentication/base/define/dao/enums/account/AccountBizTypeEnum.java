package ace.authentication.base.define.dao.enums.account;

import ace.fw.enums.BaseEnum;
import ace.fw.util.AceEnumUtils;
import lombok.Getter;

/**
 * @author Caspar
 * @contract 279397942@qq.com
 * @create 2020/1/20 14:21
 * @description
 */
public enum AccountBizTypeEnum implements BaseEnum<String> {
    PLATFORM("platform", "平台账号"),
    USER("user", "客户账号"),
    SELLER("seller", "商家账号"),

    ;
    @Getter
    private String code;
    @Getter
    private String desc;

    AccountBizTypeEnum(String code, String desc) {

        this.code = code;
        this.desc = desc;
    }

    public static AccountBizTypeEnum resolve(String accountBizType) {
        return AceEnumUtils.getEnum(AccountBizTypeEnum.class, accountBizType);
    }
}
