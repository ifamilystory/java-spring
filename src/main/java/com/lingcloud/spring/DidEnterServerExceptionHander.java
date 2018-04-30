package com.lingcloud.spring;

import com.lingcloud.spring.model.re.REBaseModel;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
@ResponseBody
public class DidEnterServerExceptionHander {
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    REBaseModel validateErrorHandler(Exception e) {
        REBaseModel res = new REBaseModel();
        res.setSuccess(false);
        res.setData(e);
        return res;
    }
}
