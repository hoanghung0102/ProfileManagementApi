package com.hoanghung.profilemanage.config;

import lombok.Data;

@Data
public class JsonResponse {
    private long timestamp;
    private String status;
    private String message;
}
