package ace.authentication.base.define.dao.model.entity;

import ace.authentication.base.define.dao.enums.account.AccountRegisterSourceEnum;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.Version;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 账号标识表
 * </p>
 *
 * @author Caspar 279397942@qq.com
 * @since 2020-01-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "Account", description = "账号标识表")
public class Account implements Serializable {


    @ApiModelProperty(value = "id")
    @TableId(value = "id", type = IdType.NONE)
    private String id;

    @ApiModelProperty(value = "应用id")
    private String appId;

    @ApiModelProperty(value = "账号")
    private String userName;

    @ApiModelProperty(value = "电子邮箱")
    private String email;

    @ApiModelProperty(value = "手机号码")
    private String mobile;

    @ApiModelProperty(value = "昵称")
    private String nickName;

    @ApiModelProperty(value = "头像url")
    private String avatarUrl;
    /**
     * {@link AccountRegisterSourceEnum}
     */
    @ApiModelProperty(value = "注册来源")
    private String registerSource;

    @ApiModelProperty(value = STATE_REMARK)
    private Integer state;

    @ApiModelProperty(value = "密码")
    private String password;

    @ApiModelProperty(value = "加密因子")
    private String passwordEncryptionFactor;

    @ApiModelProperty(value = "过期时间")
    private LocalDateTime expireTime;

    @Version
    @ApiModelProperty(value = "更新时间")
    private LocalDateTime updateTime;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "版本号和乐观锁字段,初始为1，更新自增1")
    @Version
    private Integer rowVersion;


    public static final String ID = "id";

    public static final String APP_ID = "app_id";

    public static final String USER_NAME = "user_name";

    public static final String EMAIL = "email";

    public static final String MOBILE = "mobile";

    public static final String NICK_NAME = "nick_name";

    public static final String AVATAR_URL = "avatar_url";

    public static final String REGISTER_SOURCE = "register_source";

    public static final String STATE = "state";

    public static final String PASSWORD = "password";

    public static final String PASSWORD_ENCRYPTION_FACTOR = "password_encryption_factor";

    public static final String EXPIRE_TIME = "expire_time";

    public static final String UPDATE_TIME = "update_time";

    public static final String CREATE_TIME = "create_time";

    public static final String ROW_VERSION = "row_version";

    public static final String ACCOUNT_BIZ_TYPE_REMARK = "账号业务类型,platform-平台,user-客户,seller-商家";

    public static final String STATE_REMARK = "状态，0-停用，1-启用，2-锁定，3-过期，4-需修改密码";
}
