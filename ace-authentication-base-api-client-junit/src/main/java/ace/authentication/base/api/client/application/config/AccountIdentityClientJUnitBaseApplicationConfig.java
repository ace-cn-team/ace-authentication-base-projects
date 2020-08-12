package ace.authentication.base.api.client.application.config;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;

import java.util.List;

/**
 * @author Caspar
 * @contract 279397942@qq.com
 * @create 2020/1/14 15:57
 * @description
 */
@Configuration
public class AccountIdentityClientJUnitBaseApplicationConfig {
    @Autowired
    private List<HttpMessageConverter> httpMessageConverterList;
    @Autowired
    private ObjectFactory<HttpMessageConverters> messageConverters;

    @Bean
    public Integer aa() {
        return 1;
    }
}