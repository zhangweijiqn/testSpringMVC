package com.zwj.DAO;

import com.zwj.Beans.Person;

import java.util.List;

/**
 * Created by Administrator on 2016/1/5 0005.
 */
public interface PersonDAO {
    List<Person> getPersonByName_JdbcTemplate(String Name);
    List<Person> getPersonByName_Mybatis(String name);
}
