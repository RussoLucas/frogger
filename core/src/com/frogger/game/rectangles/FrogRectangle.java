package com.frogger.game.rectangles;

import java.awt.*;

import static com.frogger.game.enums.FrogsEnum.FROG_HEIGHT;
import static com.frogger.game.enums.FrogsEnum.FROG_WIDTH;
import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public class FrogRectangle {

    private Rectangle frog;
    private boolean touchFinishLine;


    public FrogRectangle(){
        frog = new Rectangle();
        frog.height = FROG_HEIGHT.getValue();
        frog.width = FROG_WIDTH.getValue();
        frog.x = 340;
        frog.y = 0;

        touchFinishLine = FALSE;
    }

    public Rectangle getFrog() {
        return frog;
    }

    public void updateFrogRectanglePositionToLeft(){
        frog.x = frog.x - 60;
    }

    public void updateFrogRectanglePositionToRight(){
        frog.x = frog.x + 60;
    }

    public void updateFrogRectanglePositionToUp(){
        frog.y = frog.y + 60;
    }

    public void updateFrogRectanglePositionToDown(){
        frog.y = frog.y - 60;
    }

    public void verifyFrogPosition(){
        if(frog.x <=0){
            frog.x = 0;
        }else if(frog.x > 650){
            frog.x = 650;
        }

        if(frog.y <= 0){
            frog.y = 0;
        }else if(frog.y > 660){
            frog.y = 660;
        }
    }
    public boolean isTouchFinishLine() {
        if(frog.y > 600){
            this.touchFinishLine = TRUE;
            return touchFinishLine;
        }
        this.touchFinishLine = FALSE;
        return touchFinishLine;
    }

    public void setTouchFinishLine(boolean touchFinishLine) {
        this.touchFinishLine = touchFinishLine;
    }

    public int getFrogRectangleX(){
        return frog.x;
    }

    public int getFrogRectangleY(){
        return frog.y;
    }

    public int setFrogRectangleX(int xPosition){
        return frog.x = xPosition;
    }

    public int setFrogRectangleY(int yPosition){
        return frog.y = yPosition;
    }

}
