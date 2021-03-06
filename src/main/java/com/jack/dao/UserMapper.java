package com.jack.dao;

import com.jack.entity.User;
import com.jack.entity.UserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
	/**导出用户信息查询*/
	List<User> findAllObjects();
	/**根据用户名查用户*/
	User findByUsername(String username);
	/**根据用户名保存用户修改信息*/
	int doUpdateUser(User user);
	
    int countByExample(UserExample example);

    int deleteByExample(UserExample example);

    int deleteByPrimaryKey(String uid);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    User selectByPrimaryKey(String uid);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

	
	
}