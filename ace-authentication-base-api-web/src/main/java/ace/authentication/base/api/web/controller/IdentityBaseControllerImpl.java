package ace.authentication.base.api.web.controller;


import ace.authentication.base.api.web.dao.AccountEventDbService;
import ace.authentication.base.api.web.dao.AccountDbService;
import ace.authentication.base.define.dao.model.entity.Account;
import ace.authentication.base.define.dao.enums.account.AccountBizTypeEnum;
import ace.authentication.base.define.model.request.ExistsByUserNameRequest;
import ace.authentication.base.define.model.request.ExistsByMobileRequest;
import ace.authentication.base.define.model.request.RegisterRequest;
import ace.fw.model.response.GenericResponseExt;
import ace.fw.util.AceEnumUtils;
import ace.fw.util.GenericResponseExtUtils;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author Caspar
 * @contract 279397942@qq.com
 * @create 2020/1/17 15:21
 * @description
 */
@RestController
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
                .eq(Account::getMobile, request.getMobile())
                .eq(Account::getBizType, request.getBizType());

        Account account = queryChainWrapper.one();

        return GenericResponseExtUtils.buildSuccessWithData(account != null && StringUtils.isNotBlank(account.getId()));
    }

    @Override
    public GenericResponseExt<Boolean> existsByUserName(@Valid ExistsByUserNameRequest request) {
        AccountBizTypeEnum accountBizTypeEnum = AceEnumUtils.getEnum(AccountBizTypeEnum.class, request.getBizType());
        LambdaQueryChainWrapper<Account> queryChainWrapper = accountDbService
                .lambdaQuery()
                .select(Account::getId)
                .eq(Account::getAppId, request.getAppId())
                .eq(Account::getUserName, request.getUserName())
                .eq(Account::getBizType, accountBizTypeEnum.getCode());

        Account account = queryChainWrapper.one();

        return GenericResponseExtUtils.buildSuccessWithData(account != null && StringUtils.isNotBlank(account.getId()));

    }

    @Transactional(rollbackFor = {Exception.class})
    @Override
    public GenericResponseExt<Boolean> register(@Valid RegisterRequest request) {
        accountDbService.save(request.getAccount());
        accountEventDbService.save(request.getAccountEvent());
        return GenericResponseExtUtils.buildSuccessWithData(true);
    }
}
