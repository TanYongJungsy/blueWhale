package com.mingx.enums;


public enum CodeEnum {
    SUCCESS(0),
    ERROR(1),
    WAIT(101), //等待
    NOREGISTER(411), //等待
    BUSINESS_FAILED(100); //业务异常报错

    private Integer code;
    CodeEnum(Integer code){
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
