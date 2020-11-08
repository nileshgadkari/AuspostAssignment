package com.nilesh.seekjob.assignment.controller.params;

import lombok.Data;

@Data
public class QuerySuburbParam implements Param{
    private String name;
    private String postcode;
}
