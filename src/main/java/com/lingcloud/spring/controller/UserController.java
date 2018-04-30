package com.lingcloud.spring.controller;

import com.lingcloud.spring.model.ex.EXServerModel;
import com.lingcloud.spring.model.re.REBaseModel;
import com.lingcloud.spring.model.rt.RTUserLoginModel;
import com.lingcloud.spring.model.ui.UIUserModel;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {

    @PostMapping("/login")
    public @ResponseBody REBaseModel login(@RequestBody @Valid RTUserLoginModel userLoginModel){
        REBaseModel baseModel = new REBaseModel();
        try {
            String[] a = {"1"};
            String see = a[2];
        }catch (Exception e){
            baseModel.setSuccess(false);
            return baseModel;
        }

        if (userLoginModel.getPassword().equals("123456")) {
            baseModel.setSuccess(true);
            baseModel.setData(new UIUserModel(userLoginModel.getAccount(),userLoginModel.getPassword()));
        }else {
            baseModel.setSuccess(false);
            baseModel.setData(new EXServerModel(EXServerModel.CodeEnum.ErrorPassword));
        }
        return baseModel;
    }
}
