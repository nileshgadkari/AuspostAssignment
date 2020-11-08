package com.nilesh.seekjob.assignment.validators;

import com.nilesh.seekjob.assignment.controller.params.QuerySuburbParam;
import com.nilesh.seekjob.assignment.util.StringUtil;
import org.springframework.stereotype.Component;

import java.util.function.Predicate;


@Component
public class QuerySuburbRequestValidator implements Validator<QuerySuburbParam> {
    @Override
    public boolean isValid(QuerySuburbParam param) {
        Predicate<QuerySuburbParam> eitherOfNameOrPostCodeIsProvided =
                p -> StringUtil.isNotBlank(p.getName()) || StringUtil.isNotBlank(p.getPostcode());
        return eitherOfNameOrPostCodeIsProvided.test(param);
    }

    @Override
    public boolean canValidate(Object param) {
        return param.getClass().equals(QuerySuburbParam.class);
    }

    @Override
    public String getErrorMessage(QuerySuburbParam param) {
        return "Either of name or postcode is required";
    }
}
