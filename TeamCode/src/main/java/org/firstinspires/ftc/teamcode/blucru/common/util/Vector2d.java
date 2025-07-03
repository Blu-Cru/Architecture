package org.firstinspires.ftc.teamcode.blucru.common.util;

/**
 * This class is for 2d vectors. It is based off Roadrunner's Vector2d class
 * */

public class Vector2d {
    private double x, y;
    public Vector2d(double x, double y){
        this.x = x;
        this.y = y;

    }
    //angles will be close enough so we should not have to worry about long loop time
    private double normalize(double angle){
        return angle % (2 * Math.PI);
    }

    public double getHeading(){
        if (x != 0){
            //we can use tan
            if (x > 0){
                //in range of tan
                return normalize(Math.atan(y/x));
            } else {
                //will always be normalized
                return Math.atan(y/x) + 180;
            }

        } else{
            //angle is pi/2 or 3pi/2, based off y
            if (y != 0){
                if (y > 0){
                    return Math.PI/2;
                } else {
                    return 3 * Math.PI/2;
                }
            } else{
                //vector 0,0 will have heading of 0
                return 0;
            }
        }
    }

    public double getX(){
        return x;
    }
    public double getY(){
        return y;
    }

    /**
     * this function adds the 2 vectors together, changing the first vector
     * @return nothing
     * */
    public void addInPlace(Vector2d vec){
        x += vec.getX();
        y += vec.getY();

    }
    /**
     * this function adds the 2 vectors together and returns the sum
     * @return nothing
     * */
    public Vector2d addNotInPlace(Vector2d vec){
        return new Vector2d(getX() + vec.getX(), getY() + vec.getY());
    }

    /**
     * this function subtracts vector 1 - vector 2 together, changing the first vector
     * @return nothing
     * */
    public void subtractInPlace(Vector2d vector2){
        x -= vector2.getX();
        y -= vector2.getY();
    }

    /**
     * this function subtracts vector 1 - vector 2 together and returns the subtracted vector
     * @return nothing
     * */
    public Vector2d subtractNotInPlace(Vector2d vector2){
        return new Vector2d(getX() - vector2.getX(), getY() - vector2.getY());
    }

    public double getMag(){
        return Math.sqrt(Math.pow(x,2) + Math.pow(y,2));
    }

    public static Vector2d polarToCartesian(double r, double h){
        return new Vector2d(r * Math.cos(h), r * Math.sin(h));
    }
    /**
     * this function rotates a vector counter clockwise and returns it
     */
    public Vector2d rotate(double angle){
        double newX = getX() * Math.cos(angle) - getY() * Math.cos(angle);
        double newY = getX() * Math.sin(angle) + getY() * Math.cos(angle);
        return new Vector2d(newX, newY);
    }

    /**
     * this function rotates a vector counter clockwise, directly changing the vector
     */
    public void rotateInPlace(double angle){
        x = getX() * Math.cos(angle) - getY() * Math.cos(angle);
        y = getX() * Math.sin(angle) + getY() * Math.cos(angle);
    }
    public Pose2d pose(){
        return new Pose2d(this);
    }
    public void set(double x, double y){
        this.x = x;
        this.y = y;
    }
    public void set(double x){
        this.x = x;
    }
    public double dotProduct(Vector2d vec){
        return x * vec.getX() + y * vec.getY();
    }

}
