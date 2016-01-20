package org.muxing.base.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;
import org.muxing.base.model.MxTest;
import org.springframework.stereotype.Repository;

@Repository
public interface MxTestMapper {
    @Delete({
        "delete from mx_test",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into mx_test (id, name, ",
        "age)",
        "values (#{id,jdbcType=INTEGER}, #{name,jdbcType=VARCHAR}, ",
        "#{age,jdbcType=INTEGER})"
    })
    int insert(MxTest record);

    @InsertProvider(type=MxTestSqlProvider.class, method="insertSelective")
    int insertSelective(MxTest record);

    @Select({
        "select",
        "id, name, age",
        "from mx_test",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="age", property="age", jdbcType=JdbcType.INTEGER)
    })
    MxTest selectByPrimaryKey(Integer id);

    @UpdateProvider(type=MxTestSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(MxTest record);

    @Update({
        "update mx_test",
        "set name = #{name,jdbcType=VARCHAR},",
          "age = #{age,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(MxTest record);
}