package com.example.anime.temporyPackage.Result;

import java.util.ArrayList;
import java.util.List;

public class FactoryResult {
    /**
     * 成功后返回的响应
     * @param token
     * @return
     */
    public ResultDTO successResult(String token, String username, String userPermission){
        ResultDTO result = new ResultDTO();
        result.setCode(CodeResult.SUCCESS.code);
        result.setMessage(MessageResult.SUCCESS.message);
        result.setToken(token);
        result.setUsername(username);
        result.setUserPermission(userPermission);
        return result;
    }

    /**
     * 失败后返回的响应
     * @return
     */
    public ResultDTO failResult(){
        ResultDTO result = new ResultDTO();
        result.setCode(CodeResult.FAIL.code);
        result.setMessage(MessageResult.FAIL.message);
        return result;
    }

    /**
     * 其他响应
     * @return
     */
    public ResultDTO OtherResult(){
        ResultDTO result = new ResultDTO();
        result.setCode(CodeResult.SUCCESS.code);
        result.setMessage(MessageResult.SUCCESS.message);
        return result;
    }
}
