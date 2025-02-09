package com.emart.app.bo;

import lombok.Data;

@Data
public class SessionBo {
    private String sessionId;
    private String sessionState;
    private String customerId;
}
