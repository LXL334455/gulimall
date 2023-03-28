package com.atguigu.gulimall.thirdparty.properties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author lirulong
 * @version V1.0
 * @program: gulimall
 * @Package com.atguigu.gulimall.thirdparty.properties
 * @Description: TODO
 * @date 2023/3/23 20:47
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
@ConfigurationProperties(prefix = "oss")
@EnableConfigurationProperties
public class QiNiuCloudProperties {
    private String accessKey;
    private String secretKey;
    private String bucket;
    private String hostName;
}
