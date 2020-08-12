package ace.authentication.base.api.web.controller;

import ace.authentication.base.api.IdentityBaseApi;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Caspar
 * @contract 279397942@qq.com
 * @create 2020/1/14 12:29
 * @description
 */
@RestController
@RequestMapping(path = "/" + IdentityBaseApi.MODULE_RESTFUL_NAME)
@Validated
public interface IdentityBaseController extends IdentityBaseApi {

}
