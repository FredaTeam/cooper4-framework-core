package org.freda.cooper4.framework.core.dao;

import com.github.pagehelper.Page;
import org.freda.cooper4.framework.core.datastructure.Dto;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * 数据读取器<br>
 * 基于MyBatis实现,只有query权限,提供在Controller中使用
 *
 * Created by rally on 2016/12/4.
 */
public interface FredaReader
{
    /**
     * 查询一条记录
     *
     * @param  statementName SQL语句ID号
     * @param parameterObject
     *            查询条件对象(map javaBean)
     */
    Object queryForObject(String statementName, Object parameterObject);

    /**
     * 查询一条记录
     *
     * @param statementName SQL语句ID号
     */
    Object queryForObject(String statementName);

    /**
     * 查询记录集合
     *
     * @param  statementName SQL语句ID号
     * @param parameterObject
     *            查询条件对象(map javaBean)
     */
    List queryForList(String statementName, Object parameterObject);

    /**
     * 查询记录集合
     *
     * @param statementName SQL语句ID号
     */
    List queryForList(String statementName);

    /**
     * 按分页查询
     *
     * @param statementName SQL语句ID号
     * @param qDto
     *            查询条件对象(map javaBean)
     */
    Page queryForPage(String statementName, Dto qDto) throws SQLException;

    /**
     * 获取Connection对象<br>
     * 说明：虽然向Dao消费端暴露了获取Connection对象的方法但不建议直接获取Connection对象进行JDBC操作
     *
     * @return 返回Connection对象
     */
    Connection getConnection();
}
