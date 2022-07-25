package com.example.easy.school.repository;

import com.example.easy.school.models.Holiday;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HolidaysRepository   extends CrudRepository<Holiday,String> { // < which class needs to be make object of, Datatype of PrimaryKey column of POJO CLass>


}
