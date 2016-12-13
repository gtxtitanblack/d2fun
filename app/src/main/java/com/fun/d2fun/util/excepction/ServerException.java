package com.fun.d2fun.util.excepction;

/**
 * Created by ZX on 2016/11/15 0015.
 * 服务器错误的信息
 */

public class ServerException extends Exception {
    public ServerException(String errMessage) {
        super(errMessage);
    }
}
