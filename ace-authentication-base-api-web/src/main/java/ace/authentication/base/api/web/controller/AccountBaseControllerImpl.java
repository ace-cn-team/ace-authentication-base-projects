package ace.authentication.base.api.web.controller;

import ace.authentication.base.api.web.dao.AccountDbService;
import ace.authentication.base.define.dao.model.entity.Account;
import ace.authentication.base.define.model.request.FindByAppIdAndMobileRequest;
import ace.authentication.base.define.model.request.FindByAppIdAndUserNameRequest;
import ace.fw.logic.common.aop.Interceptor.log.annotations.LogAspect;
import ace.fw.model.response.GenericResponseExt;
import ace.fw.restful.base.api.web.AbstractController;
import ace.fw.restful.base.api.web.AbstractMybatisController;
import ace.fw.util.GenericResponseExtUtils;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author Caspar
 * @contract 279397942@qq.com
 * @create 2020/1/17 15:21
 * @description
 */
@RestController
@LogAspect
public class AccountBaseControllerImpl
        extends AbstractMybatisController<Account, String>
        implements AccountBaseController {

    @Override
    public GenericResponseExt<Account> findByAppIdAndUserName(@Valid FindByAppIdAndUserNameRequest request) {
        Account account = this.getDbService().lambdaQuery()
                .eq(Account::getAppId, request.getAppId())
                .eq(Account::getUserName, request.getUserName())
                .one();
        return GenericResponseExtUtils.buildSuccessWithData(account);
    }

    @Override
    public GenericResponseExt<Account> findByAppIdAndMobile(@Valid FindByAppIdAndMobileRequest request) {
        Account account = this.getDbService().lambdaQuery()
                .eq(Account::getAppId, request.getAppId())
                .eq(Account::getMobile, request.getMobile())
                .one();
        return GenericResponseExtUtils.buildSuccessWithData(account);
    }
}
