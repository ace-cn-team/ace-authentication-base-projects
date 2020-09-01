package ace.authentication.base.define.constant;

/**
 * @author Caspar
 * @contract 279397942@qq.com
 * @create 2020/1/19 17:37
 * @description
 */
public interface AuthenticationConstants {
    /**
     * openfeign扫描微服务api的包路径
     */
    String FEIGN_CLIENT_SERVICE_PACKAGE = "ace.authentication.base.api";
    /**
     * base层微服务openfeign配置名称
     */
    String BASE_FEIGN_CLIENT_NAME = "${ace.ms.service.api.ace-authentication-base-api.name:ace-authentication-base-api-web}";
    /**
     * base层微服务openfeign配置URL
     */
    String BASE_FEIGN_URL_CLIENT_NAME = "${ace.ms.service.api.ace-authentication-base-api.url:http://localhost:8080}";
    /**
     * authentication-base-api是否开启openfeign注入
     */
    String CONFIG_KEY_AUTHENTICATION_IDENTITY_BASE_API_ENABLE = "ace.ms.service.ace-authentication-base-api-web.enable";

}
