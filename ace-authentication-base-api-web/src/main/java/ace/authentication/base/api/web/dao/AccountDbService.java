package ace.authentication.base.api.web.dao;

import ace.authentication.base.define.dao.model.entity.Account;
import ace.fw.restful.base.api.plugin.DbService;
import ace.fw.restful.base.api.plugin.mybatisplus.MybatisPlusDbService;

/**
 * <p>
 * 账号标识表 服务类
 * </p>
 *
 * @author Caspar 279397942@qq.com
 * @since 2020-01-02
 */
public interface AccountDbService extends MybatisPlusDbService<Account,String> {

}
