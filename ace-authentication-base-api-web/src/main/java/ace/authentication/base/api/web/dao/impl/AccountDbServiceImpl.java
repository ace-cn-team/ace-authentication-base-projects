package ace.authentication.base.api.web.dao.impl;


import ace.authentication.base.api.web.dao.AccountDbService;
import ace.authentication.base.api.web.dao.mapper.AccountMapper;
import ace.authentication.base.define.dao.model.entity.Account;
import ace.fw.restful.base.api.plugin.mybatisplus.impl.MybatisPlusDbServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 账号标识表 服务实现类
 * </p>
 *
 * @author Caspar 279397942@qq.com
 * @since 2020-01-02
 */
@Service
public class AccountDbServiceImpl
        extends MybatisPlusDbServiceImpl<Account, String, AccountMapper>
        implements AccountDbService {

}
