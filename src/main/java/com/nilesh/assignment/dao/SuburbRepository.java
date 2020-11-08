package com.nilesh.assignment.dao;

import com.nilesh.assignment.model.Suburb;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SuburbRepository extends CrudRepository<Suburb, Long> {

    public Suburb findByPostcodes(String pincode);
    public Suburb findByName(String name);
}
