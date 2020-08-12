package ace.authentication.base.define.model.request;

import ace.authentication.base.define.dao.model.entity.Account;
import ace.common.base.define.model.constraint.AppIdConstraint;
import ace.common.base.define.model.constraint.MobileConstraint;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;

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
public class FindByAppIdAndMobileRequest {
    @AppIdConstraint
    @ApiModelProperty(value = AppIdConstraint.FIELD_NAME, required = true)
    private String appId;
    @NotBlank(message = "请输入" + MobileConstraint.FIELD_NAME)
    @ApiModelProperty(value = MobileConstraint.FIELD_NAME, required = true)
    private String mobile;
}
