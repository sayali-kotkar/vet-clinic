package serenitylabs.tutorials.vetclinic.playingball.model;

/**
 * Created by siddharthk on 9/7/2016.
 */
public class PlayTennis implements PlayBall{
    @Override
    public Game play() {
        return Game.Tennis;
    }
}
