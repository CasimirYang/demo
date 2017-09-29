package com.disruptor;

import com.lmax.disruptor.EventHandler;

/**
 * Created by Lenovo on 2017/8/8.
 */
public class LongEventHandler implements EventHandler<LongEvent>
{
    @Override
    public void onEvent(LongEvent event, long sequence, boolean endOfBatch)
    {
        System.out.println("Event: " + event);
    }
}