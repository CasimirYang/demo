package com.designpattern.Template;

import org.junit.Test;

/**
 * Created by yjh on 16/10/7.
 */
public class GameTest {

    @Test
    public void test(){
        Game game = new Dota();
        game.play();
        game = new Lol();
        game.play();
    }
}
