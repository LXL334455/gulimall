package com.atguigu.gulimall.product.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author lirulong
 * @version V1.0
 * @program: gulimall
 * @Package com.atguigu.gulimall.product.config
 * @Description: TODO
 * @date 2023/4/4 17:01
 */
@Configuration
@MapperScan("com.atguigu.gulimall.product.dao")
public class MybatisPlusConfig {
    /**
     * 新的分页插件,一缓和二缓遵循mybatis的规则,需要设置 MybatisConfiguration#useDeprecatedExecutor = false 避免缓存出现问题(该属性会在旧插件移除后一同移除)
     */
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        PaginationInnerInterceptor innerInterceptor = new PaginationInnerInterceptor();
        innerInterceptor.setDbType(DbType.H2);
        innerInterceptor.setOverflow(true);
        innerInterceptor.setMaxLimit(500L);
        interceptor.addInnerInterceptor(innerInterceptor);
        return interceptor;
    }

}
