package com.zwj.mapper;

import com.zwj.Beans.Person;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by zhangwj on 16-1-12.
 */
public interface UserMapper {
    @Select("SELECT * FROM person WHERE name = #{name}")
    List<Person> getUser(@Param("name") String name);
}
