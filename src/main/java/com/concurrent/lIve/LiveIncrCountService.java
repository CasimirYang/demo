package com.concurrent.lIve;

import org.springframework.stereotype.Service;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

@Service
public class LiveIncrCountService extends Thread{

    private volatile boolean executing = false;
  //  protected final Logger logger = Log.getLogger(this);
    private final long baseDelay = 20000L;

    private DelayQueue<LiveIncrCountDelayed> delayQueue = new DelayQueue<>();

    /**
     * 开启服务
     */
    public synchronized void startService() {
        if (executing) {
            return;
        } else {
         //   logger.info("start notification service");
            System.out.println("start service....");
            this.start();
            executing = true;
        }
    }

    /**
     * 关闭服务
     */
    public synchronized void stopService() {
        if (executing) {
            executing = false;
        }
    }

    public void addLive(long liveId){
        startService();
        delayQueue.put(new LiveIncrCountDelayed(baseDelay*1,1,liveId));
        delayQueue.put(new LiveIncrCountDelayed(baseDelay*2,2,liveId));
        delayQueue.put(new LiveIncrCountDelayed(baseDelay*3,3,liveId));
    }

    @Override
    public void run() {
        while (executing) {
            try {
                LiveIncrCountDelayed delayed = delayQueue.take();
                long liveId = delayed.getLiveId();
                int count = delayed.getCount();
                if(count == 1){
                    //+10

                }else if (count == 2 ){
                    //random + 1~10

                }else {
                    //random +- 1~10

                }
            } catch (InterruptedException e) {
                //todo
                e.printStackTrace();
            }

        }
    }
}

class LiveIncrCountDelayed implements Delayed{

    private long expireTime;
    private long liveId;
    private int count;

    public LiveIncrCountDelayed(long delay,int count,long liveId) {
        this.expireTime = delay+ System.currentTimeMillis();
        this.liveId = liveId;
        this.count = count;
    }

    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert(expireTime- System.currentTimeMillis(), TimeUnit.MILLISECONDS);
    }

    @Override
    public int compareTo(Delayed o) {
        LiveIncrCountDelayed that = (LiveIncrCountDelayed)o;
        if(this.expireTime > that.expireTime){//过期时刻越靠后，越排在队尾.
            return 1;
        }else if(this.expireTime==that.expireTime){
            return 0;
        }else{
            return -1;
        }
    }

    public long getLiveId() {
        return liveId;
    }

    public int getCount() {
        return count;
    }
}
