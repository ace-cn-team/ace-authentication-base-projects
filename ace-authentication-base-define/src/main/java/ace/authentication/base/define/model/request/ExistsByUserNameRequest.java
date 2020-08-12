package ace.authentication.base.define.model.request;

import ace.authentication.base.define.constraint.AccountBizTypeConstraint;
import ace.authentication.base.define.constraint.UserNameConstraint;
import ace.authentication.base.define.dao.model.entity.Account;
import ace.common.base.define.model.constraint.AppIdConstraint;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author Caspar
 * @contract 279397942@qq.com
 * @create 2020/1/19 18:35
 * @description
 */
@Data
@Accessors(chain = true)
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ExistsByUserNameRequest {
    @AppIdConstraint
    @ApiModelProperty(value = AppIdConstraint.FIELD_NAME, required = true)
    private String appId;
    @UserNameConstraint
    @ApiModelProperty(value = UserNameConstraint.FIELD_NAME, required = true)
    private String userName;
    @AccountBizTypeConstraint
    @ApiModelProperty(value = Account.ACCOUNT_BIZ_TYPE_REMARK, required = true)
    private String bizType;
}
