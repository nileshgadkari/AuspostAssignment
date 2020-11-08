package com.nilesh.seekjob.assignment.controller.params;

import lombok.Data;

import java.util.List;

@Data
public class CreateSuburbParam implements Param{
    private String name;
    private List<String> postcodes;
}
