package com.akka;

import akka.actor.AbstractActor;
import akka.actor.Props;

public class Printer extends AbstractActor {
    static public Props props() {
        return Props.create(Printer.class, Printer::new);
    }

    static public class Greeting {
        public final String message;

        public Greeting(String message) {
            this.message = message;
        }
    }


    @Override
    public AbstractActor.Receive createReceive() {
        return receiveBuilder()
                .match(Greeting.class, greeting ->
                    System.out.println("Printer:"+greeting.message)
                )
                .build();
    }
}
