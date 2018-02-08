package org.freda.cooper4.framework.core.sequence.generator.impl;

import org.freda.cooper4.framework.core.sequence.exception.SeqBaseException;
import org.freda.cooper4.framework.core.sequence.generator.*;

/**
 * 整体生成器.
 *
 * Created by rally on 2017/4/11.
 */
public class DefaultGenerator implements Generator
{
    /**
     * 前缀
     */
    protected Prefix prefix;
    /**
     * 格式化seq
     */
    protected Format format;
    /**
     * 增长序列
     */
    protected Sequence sequence;

    public DefaultGenerator()
    {
        this.prefix = new DefaultPrefix(false,null);

        this.format = new DefaultFormat();

        this.sequence = new DefaultSequence();
    }

    public DefaultGenerator(Prefix prefix, Format format, Sequence sequence)
    {
        this.prefix = prefix;

        this.format = format;

        this.sequence = sequence;
    }

    /**
     * 生成ID
     *
     * @param id
     * @return ID
     * @throws SeqBaseException
     */
    @Override
    public String create(String id) throws SeqBaseException
    {
        synchronized (id.intern())
        {
            Model model = sequence.next(id);

            if (model != null)
                return prefix.create(model) + format.format(model);

            return null;
        }
    }
}
