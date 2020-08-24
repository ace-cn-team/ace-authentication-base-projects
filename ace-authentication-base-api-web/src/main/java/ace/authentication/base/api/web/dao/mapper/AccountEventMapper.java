package ace.authentication.base.api.web.dao.mapper;

import ace.authentication.base.define.dao.model.entity.AccountEvent;
import ace.fw.mybatis.plus.extension.mapper.AceBaseMapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 账号事件日志表 Mapper 接口
 * </p>
 *
 * @author Caspar 279397942@qq.com
 * @since 2020-06-28
 */
@Mapper
public interface AccountEventMapper extends AceBaseMapper<AccountEvent> {

}
