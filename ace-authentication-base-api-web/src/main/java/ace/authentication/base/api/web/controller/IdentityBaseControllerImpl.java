package ace.authentication.base.api.web.controller;


import ace.authentication.base.api.web.dao.AccountEventDbService;
import ace.authentication.base.api.web.dao.AccountDbService;
import ace.authentication.base.define.dao.model.entity.Account;
import ace.authentication.base.define.model.request.ExistsByUserNameRequest;
import ace.authentication.base.define.model.request.ExistsByMobileRequest;
import ace.authentication.base.define.model.request.RegisterRequest;
import ace.fw.logic.common.aop.Interceptor.handler.annotations.ThrowableHandlerAspect;
import ace.fw.logic.common.aop.Interceptor.log.annotations.LogAspect;
import ace.fw.model.response.GenericResponseExt;
import ace.fw.util.AceEnumUtils;
import ace.fw.util.GenericResponseExtUtils;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author Caspar
 * @contract 279397942@qq.com
 * @create 2020/1/17 15:21
 * @description
 */
@RestController
@Slf4j
@LogAspect
public class IdentityBaseControllerImpl implements IdentityBaseController {
    @Autowired
    private AccountDbService accountDbService;
    @Autowired
    private AccountEventDbService accountEventDbService;

    @Override
    public GenericResponseExt<Boolean> existsByMobile(@Valid ExistsByMobileRequest request) {

        LambdaQueryChainWrapper<Account> queryChainWrapper = accountDbService
                .lambdaQuery()
                .select(Account::getId)
                .eq(Account::getAppId, request.getAppId())
                .eq(Account::getMobile, request.getMobile());

        Account account = queryChainWrapper.one();

        return GenericResponseExtUtils.buildSuccessWithData(account != null && StringUtils.isNotBlank(account.getId()));
    }

    @Override
    public GenericResponseExt<Boolean> existsByUserName(@Valid ExistsByUserNameRequest request) {
        LambdaQueryChainWrapper<Account> queryChainWrapper = accountDbService
                .lambdaQuery()
                .select(Account::getId)
                .eq(Account::getAppId, request.getAppId())
                .eq(Account::getUserName, request.getUserName());

        Account account = queryChainWrapper.one();

        return GenericResponseExtUtils.buildSuccessWithData(account != null && StringUtils.isNotBlank(account.getId()));

    }

    @Transactional(rollbackFor = {Throwable.class})
    @Override
    public GenericResponseExt<Boolean> register(@Valid RegisterRequest request) {
        accountDbService.save(request.getAccount());
        accountEventDbService.save(request.getAccountEvent());
        return GenericResponseExtUtils.buildSuccessWithData(true);
    }

    @ApiOperation(value = "测试")
    @RequestMapping(path = "/test", method = RequestMethod.GET)
    public GenericResponseExt<Boolean> test() {
        log.info("111");
        return GenericResponseExtUtils.buildSuccessWithData(true);
    }
}
