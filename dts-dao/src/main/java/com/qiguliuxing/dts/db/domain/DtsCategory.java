package com.qiguliuxing.dts.db.domain;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Data
public class DtsCategory {

    private String  id;

    private String name;

    private LocalDateTime addTime;

    private LocalDateTime updateTime;
}