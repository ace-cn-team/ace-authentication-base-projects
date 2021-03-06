package ace.authentication.base.api.web.dao;

import ace.authentication.base.define.dao.model.entity.AccountEvent;

import ace.fw.restful.base.api.plugin.DbService;
import ace.fw.restful.base.api.plugin.mybatisplus.MybatisPlusDbService;

/**
 * <p>
 * 账号事件日志表 服务类
 * </p>
 *
 * @author Caspar 279397942@qq.com
 * @since 2020-01-02
 */
public interface AccountEventDbService extends MybatisPlusDbService<AccountEvent, String> {

}
