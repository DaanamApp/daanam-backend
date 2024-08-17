package com.daanam.app.backend.dtos;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import java.time.LocalDateTime;

@Builder
public class ErrorMessageDto {
  private String type;
  private String code;
  private LocalDateTime timestamp;
  private String message;
  private Throwable cause;
}
