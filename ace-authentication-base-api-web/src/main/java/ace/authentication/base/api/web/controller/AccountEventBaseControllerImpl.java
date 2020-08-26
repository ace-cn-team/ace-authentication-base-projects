package ace.authentication.base.api.web.controller;

import ace.authentication.base.api.web.dao.AccountEventDbService;
import ace.authentication.base.define.dao.model.entity.AccountEvent;
import ace.fw.logic.common.aop.Interceptor.log.annotations.LogAspect;
import ace.fw.restful.base.api.web.AbstractRestfulController;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Caspar
 * @contract 279397942@qq.com
 * @create 2020/1/17 15:21
 * @description
 */
@RestController
@LogAspect
public class AccountEventBaseControllerImpl
        extends AbstractRestfulController<AccountEvent, AccountEventDbService>
        implements AccountEventBaseController {

}
