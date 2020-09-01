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
import org.junit.runners.Suite;
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
@RunWith(Suite.class)
@Suite.SuiteClasses({TestAllBiz.class, TestClientBaseApi.class})
public class TestSuite {


}
