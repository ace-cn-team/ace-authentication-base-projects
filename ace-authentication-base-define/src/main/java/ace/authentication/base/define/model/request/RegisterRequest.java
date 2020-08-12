package ace.authentication.base.define.model.request;

import ace.authentication.base.define.dao.model.entity.AccountEvent;
import ace.authentication.base.define.dao.model.entity.Account;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * @author Caspar
 * @contract 279397942@qq.com
 * @create 2020/1/18 11:16
 * @description
 */
@Data
@Accessors(chain = true)
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
    @NotNull
    @Valid
    @ApiModelProperty(value = "注册账号信息")
    Account account;

    @NotNull
    @Valid
    @ApiModelProperty(value = "注册事件")
    AccountEvent accountEvent;
}