package com.lingcloud.spring;

import com.lingcloud.spring.model.re.BaseREModel;
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
    BaseREModel validateErrorHandler(Exception e) {
        BaseREModel res = new BaseREModel();
        res.setSuccess(false);
        res.setData(e);
        return res;
    }
}
