package com.lingcloud.spring;

import com.lingcloud.spring.model.ex.EXServerModel;
import com.lingcloud.spring.model.re.REBaseModel;
import org.springframework.boot.actuate.endpoint.invoke.MissingParametersException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@ControllerAdvice
@ResponseBody
public class WillEnterServerExceptionHander {
    @ExceptionHandler(BindException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public @ResponseBody REBaseModel validateErrorHandler(BindException e) {
        BindingResult bindingResult = e.getBindingResult();
        if (bindingResult.hasErrors()) {
            List<FieldError> errorList = bindingResult.getFieldErrors();
            String errorMsg = errorList.get(0).getField() + " 字段错误，错误原因:" + errorList.get(0).getDefaultMessage();
            REBaseModel res = new REBaseModel();
            EXServerModel serverErrorModel = new EXServerModel(HttpStatus.BAD_REQUEST.value(),errorMsg);
            res.setData(serverErrorModel);
            res.setSuccess(false);
            return res;
        } else {
            REBaseModel res = new REBaseModel();
            res.setSuccess(false);
            res.setData(e);
            return res;
        }
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public @ResponseBody REBaseModel validateHttpMessageNotReadableException(HttpMessageNotReadableException e) {
        REBaseModel res = new REBaseModel();
        EXServerModel serverErrorModel = new EXServerModel(HttpStatus.BAD_REQUEST.value(),e.getMessage());
        res.setData(serverErrorModel);
        res.setSuccess(false);
        return res;
    }

    @ExceptionHandler(MissingParametersException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public @ResponseBody REBaseModel validateMissingParametersException(MissingParametersException e) {
        REBaseModel res = new REBaseModel();
        EXServerModel serverErrorModel = new EXServerModel(HttpStatus.BAD_REQUEST.value(),e.getMessage());
        res.setData(serverErrorModel);
        res.setSuccess(false);
        return res;
    }


    @ExceptionHandler(value = Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public @ResponseBody REBaseModel errorHandler(HttpServletRequest request, Exception e) {
        REBaseModel res = new REBaseModel();
        EXServerModel serverErrorModel = new EXServerModel(HttpStatus.INTERNAL_SERVER_ERROR.value(),e.getMessage());
        res.setData(serverErrorModel);
        res.setSuccess(false);
        return res;
    }
}
