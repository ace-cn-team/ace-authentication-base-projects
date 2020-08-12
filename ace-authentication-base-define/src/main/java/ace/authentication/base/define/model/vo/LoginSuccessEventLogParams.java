package ace.authentication.base.define.model.vo;

import ace.authentication.base.define.dao.enums.account.AccountBizTypeEnum;
import ace.authentication.base.define.dao.model.entity.Account;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * @author Caspar
 * @contract 279397942@qq.com
 * @create 2020/2/3 12:19
 * @description
 */
@Data
@Accessors(chain = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoginSuccessEventLogParams {

    @ApiModelProperty(value = "应用id")
    private String appId;

    @ApiModelProperty(value = "账号id")
    private String accountId;

    @ApiModelProperty(value = "登录类型")
    private String loginSource;

    /**
     * {@link AccountBizTypeEnum}
     */
    @ApiModelProperty(value = Account.ACCOUNT_BIZ_TYPE_REMARK)
    private String bizType;
    @ApiModelProperty(value = "登录时间")
    private LocalDateTime loginTime;
    @ApiModelProperty(value = "ip地址")
    private String ip;
}
