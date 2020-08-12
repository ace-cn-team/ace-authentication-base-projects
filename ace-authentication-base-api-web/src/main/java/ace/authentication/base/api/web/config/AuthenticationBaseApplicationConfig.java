package ace.authentication.base.api.web.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author Caspar
 * @contract 279397942@qq.com
 * @create 2020/1/14 15:57
 * @description
 */
@Configuration
@MapperScan("ace.authentication.base.api.web.dao.mapper")
public class AuthenticationBaseApplicationConfig {

}