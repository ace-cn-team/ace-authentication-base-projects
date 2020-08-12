package ace.authentication.base.api.web.biz;

import ace.authentication.base.api.AccountBaseApi;
import ace.authentication.base.api.AccountEventBaseApi;
import ace.authentication.base.api.client.application.AccountIdentityClientJUnitBaseApplication;
import ace.authentication.base.api.IdentityBaseApi;
import ace.authentication.base.define.dao.enums.account.AccountRegisterSourceEnum;
import ace.authentication.base.define.dao.enums.accountevent.AccountEventEventTypeEnum;
import ace.authentication.base.define.dao.enums.account.AccountStateEnum;
import ace.authentication.base.define.dao.model.entity.AccountEvent;
import ace.authentication.base.define.dao.model.entity.Account;
import ace.authentication.base.define.enums.LoginSourceEnum;
import ace.authentication.base.define.model.request.*;
import ace.authentication.base.define.model.vo.LoginSuccessEventLogParams;
import ace.authentication.base.define.model.vo.RegisterSuccessEventLogParams;
import ace.fw.json.JsonUtils;
import ace.fw.logic.common.util.AceUUIDUtils;
import ace.fw.util.AceLocalDateTimeUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Caspar
 * @contract 279397942@qq.com
 * @create 2020/6/28 14:32
 * @description
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = AccountIdentityClientJUnitBaseApplication.class)
public class CheckAllBizTest {

    private final static String TEST_MOBILE = "15099975787";
    @Autowired
    private IdentityBaseApi identityBaseApi;
    @Autowired
    private AccountBaseApi accountBaseApi;
    @Autowired
    private AccountEventBaseApi accountEventBaseApi;

    @Test
    public void testAllBiz() {
        Account registerByUserNameAccount = this.testRegisterUserName();
        log.info("testRegisterUserName success");

        this.testExistsByUserName(registerByUserNameAccount);
        log.info("testExistsByUserName success");

        this.testFindByAppIdAndUserName(registerByUserNameAccount);
        log.info("testFindByAppIdAndUserName success");

        this.testSaveLoginEvent(registerByUserNameAccount);
        log.info("testSaveLoginEvent success");

        Account registerByMobileAccount = this.testRegisterMobile();
        log.info("testRegisterMobile success");

        this.testFindByAppIdAndMobile(registerByMobileAccount);
        log.info("testFindByAppIdAndMobile success");

        this.testExistsByMobile(registerByMobileAccount);
        log.info("testExistsByMobile success");

    }

    private void testSaveLoginEvent(Account account) {
        LoginSuccessEventLogParams eventParams = LoginSuccessEventLogParams.builder()
                .accountId(account.getId())
                .appId(account.getAppId())
                .loginTime(LocalDateTime.now())
                .ip("127.0.0.1")
                .loginSource(LoginSourceEnum.PC.getCode())
                .build();

        AccountEvent accountEvent = AccountEvent
                .builder()
                .id(AceUUIDUtils.generateTimeUUIDShort32())
                .rowVersion(1)
                .eventType(AccountEventEventTypeEnum.LOGIN.getCode())
                .updateTime(LocalDateTime.now())
                .createTime(LocalDateTime.now())
                .appId(account.getAppId())
                .accountId(account.getId())
                .eventParams(JsonUtils.toJson(eventParams))
                .build();

        accountEventBaseApi.save(accountEvent);
    }

    private void testFindByAppIdAndMobile(Account registerByMobileAccount) {
        Account account = accountBaseApi.findByAppIdAndMobile(FindByAppIdAndMobileRequest.builder()
                .appId(registerByMobileAccount.getAppId())
                .mobile(registerByMobileAccount.getMobile())
                .build()).check();
        if (account == null) {
            throw new RuntimeException("[accountBaseApi][findByAppIdAndMobile]测试不通过");
        }
    }

    private void testFindByAppIdAndUserName(Account account) {
        Account preAccount = accountBaseApi.findByAppIdAndUserName(FindByAppIdAndUserNameRequest.builder()
                .appId(account.getAppId())
                .userName(account.getUserName())
                .build()).check();
        if (preAccount == null) {
            throw new RuntimeException("[accountBaseApi][findByAppIdAndUserName]测试不通过");
        }
    }

