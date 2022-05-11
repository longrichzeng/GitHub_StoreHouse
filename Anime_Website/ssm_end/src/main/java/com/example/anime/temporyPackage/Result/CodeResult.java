package com.example.anime.temporyPackage.Result;

public enum CodeResult {
    SUCCESS(302),
    FAIL(400),
    UNAUTHORIZED(401),
    NOT_FOUND(404),
    INTERNAL_SERVER_ERROR(500);

    public int code;

    CodeResult(int code){
        this.code = code;
    }
}
