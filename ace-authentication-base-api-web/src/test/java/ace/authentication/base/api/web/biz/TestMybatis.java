package ace.authentication.base.api.web.biz;

import ace.authentication.base.api.web.AuthenticationBaseApplication;
import ace.authentication.base.api.web.controller.AccountBaseController;
import ace.authentication.base.define.dao.model.entity.Account;
import ace.fw.data.model.GenericCondition;
import ace.fw.data.model.RelationalOpConstVal;
import ace.fw.data.model.Sort;
import ace.fw.data.model.request.resful.PageQueryRequest;
import ace.fw.data.model.request.resful.entity.EntityUpdateRequest;
import ace.fw.logic.common.util.AceUUIDUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

/**
 * @author Caspar
 * @contract 279397942@qq.com
 * @create 2020/6/28 14:32
 * @description
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = AuthenticationBaseApplication.class)
@FixMethodOrder(value = MethodSorters.NAME_ASCENDING)
public class TestMybatis {

    private final static String TEST_MOBILE = "15099975787";

    @Autowired
    private AccountBaseController accountBaseController;


    @Test
    public void test_0001_autoUpdateVersionByUpdateId() {
        Account accountDb = this.findAccountWithMobileFirst();
        Account modifyAccount = Account
                .builder()
                .id(accountDb.getId())
                .nickName(AceUUIDUtils.generateTimeUUIDShort32())
                .rowVersion(Integer.MIN_VALUE)
                .build();

        accountBaseController.updateByIdVersionAutoUpdate(modifyAccount);

        Account accountDb2 = this.findAccountWithMobileFirst();

        Assert.assertTrue(accountDb.getRowVersion() != accountDb2.getRowVersion());
    }

    @Test
    public void test_0002_autoUpdateVersionByUpdate() {
        Account accountDb = this.findAccountWithMobileFirst();
        Account modifyAccount = Account
                .builder()
                .id(accountDb.getId())
                .nickName(AceUUIDUtils.generateTimeUUIDShort32())
                .rowVersion(Integer.MIN_VALUE)
                .build();

        accountBaseController.updateByIdVersionAutoUpdate(modifyAccount);

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
        Account account = accountBaseController.page(PageQueryRequest.builder()
                .pageSize(1)
                .pageIndex(1)
                .sorts(sorts)
                .conditions(conditions)
                .build()
        ).check().getData().get(0);
        return account;
    }
}
