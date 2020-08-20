package ace.authentication.base.api;

import ace.authentication.base.define.constant.AuthenticationConstants;
import ace.authentication.base.define.model.request.ExistsByMobileRequest;
import ace.authentication.base.define.model.request.ExistsByUserNameRequest;
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
 * @description 测试接口
 */
@FeignClient(
        name = AuthenticationConstants.BASE_FEIGN_CLIENT_NAME,
        contextId = "TestBaseApi",
        path = "/" + TestBaseApi.MODULE_RESTFUL_NAME
)
@Validated
public interface TestBaseApi {
    String MODULE_RESTFUL_NAME = "test-base";

    @ApiOperation(value = "测试")
    @RequestMapping(path = "/test", method = RequestMethod.POST)
    GenericResponseExt<Boolean> test();
}
