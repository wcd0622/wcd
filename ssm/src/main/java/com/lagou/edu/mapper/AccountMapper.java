package com.lagou.edu.mapper;

import com.lagou.edu.pojo.Account;

import java.util.List;

public interface AccountMapper {
    //定义dao层接口方法 -->查询account的所有数据
    List<Account> queryAccountList() throws Exception;

}
