package com.atguigu.common.constant;

/**
 * @author lirulong
 * @version V1.0
 * @program: gulimall
 * @Package com.atguigu.common.constant
 * @Description: TODO
 * @date 2023/4/5 18:45
 */
public class ProductConstant {
    public enum AttrEnum{
        ATTR_TYPE_BASE(1,"基本属性"),ATTR_TYPE_SALE(0,"销售属性");
        private int code;
        private String msg;
        AttrEnum(int code,String msg){
        this.code=code;
        this.msg=msg;
        }

        public int getCode() {
            return code;
        }

        public String getMsg() {
            return msg;
        }

    }
}