    private void testExistsByMobile(Account account) {
        Boolean isExist = identityBaseApi.existsByMobile(ExistsByMobileRequest.builder()
                .appId(account.getAppId())
                .mobile(account.getMobile())
                .build())
                .check();
        if (Boolean.FALSE.equals(isExist)) {
            throw new RuntimeException("验证[identityBaseApi][existsByMobile]失败,注册账号不存在");
        }
    }

    private void testExistsByUserName(Account account) {
        Boolean isExist = identityBaseApi.existsByUserName(ExistsByUserNameRequest.builder()
                .appId(account.getAppId())
                .userName(account.getUserName())
                .build())
                .check();
        if (Boolean.FALSE.equals(isExist)) {
            throw new RuntimeException("验证[identityBaseApi][existsByUserName]失败,注册账号不存在");
        }
    }

    private Account testRegisterUserName() {
        Account account = Account.builder()
                .userName(AceUUIDUtils.generateTimeUUIDShort32())
                .password("123456")
                .appId(AceUUIDUtils.generateTimeUUIDShort32())
                .id(AceUUIDUtils.generateTimeUUIDShort32())
                .createTime(LocalDateTime.now())
                .passwordEncryptionFactor("123456")
                .rowVersion(1)
                .updateTime(LocalDateTime.now())
                .state(AccountStateEnum.ENABLE.getCode())
                .nickName(AceUUIDUtils.generateTimeUUIDShort32())
                .mobile(null)
                .expireTime(AceLocalDateTimeUtils.MAX_MYSQL)
                .email(null)
                .avatarUrl("")
                .registerSource(AccountRegisterSourceEnum.PC.getCode())
                .build();

        RegisterSuccessEventLogParams eventParams = RegisterSuccessEventLogParams.builder()
                .accountId(account.getId())
                .appId(account.getAppId())
                .registerTime(LocalDateTime.now())
                .registerSource(account.getRegisterSource())
                .ip("127.0.0.1")
                .build();

        AccountEvent accountEvent = AccountEvent.builder()
                .updateTime(account.getUpdateTime())
                .rowVersion(1)
                .id(AceUUIDUtils.generateTimeUUIDShort32())
                .eventType(AccountEventEventTypeEnum.REGISTER.getCode())
                .createTime(account.getCreateTime())
                .accountId(account.getId())
                .appId(account.getAppId())
                .eventParams(JsonUtils.toJson(eventParams))
                .build();


        RegisterRequest registerRequest = RegisterRequest.builder()
                .account(account)
                .accountEvent(accountEvent)
                .build();
        identityBaseApi.register(registerRequest);

        return account;
    }

    private Account testRegisterMobile() {
        Account account = Account.builder()

                .userName(null)
                .password("123456")
                .appId(AceUUIDUtils.generateTimeUUIDShort32())
                .id(AceUUIDUtils.generateTimeUUIDShort32())
                .createTime(LocalDateTime.now())
                .passwordEncryptionFactor("123456")
                .rowVersion(1)
                .updateTime(LocalDateTime.now())
                .state(AccountStateEnum.ENABLE.getCode())
                .nickName(AceUUIDUtils.generateTimeUUIDShort32())
                .mobile(TEST_MOBILE)
                .expireTime(AceLocalDateTimeUtils.MAX_MYSQL)
                .email(null)
                .avatarUrl("")
                .build();

        Map<String, Object> eventParamsMap = new HashMap<>();
        eventParamsMap.put("account", account);
        AccountEvent accountEvent = AccountEvent.builder()
                .updateTime(account.getUpdateTime())
                .rowVersion(1)
                .id(AceUUIDUtils.generateTimeUUIDShort32())
                .eventType(AccountEventEventTypeEnum.REGISTER.getCode())
                .createTime(account.getCreateTime())
                .accountId(account.getId())
                .appId(account.getAppId())
                .eventParams(JsonUtils.toJson(eventParamsMap))
                .build();

        RegisterRequest registerRequest = RegisterRequest.builder()
                .account(account)
                .accountEvent(accountEvent)
                .build();
        identityBaseApi.register(registerRequest);

        return account;
    }
}
