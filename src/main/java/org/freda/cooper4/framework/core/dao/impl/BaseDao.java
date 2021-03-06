package org.freda.cooper4.framework.core.dao.impl;

import org.freda.cooper4.framework.core.dao.FredaDao;
import org.freda.cooper4.framework.core.datastructure.Dto;
import org.freda.cooper4.framework.core.exceptions.PrcException;

/**
 * 怎删改查数据库.
 *
 * Created by rally on 2016/12/4.
 */
public abstract class BaseDao extends BaseReader implements FredaDao
{
    /**
     * ADD
     * @param  statementName SQL语句ID号
     * @param parameterObject 要插入的对象(map javaBean)
     * @return int 影响行数
     */
    @Override
    public int insert(String statementName, Object parameterObject)
    {
        return super.getSqlSession().insert(statementName,parameterObject);
    }

    /**
     * ADD
     * @param statementName SQL语句ID号
     * @return int
     */
    @Override
    public int insert(String statementName)
    {
        return super.getSqlSession().insert(statementName);
    }

    /**
     *
     * EDIT
     *
     * @param statementName SQL语句ID号
     * @param parameterObject 更新对象(map javaBean)
     * @return int
     */
    @Override
    public int update(String statementName, Object parameterObject)
    {
        return super.getSqlSession().update(statementName, parameterObject);
    }

    /**
     *
     * @param statementName SQL语句ID号
     * @return int
     */
    @Override
    public int update(String statementName)
    {
        return super.getSqlSession().update(statementName);
    }

    /**
     *
     * @param statementName SQL语句ID号
     * @param parameterObject 更新对象(map javaBean)
     * @return int
     */
    @Override
    public int delete(String statementName, Object parameterObject)
    {
        return super.getSqlSession().delete(statementName, parameterObject);
    }

    /**
     *
     * @param statementName SQL语句ID号
     * @return int
     */
    @Override
    public int delete(String statementName)
    {
        return super.getSqlSession().delete(statementName);
    }

    /**
     *
     * @param prcName 存储过程ID号
     * @param prcDto  参数对象(入参、出参)
     * @return Object
     * @throws PrcException
     */
    @Override
    public Object callPrc(String prcName, Dto prcDto) throws PrcException
    {
        return super.getSqlSession().selectOne(prcName,prcDto);
    }
}
