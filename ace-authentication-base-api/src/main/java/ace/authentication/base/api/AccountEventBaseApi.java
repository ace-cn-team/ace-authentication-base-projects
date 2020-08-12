package ace.authentication.base.api;

import ace.authentication.base.define.constant.AuthenticationConstants;
import ace.authentication.base.define.dao.model.entity.AccountEvent;
import ace.fw.restful.base.api.service.AbstractRestfulBaseService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.validation.annotation.Validated;

/**
 * @author Caspar
 * @contract 279397942@qq.com
 * @create 2020/1/14 12:29
 * @description
 */
@FeignClient(
        name = AuthenticationConstants.BASE_FEIGN_CLIENT_NAME,
        contextId = "AccountEventBaseApi",
        path = "/" + AccountEventBaseApi.MODULE_RESTFUL_NAME
)
@Validated
public interface AccountEventBaseApi extends AbstractRestfulBaseService<AccountEvent> {
    String MODULE_RESTFUL_NAME = "account-event-base";

}
