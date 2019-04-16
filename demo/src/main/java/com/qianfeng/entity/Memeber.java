package com.qianfeng.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Memeber {
  private String memeberId;
  private String account;
  private String username;
  private String email;
  private String phone;
  private String recomUser;
  private Date registerTime;
  private String payAccount;
  private String name;
  private String password;
  private String visitCode;
  private long useRecom;
  private String levelCode;
  private long mid;
  private Date updateTime;
  private String passwordSalt;
}
