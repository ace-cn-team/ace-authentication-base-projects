package ace.authentication.base.api.web.biz;

import ace.authentication.base.api.AccountBaseApi;
import ace.authentication.base.api.IdentityBaseApi;
import ace.authentication.base.api.web.AuthenticationBaseApplication;
import ace.authentication.base.api.web.dao.AccountEventDbService;
import ace.authentication.base.define.dao.enums.account.AccountRegisterSourceEnum;
import ace.authentication.base.define.dao.enums.account.AccountStateEnum;
import ace.authentication.base.define.dao.enums.accountevent.AccountEventEventTypeEnum;
import ace.authentication.base.define.dao.model.entity.Account;
import ace.authentication.base.define.dao.model.entity.AccountEvent;
import ace.authentication.base.define.model.request.RegisterRequest;
import ace.fw.json.JsonUtils;
import ace.fw.logic.common.util.AceUUIDUtils;
import ace.fw.model.response.GenericResponseExt;
import ace.fw.util.AceLocalDateTimeUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.openfeign.EnableFeignClients;
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
@SpringBootTest(classes = AuthenticationBaseApplication.class, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@FixMethodOrder(value = MethodSorters.NAME_ASCENDING)
public class TestAllBiz {

    @Autowired
    private AccountBaseApi accountBaseApi;
    @Autowired
    private AccountEventDbService accountEventDbService;

    @Autowired
    private IdentityBaseApi identityBaseApi;

    @Test
    public void testBaseInsertBiz() {

        Account account = Account.builder()
                .id(AceUUIDUtils.generateTimeUUIDShort32())
                .appId(AceUUIDUtils.generateTimeUUIDShort32())
                .userName(AceUUIDUtils.generateTimeUUIDShort32())
                .password("123456")
                .passwordEncryptionFactor("123456")
                .createTime(LocalDateTime.now())
                .rowVersion(1)
                .updateTime(LocalDateTime.now())
                .avatarUrl("")
                .email(null)
                .expireTime(AceLocalDateTimeUtils.MAX_MYSQL)
                .mobile(null)
                .nickName("")
                .state(AccountStateEnum.ENABLE.getCode())
                .registerSource(AccountRegisterSourceEnum.PC.getCode())
                .build();
        GenericResponseExt<Boolean> saveResponse = accountBaseApi.save(account);
        saveResponse.check();

        Map<String, Object> eventParamsMap = new HashMap<>();
        eventParamsMap.put("accountIdentity", account);
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

        Boolean accountEventLogResponse = accountEventDbService.save(accountEvent);
    }

    @Test
    public void testRegisterBiz() {

        Account account = Account.builder()
                .id(AceUUIDUtils.generateTimeUUIDShort32())
                .appId(AceUUIDUtils.generateTimeUUIDShort32())
                .userName(AceUUIDUtils.generateTimeUUIDShort32())
                .password("123456")
                .passwordEncryptionFactor("123456")
                .createTime(LocalDateTime.now())
                .rowVersion(1)
                .updateTime(LocalDateTime.now())
                .avatarUrl("")
                .email(null)
                .expireTime(AceLocalDateTimeUtils.MAX_MYSQL)
                .mobile(null)
                .nickName("")
                .state(AccountStateEnum.ENABLE.getCode())
                .registerSource(AccountRegisterSourceEnum.PC.getCode())
                .build();


        Map<String, Object> eventParamsMap = new HashMap<>();
        eventParamsMap.put("accountIdentity", account);
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

        identityBaseApi.register(RegisterRequest.builder()
                .account(account)
                .accountEvent(accountEvent)
                .build());
    }

    @Test
    public void testAddAdminAccount() {
        Account account = Account.builder()
                .id(AceUUIDUtils.generateTimeUUIDShort32())
                .appId(AceUUIDUtils.generateTimeUUIDShort32())
                .email("279397942@qq.com")
                .mobile("15099975786")
                .userName("admin")
                .password("123456")
                .passwordEncryptionFactor("123456")
                .nickName("admin")
                .avatarUrl("")
                .state(AccountStateEnum.ENABLE.getCode())
                .expireTime(AceLocalDateTimeUtils.MAX_MYSQL)
                .updateTime(LocalDateTime.now())
                .createTime(LocalDateTime.now())
                .rowVersion(1)
                .registerSource(AccountRegisterSourceEnum.PC.getCode())
                .build();


        Map<String, Object> eventParamsMap = new HashMap<>();
        eventParamsMap.put("accountIdentity", account);
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

        identityBaseApi.register(RegisterRequest.builder()
                .account(account)
                .accountEvent(accountEvent)
                .build());
    }
}
