package org.freda.cooper4.framework.core.sequence.generator;

import org.freda.cooper4.framework.core.sequence.exception.PrefixCreateException;

/**
 * Created by rally on 2017/4/11.
 */
public interface Prefix
{
    /**
     * 创建前缀
     * @return
     * @throws PrefixCreateException
     */
    String create(Model model) throws PrefixCreateException;
}
