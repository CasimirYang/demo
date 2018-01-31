package com.akka;

import akka.actor.*;
import akka.pattern.Patterns;
import akka.util.Timeout;
import scala.concurrent.Await;
import scala.concurrent.Future;
import scala.concurrent.duration.Duration;

import java.util.Optional;

/**
 * actor 方式解决哲学家进餐问题
 */
public class AkkaQuickstart {
    public static void main(String[] args) throws Exception {
        final ActorSystem system = ActorSystem.create("actorSys");
        final ActorRef prepareEatActor = system.actorOf(PrepareEatActor.props(), "first_actor");
        Timeout timeout = new Timeout(Duration.create(5, "seconds"));
        Future<Object> future = Patterns.ask(prepareEatActor, 1, timeout);
        Boolean result = (Boolean) Await.result(future, timeout.duration());
        if(result){
            System.out.println("start to eat.");
        }
    }

    public static class PrepareEatActor extends AbstractActor {
        Boolean[] chopsticksStatus = new Boolean[5]; //筷子状态 true:使用中
        static Props props() {
            return Props.create(PrepareEatActor.class, PrepareEatActor::new);
        }
        @Override
        public Receive createReceive() {
            return receiveBuilder().match(Integer.class,param-> {
                        int left;
                        int right;
                        if(param == 1){
                            left = 1;
                            right = chopsticksStatus.length;
                        }else {
                            left = chopsticksStatus.length;
                            right = chopsticksStatus.length+1;
                        }
                        if(Optional.ofNullable(chopsticksStatus[left-1]).orElse(false) ||
                                Optional.ofNullable(chopsticksStatus[right-1]).orElse(false)){
                            getSender().tell(false,getSelf()); //回复消息,还不能进食
                        }else{
                            chopsticksStatus[left-1]=true;
                            chopsticksStatus[right-1]=true;
                            getSender().tell(true,getSelf()); //回复消息，可以进食
                        }
                    }).build();
        }
    }
}
