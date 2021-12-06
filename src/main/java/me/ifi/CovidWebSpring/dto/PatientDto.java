package me.ifi.CovidWebSpring.dto;

import lombok.Data;

import java.util.Date;

@Data
public class PatientDto {
    private long id;
    private String name;
    private Date dateOfBirth;
    private String gender;
    private int age;
    private String address;
    private String status;
    private String area;
    private Date discoveredDate;
    private String avatar;
}
