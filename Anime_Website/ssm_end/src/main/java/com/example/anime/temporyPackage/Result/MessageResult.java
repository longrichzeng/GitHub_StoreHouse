package com.example.anime.temporyPackage.Result;

public enum MessageResult {
    SUCCESS("登陆成功！"),
    FAIL("登录失败！"),
    UNAUTHORIZED("验证失败！"),
    NOT_FOUND("未找到相关信息！"),
    INTERNAL_SERVER_ERROR("内部服务器错误！");

    public String message;

    MessageResult(String message){
        this.message = message;
    }
}
