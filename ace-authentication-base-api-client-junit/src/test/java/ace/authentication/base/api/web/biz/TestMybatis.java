package ace.authentication.base.api.web.biz;

import ace.authentication.base.api.AccountBaseApi;
import ace.authentication.base.api.AccountEventBaseApi;
import ace.authentication.base.api.IdentityBaseApi;
import ace.authentication.base.api.client.application.AccountIdentityClientJUnitBaseApplication;
import ace.authentication.base.define.dao.enums.account.AccountRegisterSourceEnum;
import ace.authentication.base.define.dao.enums.account.AccountStateEnum;
import ace.authentication.base.define.dao.enums.accountevent.AccountEventEventTypeEnum;
import ace.authentication.base.define.dao.model.entity.Account;
import ace.authentication.base.define.dao.model.entity.AccountEvent;
import ace.authentication.base.define.enums.LoginSourceEnum;
import ace.authentication.base.define.model.request.*;
import ace.authentication.base.define.model.vo.LoginSuccessEventLogParams;
import ace.authentication.base.define.model.vo.RegisterSuccessEventLogParams;
import ace.fw.data.model.GenericCondition;
import ace.fw.data.model.RelationalOpConstVal;
import ace.fw.data.model.Sort;
import ace.fw.data.model.request.resful.PageQueryRequest;
import ace.fw.json.JsonUtils;
import ace.fw.logic.common.util.AceUUIDUtils;
import ace.fw.util.AceLocalDateTimeUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
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
@FixMethodOrder(value = MethodSorters.NAME_ASCENDING)
public class TestMybatis {

    private final static String TEST_MOBILE = "15099975787";
    @Autowired
    private IdentityBaseApi identityBaseApi;
    @Autowired
    private AccountBaseApi accountBaseApi;
    @Autowired
    private AccountEventBaseApi accountEventBaseApi;

    @Test
    public void test_0001_autoUpdateVersion() {
        Account accountDb = this.findAccountWithMobileFirst();
        Account modifyAccount = Account
                .builder()
                .id(accountDb.getId())
                .nickName(AceUUIDUtils.generateTimeUUIDShort32())
                .build();

        accountBaseApi.updateByIdVersionAutoUpdate(modifyAccount);

        Account accountDb2 = this.findAccountWithMobileFirst();

        Assert.assertTrue(accountDb.getRowVersion() != accountDb2.getRowVersion());
    }

    private Account findAccountWithMobileFirst() {
        List<GenericCondition<String>> conditions = Arrays.asList(GenericCondition.<String>builder()
                .field(Account.MOBILE)
                .relationalOp(RelationalOpConstVal.IS_NOT_NULL)
                .build()
        );
        List<Sort> sorts = Arrays.asList(Sort.builder()
                .field(Account.ID)
                .asc(true)
                .build());
        Account account = accountBaseApi.page(PageQueryRequest.builder()
                .pageSize(1)
                .pageIndex(1)
                .sorts(sorts)
                .conditions(conditions)
                .build()
        ).check().getData().get(0);
        return account;
    }
}
