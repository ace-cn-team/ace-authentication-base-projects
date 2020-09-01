package ace.authentication.base.api;

import ace.authentication.base.define.constant.AuthenticationConstants;
import ace.authentication.base.define.dao.model.entity.Account;
import ace.authentication.base.define.model.request.FindByAppIdAndMobileRequest;
import ace.authentication.base.define.model.request.FindByAppIdAndUserNameRequest;
import ace.fw.model.response.GenericResponseExt;
import ace.fw.restful.base.api.AbstractBaseApi;
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
 * @description
 */
@FeignClient(
        name = AuthenticationConstants.BASE_FEIGN_CLIENT_NAME,
        url = AuthenticationConstants.BASE_FEIGN_URL_CLIENT_NAME,
        contextId = "AccountBaseApi",
        path = "/" + AccountBaseApi.MODULE_RESTFUL_NAME
)
@Validated
public interface AccountBaseApi extends AbstractBaseApi<Account, String> {
    String MODULE_RESTFUL_NAME = "account-identity-base";

    @ApiOperation(value = "根据appid与username查询惟一的账号")
    @RequestMapping(path = "/find-by-appid-and-username", method = RequestMethod.POST)
    GenericResponseExt<Account> findByAppIdAndUserName(@Valid @RequestBody FindByAppIdAndUserNameRequest request);

    @ApiOperation(value = "根据appid与mobile查询惟一的账号")
    @RequestMapping(path = "/find-by-appid-and-mobile", method = RequestMethod.POST)
    GenericResponseExt<Account> findByAppIdAndMobile(@Valid @RequestBody FindByAppIdAndMobileRequest request);

}
