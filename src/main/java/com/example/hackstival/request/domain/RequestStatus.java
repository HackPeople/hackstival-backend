package com.example.hackstival.request.domain;


/** 요청상태
 * REQUEST : 노인 요청 중
 * ACCEPTED : 도우미 수락
 * CONFIRMED : 노인 수락
 * CANCLE : 수락 이후 거절
 * EXPIRE : 도움이 필요한 시간이 만료됨
 * */
public enum RequestStatus {
    REQUEST, ACCEPTED, CONFIRMED, CANCLE, EXPIRE;

    public boolean isDecided(){
       return this == CONFIRMED || this == CANCLE || this == EXPIRE;
    }

}
