package com.microservice.accounts.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatusCode;

import java.util.Date;

@Data
@AllArgsConstructor
public class ErrorResponseDto {
    private String apiPath;
    private HttpStatusCode httpStatusCode;
    private String errorMessage;
    private Date errorTime;


}
