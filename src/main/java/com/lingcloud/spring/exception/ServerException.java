package com.lingcloud.spring.exception;

import com.lingcloud.spring.model.ex.EXServerModel;

public class ServerException extends RuntimeException {
    public EXServerModel getExServerModel() {
        return exServerModel;
    }

    public void setExServerModel(EXServerModel exServerModel) {
        this.exServerModel = exServerModel;
    }

    private EXServerModel exServerModel;

    public ServerException(){

    }

    public ServerException(EXServerModel exServerModel){
        this.exServerModel = exServerModel;
    }

}
