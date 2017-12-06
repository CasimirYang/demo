package com.concurrent;

import org.apache.http.annotation.GuardedBy;
import org.apache.http.annotation.ThreadSafe;

import java.util.Set;

@ThreadSafe
public class ServiceStatus {

    @GuardedBy("this")
    private final Set<String> users;
    @GuardedBy("this")
    private final Set<String> status;

    public ServiceStatus(Set<String> users, Set<String> status) {
        this.users = users;
        this.status = status;
    }

    public synchronized void addUser(String user){
        users.add(user);
    }



    public static void main(String[] args) {
        int y = 4 ^ 1 ;
        System.out.println(y);
    }

    public synchronized void addStatus(String stat){
        status.add(stat);
    }
}



