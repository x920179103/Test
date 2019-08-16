package com.yc.blog.mapper;

import com.yc.blog.pojo.Flink;
import com.yc.blog.pojo.FlinkExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FlinkMapper {
    long countByExample(FlinkExample example);

    int deleteByExample(FlinkExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Flink record);

    int insertSelective(Flink record);

    List<Flink> selectByExample(FlinkExample example);

    Flink selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Flink record, @Param("example") FlinkExample example);

    int updateByExample(@Param("record") Flink record, @Param("example") FlinkExample example);

    int updateByPrimaryKeySelective(Flink record);

    int updateByPrimaryKey(Flink record);
}