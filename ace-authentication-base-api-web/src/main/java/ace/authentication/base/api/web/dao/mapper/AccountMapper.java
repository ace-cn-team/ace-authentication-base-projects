package ace.authentication.base.api.web.dao.mapper;

import ace.authentication.base.define.dao.model.entity.Account;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 账号标识表 Mapper 接口
 * </p>
 *
 * @author Caspar 279397942@qq.com
 * @since 2020-01-02
 */
@Mapper
public interface AccountMapper extends BaseMapper<Account> {

}
