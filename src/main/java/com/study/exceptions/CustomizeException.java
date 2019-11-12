package com.study.exceptions;

import com.study.enums.ResponseResultEnums;
import lombok.Data;

/**
 * @author lzr
 * @date 2019/11/11 0013 17:01
 */
@Data
public class CustomizeException extends RuntimeException{

    private String code;

    public CustomizeException(String message) {
        super(message);
    }

    public CustomizeException(String code, String message) {
        super(message);
        this.code = code;
    }

    public CustomizeException(ResponseResultEnums responseResultEnums){
        super(responseResultEnums.getMsg());
        this.code = responseResultEnums.getCode();
    }

}
