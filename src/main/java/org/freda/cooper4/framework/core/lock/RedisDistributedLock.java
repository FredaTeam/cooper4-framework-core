package org.freda.cooper4.framework.core.lock;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * Redis 分布式同步锁.用于异JVM的资源争抢问题.
 */
public class RedisDistributedLock implements Lock
{
    private static final Log log = LogFactory.getLog(RedisDistributedLock.class);

    private StringRedisTemplate redisTemplate;

    private String lock_key ;

    private static final String LOCKED = "LOCKED";

    private static final long TIME_OUT = 30000;

    private volatile boolean locked = false;


    public RedisDistributedLock(String lock , StringRedisTemplate redisTemplate)
    {
        this.lock_key = "_LOCK_" + lock.toUpperCase();

        this.redisTemplate = redisTemplate;
    }

    @Override
    public void lock()
    {
        try
        {
            final Random r = new Random();

            while (true)
            {
                if (tryLock())
                {
                    break;
                }
                Thread.sleep(3,r.nextInt(500));
            }
        }
        catch (Exception e)
        {
            throw new RuntimeException("lock failed!",e);
        }
    }

    @Override
    public void lockInterruptibly() throws InterruptedException
    {

    }

    @Override
    public boolean tryLock()
    {
        if (redisTemplate.getConnectionFactory().getConnection().setNX(lock_key.getBytes(),LOCKED.getBytes()))
        {
            redisTemplate.expire(lock_key,TIME_OUT, TimeUnit.MILLISECONDS);

            locked = true;

            log.debug("lock RedisLock[" + lock_key + "].");

            return true;
        }

        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException
    {
        long nano = System.nanoTime();

        try
        {
            final Random r = new Random();

            while ((System.nanoTime() - nano) < unit.toNanos(time))
            {
                if (tryLock())
                {
                    return true;
                }
                Thread.sleep(3,r.nextInt(500));
            }
        }
        catch (Exception e)
        {
            throw new RuntimeException("lock failed!",e);
        }


        return false;
    }

    @Override
    public void unlock()
    {
        if (locked)
        {
            log.debug("unlock RedisLock[" + lock_key + "].");

            redisTemplate.delete(lock_key);
        }
    }

    @Override
    public Condition newCondition()
    {
        return null;
    }
}
