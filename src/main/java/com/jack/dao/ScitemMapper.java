package com.jack.dao;

import com.jack.entity.Scitem;
import com.jack.entity.ScitemExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ScitemMapper {
    int countByExample(ScitemExample example);

    int deleteByExample(ScitemExample example);

    int deleteByPrimaryKey(String scitemid);

    int insert(Scitem record);

    int insertSelective(Scitem record);

    List<Scitem> selectByExample(ScitemExample example);

    Scitem selectByPrimaryKey(String scitemid);

    int updateByExampleSelective(@Param("record") Scitem record, @Param("example") ScitemExample example);

    int updateByExample(@Param("record") Scitem record, @Param("example") ScitemExample example);

    int updateByPrimaryKeySelective(Scitem record);

    int updateByPrimaryKey(Scitem record);
}