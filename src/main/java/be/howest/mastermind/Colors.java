/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.howest.mastermind;

/**
 *
 * @author hayk
 */
public final class Colors {
    public final static int MIN = 0;
    public final static int RED = MIN;
    public final static int ORANGE = 1;
    public final static int YELLOW = 2;
    public final static int GREEN = 3;
    public final static int BLUE = 4;
    public final static int PURPLE = 5;
    public final static int PINK = 6;
    public final static int WHITE = 7;
    public final static int GREY = 8;
    public final static int MAX = 9;
    public final static int BLACK = MAX;
    
    private Colors() {}
    
    public static String getColorName(int colorId) {
        switch(colorId) {
            case RED:
                return "Red";
            case ORANGE:
                return "Orange";
            case YELLOW:
                return "Yellow";
            case GREEN:
                return "Green:";
            case BLUE:
                return "Blue";
            case PURPLE:
                return "Purple";
            case PINK:
                return "Pink";
            case WHITE:
                return "White";
            case GREY:
                return "Grey";
            case BLACK:
                return "Black";
        }
        return "Unknown";
    }
}
