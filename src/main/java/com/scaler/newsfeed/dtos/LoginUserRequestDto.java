package com.scaler.newsfeed.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class LoginUserRequestDto {
    String username;
    String password;
}
