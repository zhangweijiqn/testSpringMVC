package com.zwj.Service;

import com.zwj.Beans.Person;
import com.zwj.DAO.PersonDAO;
import com.zwj.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2016/1/3 0003.
 */
// 使用jdk动态代理
@Service
public class PersonService {
    @Qualifier("personDAOImpl")
    @Autowired
    private PersonDAO personDAO;
    public void barA() {
        System.out.println("PersonService.barA()");
    }
    public String getPersonByJdbcTemplate(String name){
        List<Person> personList = personDAO.getPersonByName_JdbcTemplate(name);
        return personList.toString();
    }
    public String getPersonByMybatis(String name){
        List<Person> personList = personDAO.getPersonByName_Mybatis(name);
        return personList.toString();
    }
    public void fooA(String _msg) {
        System.out.println("PersonService.fooA(msg:" + _msg + ")");
    }


}
