package ace.authentication.base.define.dao.model.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.Version;

import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;

/**
 * <p>
 * 账号事件日志表
 * </p>
 *
 * @author Caspar 279397942@qq.com
 * @since 2020-06-28
 */
@Data
@Accessors(chain = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "AccountEvent", description = "账号事件日志表")
public class AccountEvent implements Serializable {


    @ApiModelProperty(value = "id")
    @TableId(value = "id", type = IdType.NONE)
    private String id;

    @ApiModelProperty(value = "appid")
    private String appId;

    @ApiModelProperty(value = "账号id")
    private String accountId;

    @ApiModelProperty(value = EVENT_TYPE_REMARK)
    private Integer eventType;

    @ApiModelProperty(value = "事件参数-json格式")
    private String eventParams;

    @ApiModelProperty(value = "更新时间")
    private LocalDateTime updateTime;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "版本号和乐观锁字段,初始为1，更新自增1")
    @Version
    private Integer rowVersion;


    public static final String ID = "id";

    public static final String APP_ID = "app_id";

    public static final String ACCOUNT_ID = "account_id";

    public static final String EVENT_TYPE = "event_type";

    public static final String EVENT_PARAMS = "event_params";

    public static final String UPDATE_TIME = "update_time";

    public static final String CREATE_TIME = "create_time";

    public static final String ROW_VERSION = "row_version";

    public static final String EVENT_TYPE_REMARK = "事件类型,0-注册,1-登入,2-登出,3-修改密码";

}
