package com.atguigu.gulimall.product.exception;

import com.atguigu.common.exception.BizCodeEnume;
import com.atguigu.common.utils.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lirulong
 * @version V1.0
 * @program: gulimall
 * @Package com.atguigu.gulimall.product.exception
 * @Description: TODO
 * @date 2023/4/2 12:30
 */

@RestControllerAdvice(basePackages = "com.atguigu.gulimall.product.controller")
@Slf4j
public class GulimallExceptionController {

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public R handleVaildException(MethodArgumentNotValidException e){
        Map<String,String> errorMap =new HashMap<>();
        e.getBindingResult().getFieldErrors().forEach((item)-> errorMap.put(item.getField(),item.getDefaultMessage()));
        log.error("数据校验出现问题{},异常类型：{}",e.getMessage(),e.getClass());
        return R.error(BizCodeEnume.VAILD_EXCEPTION.getCode(),BizCodeEnume.VAILD_EXCEPTION.getMsg()).put("data",errorMap);
    }
    @ExceptionHandler(value = Throwable.class)
    public R handleException(Throwable t){
        log.error("错误：{}",t);
        return R.error(BizCodeEnume.UNKNOW_EXCEPTION.getCode(),BizCodeEnume.UNKNOW_EXCEPTION.getMsg());
    }
}
