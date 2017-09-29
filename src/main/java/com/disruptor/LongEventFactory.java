package com.disruptor;

import com.lmax.disruptor.EventFactory;

/**
 * Created by Lenovo on 2017/8/8.
 */
public class LongEventFactory implements EventFactory<LongEvent>
{
    @Override
    public LongEvent newInstance()
    {
        return new LongEvent();
    }
}