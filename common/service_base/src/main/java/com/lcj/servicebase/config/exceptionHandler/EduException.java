package com.lcj.servicebase.config.exceptionHandler;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author：LCJ
 * @Description：
 * @Date：Create in 21:50 2021/2/2 0002
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EduException extends RuntimeException {

    @ApiModelProperty(value = "状态码")
    private Integer code;

    private String msg;

}
