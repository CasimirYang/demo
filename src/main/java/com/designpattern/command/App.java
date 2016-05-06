package com.designpattern.command;

/**
 * Created by casimiryang on 2016/4/8.
 */
public class App {

    enum Button{
        BUTTON1,BUTTON2,BUTTON3;
    }

    public static void main(String args[]){
        Controller controller = new Controller();
        controller.addControll(Button.BUTTON1,new Light());
        controller.addControll(Button.BUTTON2,new Refrigerator());

        controller.onClick(Button.BUTTON2);
    }
}
