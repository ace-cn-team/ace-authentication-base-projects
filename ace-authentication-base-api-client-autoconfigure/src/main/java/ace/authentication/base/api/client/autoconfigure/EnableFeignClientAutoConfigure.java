package ace.authentication.base.api.client.autoconfigure;


import ace.authentication.base.api.web.controller.AccountBaseController;
import ace.authentication.base.define.constant.AuthenticationConstants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Caspar
 * @contract 279397942@qq.com
 * @create 2020/2/5 1:20
 * @description
 */
@ConditionalOnProperty(
        name = AuthenticationConstants.CONFIG_KEY_AUTHENTICATION_IDENTITY_BASE_API_ENABLE,
        havingValue = "true",
        matchIfMissing = true
)
@ConditionalOnMissingBean({AccountBaseController.class})
@ConditionalOnBean(annotation = {EnableFeignClients.class})
@EnableFeignClients(basePackages = {AuthenticationConstants.FEIGN_CLIENT_SERVICE_PACKAGE})
@Configuration
@Slf4j
public class EnableFeignClientAutoConfigure {

    @Bean
    public EnableFeignClientAutoConfigureInitializer enableFeignClientAutoConfigureInitializer() {
        log.info("EnableFeignClientAutoConfigure initial success");
        return new EnableFeignClientAutoConfigureInitializer();
    }

    class EnableFeignClientAutoConfigureInitializer {
    }
}
