package org.freda.cooper4.framework.core.dao;

import org.freda.cooper4.framework.core.datastructure.Dto;
import org.freda.cooper4.framework.core.exceptions.PrcException;

/**
 * Freda Dao操作DAO的层
 *
 * Created by rally on 2016/12/4.
 */
public interface FredaDao extends FredaReader
{
    /**
     * 插入一条记录
     * @param  statementName SQL语句ID号
     * @param parameterObject 要插入的对象(map javaBean)
     */
    int insert(String statementName, Object parameterObject);

    /**
     * 插入一条记录
     * @param statementName SQL语句ID号
     */
    int insert(String statementName);

    /**
     * 更新记录
     * @param statementName SQL语句ID号
     * @param parameterObject 更新对象(map javaBean)
     */
    int update(String statementName, Object parameterObject);

    /**
     * 更新记录
     * @param statementName SQL语句ID号
     */
    int update(String statementName);

    /**
     * 删除记录
     * @param statementName SQL语句ID号
     * @param parameterObject 更新对象(map javaBean)
     */
    int delete(String statementName, Object parameterObject);

    /**
     * 删除记录
     * @param statementName SQL语句ID号
     */
    int delete(String statementName);

    /**
     * 调用存储过程<br>
     * 存储过程成功返回标志缺省：appCode=1
     *
     * @param prcName 存储过程ID号
     * @param prcDto  参数对象(入参、出参)
     * @throws PrcException 存储过程调用异常
     */
    Object callPrc(String prcName, Dto prcDto) throws PrcException;
}
