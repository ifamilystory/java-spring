package com.lingcloud.spring.controller;

import com.lingcloud.spring.model.ex.ServerEXModel;
import com.lingcloud.spring.model.re.BaseREModel;
import com.lingcloud.spring.model.rt.UserLoginRTModel;
import com.lingcloud.spring.model.ui.UserUIModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/user")
public class UserController {

    @PostMapping("/login")
    public @ResponseBody
    BaseREModel login(@RequestBody @Valid UserLoginRTModel userLoginModel){
        BaseREModel baseModel = new BaseREModel();
//        try {
//            String[] a = {"1"};
//            String see = a[2];
//        }catch (Exception e){
//            baseModel.setSuccess(false);
//            return baseModel;
//        }

        if (userLoginModel.getPassword().equals("123456")) {
            baseModel.setSuccess(true);
            baseModel.setData(new UserUIModel(userLoginModel.getAccount(),userLoginModel.getPassword()));
        }else {
            baseModel.setSuccess(false);
            baseModel.setData(new ServerEXModel(ServerEXModel.CodeEnum.ErrorPassword));
        }
        return baseModel;
    }
}
