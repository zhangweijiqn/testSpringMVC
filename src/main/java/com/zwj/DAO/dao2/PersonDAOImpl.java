package com.zwj.DAO.dao2;

import com.zwj.DAO.dao.PersonMapper;
import com.zwj.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import com.zwj.Beans.Person;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Administrator on 2016/1/5 0005.
 *
 */
@Repository
public class PersonDAOImpl implements PersonDAO {
    @Autowired
    @Qualifier("jdbcTemplate")
    private JdbcTemplate jdbcTemplate = null;

    //here needs to be injected autowired, we inject through xml configure
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Person> getPersonByName_JdbcTemplate(String Name) {
        String sql="select * from person where Name like ?";
//        Map<String,Object> params = new HashMap<String,Object>();
//        params.put("name",Name);
        return jdbcTemplate.query(sql, new Object[] {Name+"%"},new RowMapper<Person>() {
            public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
                Person person = new Person();
                person.setName(rs.getString("name"));
                person.setAge(Integer.parseInt((rs.getString("age"))));
                return person;
            }
        });
    }

    @Resource(name="userMapper")
//    这种方式调用的是Mybatis注解的方式
    private UserMapper userMapper;
    //使用spring集成mybatis方式
    public List<Person> getPersonByName_Mybatis(String name) {
        return this.userMapper.getUser(name);
    }

    @Autowired
    private PersonMapper personMapper;
    public List<com.zwj.DAO.domain.Person> getPersonById(String Id){
        return personMapper.selectById(Id);
    }

}
