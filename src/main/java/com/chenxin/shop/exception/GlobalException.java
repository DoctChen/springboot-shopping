package com.chenxin.shop.exception;

import com.chenxin.shop.enums.BusinessExceptionEnum;
import com.chenxin.shop.enums.CustomExceptionEnum;
import lombok.Data;
/**
 * @Description:
 * @title: GlobalException
 * @Author Star_Chen
 * @Date: 2021/12/24 9:09
 * @Version 1.0
 */
@Data
public class GlobalException extends RuntimeException {

    private Integer code;

    private String msg;

    public GlobalException(Integer code, String msg){
        super(msg);
        this.code = code;
        this.msg = msg;
    }

    public GlobalException(CustomExceptionEnum customExceptionEnum){
        super(customExceptionEnum.getMsg());
        this.code = customExceptionEnum.getCode();
        this.msg = customExceptionEnum.getMsg();
    }

    public GlobalException(BusinessExceptionEnum businessExceptionEnum){
        super(businessExceptionEnum.getMessage());
        this.code = businessExceptionEnum.getCode();
        this.msg = businessExceptionEnum.getMessage();
    }

}
