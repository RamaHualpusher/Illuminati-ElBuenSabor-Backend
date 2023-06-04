package com.illuminati.ebs.dto;

import lombok.Data;

import java.util.List;

@Data
public class UserAuthDto {
    private Long idUserAuth;
    private String user_id;
    private String email;
    private boolean blocked;
}