package ace.authentication.base.define.model.vo;

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
 * @description 注册事件参数
 */
@Data
@Accessors(chain = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterSuccessEventLogParams<Params> {

    @ApiModelProperty(value = "应用id")
    private String appId;

    @ApiModelProperty(value = "账号id")
    private String accountId;
    /**
     * {@link ace.authentication.base.define.dao.enums.account.AccountRegisterSourceEnum}
     */
    @ApiModelProperty(value = "登录类型")
    private String registerSource;
    @ApiModelProperty(value = "注册时间")
    private LocalDateTime registerTime;
    @ApiModelProperty(value = "ip地址")
    private String ip;
    @ApiModelProperty(value = "扩展参数标识Id")
    private String paramsId;
    @ApiModelProperty(value = "扩展参数json")
    private Params params;
}
