package ace.authentication.base.api.web.controller;


import ace.fw.logic.common.aop.Interceptor.log.annotations.LogAspect;
import ace.fw.model.response.GenericResponseExt;
import ace.fw.util.GenericResponseExtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Caspar
 * @contract 279397942@qq.com
 * @create 2020/1/17 15:21
 * @description
 */
@RestController
@Slf4j
@LogAspect
public class TestBaseControllerImpl implements TestBaseController {
    @Override
    public GenericResponseExt<Boolean> test() {
        log.info("111");
        return GenericResponseExtUtils.buildSuccessWithData(true);
    }
}
