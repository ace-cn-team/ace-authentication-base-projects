package ace.authentication.base.api.web.dao.impl;


import ace.authentication.base.api.web.dao.AccountEventDbService;
import ace.authentication.base.api.web.dao.mapper.AccountEventMapper;
import ace.authentication.base.define.dao.model.entity.AccountEvent;

import ace.fw.restful.base.api.plugin.mybatisplus.impl.MybatisPlusDbServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 账号事件日志表 服务实现类
 * </p>
 *
 * @author Caspar 279397942@qq.com
 * @since 2020-01-02
 */
@Service
public class AccountEventDbServiceImpl
        extends MybatisPlusDbServiceImpl<AccountEvent, String, AccountEventMapper>
        implements AccountEventDbService {

}
