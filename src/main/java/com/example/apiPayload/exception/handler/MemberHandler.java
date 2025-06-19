package com.example.apiPayload.exception.handler;

import com.example.apiPayload.BaseErrorCode;
import com.example.apiPayload.exception.GeneralException;

public class MemberHandler extends GeneralException {

    public MemberHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}