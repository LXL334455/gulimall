package com.atguigu.gulimall.product.vo;

import lombok.Data;

/**
 * @author lirulong
 * @version V1.0
 * @program: gulimall
 * @Package com.atguigu.gulimall.product.vo
 * @Description: TODO
 * @date 2023/4/5 17:21
 */
@Data
public class AttrRespVo extends AttrVo {
    private String catelogName;
    private String groupName;
    private Long[] catelogPath;
}
