package com.example.easySchool.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Holiday extends  BaseEntity{

    private String day;
    private String reason;
    private Type type;

    public enum Type{
        FESTIVAL, FEDERAL
    }


}
