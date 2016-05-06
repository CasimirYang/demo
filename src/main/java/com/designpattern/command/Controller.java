package com.designpattern.command;


import java.util.HashMap;
import java.util.Map;

public class Controller {

    Map<Enum,IControll> commands;


    public Controller() {
        this.commands = new HashMap();
    }

    public Controller addControll(Enum name, IControll control){  //可以更好扩展 添加新的控制器
        commands.put(name,control);
        return this;  //方便链式添加
    }

    void onClick(Enum name){
        if (commands.containsKey(name)) {
            commands.get(name).execute();
        }
    }

}
