package org.freda.cooper4.framework.core.sequence.generator;

import org.freda.cooper4.framework.core.sequence.exception.StoreException;

/**
 * Created by rally on 2017/4/11.
 */
public interface Store
{
    /**
     * 更新.
     * @throws StoreException
     */
    int update(final Model model) throws StoreException;

    /**
     * 加载当前最大.
     * @param pSequenceId
     * @throws StoreException
     */
    Model load(final String pSequenceId) throws StoreException;
}
