package org.muxing.base.mapper;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import org.muxing.base.model.MxTest;

public class MxTestSqlProvider {

    public String insertSelective(MxTest record) {
        BEGIN();
        INSERT_INTO("mx_test");
        
        if (record.getId() != null) {
            VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getName() != null) {
            VALUES("name", "#{name,jdbcType=VARCHAR}");
        }
        
        if (record.getAge() != null) {
            VALUES("age", "#{age,jdbcType=INTEGER}");
        }
        
        return SQL();
    }

    public String updateByPrimaryKeySelective(MxTest record) {
        BEGIN();
        UPDATE("mx_test");
        
        if (record.getName() != null) {
            SET("name = #{name,jdbcType=VARCHAR}");
        }
        
        if (record.getAge() != null) {
            SET("age = #{age,jdbcType=INTEGER}");
        }
        
        WHERE("id = #{id,jdbcType=INTEGER}");
        
        return SQL();
    }
}