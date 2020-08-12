package ace.authentication.base.api;

import ace.authentication.base.define.constant.AuthenticationConstants;
import ace.authentication.base.define.model.request.ExistsByUserNameRequest;
import ace.authentication.base.define.model.request.ExistsByMobileRequest;
import ace.authentication.base.define.model.request.RegisterRequest;
import ace.fw.model.response.GenericResponseExt;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

/**
 * @author Caspar
 * @contract 279397942@qq.com
 * @create 2020/1/14 12:29
 * @description 登陆注册接口
 */
@FeignClient(
        name = AuthenticationConstants.BASE_FEIGN_CLIENT_NAME,
        contextId = "IdentityBaseApi",
        path = "/" + IdentityBaseApi.MODULE_RESTFUL_NAME
)
@Validated
public interface IdentityBaseApi {
    String MODULE_RESTFUL_NAME = "identity-base";

    @ApiOperation(value = "是否存在该手机号码")
    @RequestMapping(path = "/exists-by-mobile", method = RequestMethod.POST)
    GenericResponseExt<Boolean> existsByMobile(@Valid @RequestBody ExistsByMobileRequest request);

    @ApiOperation(value = "是否存在该账号")
    @RequestMapping(path = "/exists-by-username", method = RequestMethod.POST)
    GenericResponseExt<Boolean> existsByUserName(@Valid @RequestBody ExistsByUserNameRequest request);

    @ApiOperation(value = "注册账号")
    @RequestMapping(path = "/register", method = RequestMethod.POST)
    GenericResponseExt<Boolean> register(@Valid @RequestBody RegisterRequest request);
}
