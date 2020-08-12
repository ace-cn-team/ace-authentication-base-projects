package ace.authentication.base.api.web.controller;

import ace.authentication.base.api.web.dao.AccountDbService;
import ace.authentication.base.define.dao.model.entity.Account;
import ace.authentication.base.define.model.request.FindByAppIdAndMobileRequest;
import ace.authentication.base.define.model.request.FindByAppIdAndUserNameRequest;
import ace.fw.model.response.GenericResponseExt;
import ace.fw.restful.base.api.web.AbstractRestfulController;
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
public class AccountBaseControllerImpl
        extends AbstractRestfulController<Account, AccountDbService>
        implements AccountBaseController {

    @Override
    public GenericResponseExt<Account> findByAppIdAndUserName(@Valid FindByAppIdAndUserNameRequest request) {
        Account account = this.getDbService().lambdaQuery()
                .eq(Account::getAppId, request.getAppId())
                .eq(Account::getUserName, request.getUserName())
                .eq(Account::getBizType, request.getBizType())
                .one();
        return GenericResponseExtUtils.buildSuccessWithData(account);
    }

    @Override
    public GenericResponseExt<Account> findByAppIdAndMobile(@Valid FindByAppIdAndMobileRequest request) {
        Account account = this.getDbService().lambdaQuery()
                .eq(Account::getAppId, request.getAppId())
                .eq(Account::getMobile, request.getMobile())
                .eq(Account::getBizType, request.getBizType())
                .one();
        return GenericResponseExtUtils.buildSuccessWithData(account);
    }
}
