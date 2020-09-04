package com.navis.minefield.model;

/**
 * Class for represent a mine
 * @version 1.0, 09/03/2020
 * @author Keyban Arnoldo Martinez Payan
 */
public class Mine {
	//x coordinate
	private Float x;
	//y coordinate
	private Float y;
	//blast radius
	private Float r;
	
	// ******************************
	// Constructors
	// ******************************
	
	//non parameterized constructor
	public Mine() {
		super();
		// TODO Auto-generated constructor stub
	}

	 /** 
     * Parameterized constructor.
     * @param mineString String array which elements are x,y and r.
     */
	public Mine(String[] mineString) {
		super();
		//the first element in the array is assigned to the x property
		this.x = Float.parseFloat(mineString[0]);
		//the second element in the array is assigned to the y property
		this.y = Float.parseFloat(mineString[1]);
		//the third element in the array is assigned to the r property
		this.r = Float.parseFloat(mineString[2]);
	}

	// ******************************
	// getter and setters
	// ******************************
	
	 /** 
     * Getter for x parameter.
     * return the value of the x coordinate of a mine object
     * @return Float value of the x coordinate of a mine object.
     */
	public Float getX() {
		return x;
	}

	/** 
     * Setter for x parameter.
     * Set the value of the x coordinate of a mine object
     * @param x Float value of the x coordinate to set in the mine object.
     */
	public void setX(Float x) {
		this.x = x;
	}
	

	/** 
     * Getter for y parameter.
     * return the Float of the y coordinate of a mine object
     * @return Float value of the y coordinate of a mine object.
     */
	public Float getY() {
		return y;
	}

	/** 
     * Setter for y parameter.
     * Set the value of the y coordinate of a mine object
     * @param y Float value of the y coordinate to set in the mine object.
     */
	public void setY(Float y) {
		this.y = y;
	}

	/** 
     * Getter for r parameter.
     * return the value of the blast radius of a mine object
     * @return Float value of the blast radius of a mine object.
     */
	public Float getR() {
		return r;
	}

	/** 
     * Setter for r parameter.
     * Set the value of the blast radius of a mine object
     * @param r Float value of the blast radius to set in the mine object.
     */
	public void setR(Float r) {
		this.r = r;
	}
	
	// ******************************
	// string method
	// ******************************

	
	/** 
     * Method for represent the mine object in a string.
     * return the object representation in a string
     */
	@Override
	public String toString() {
		return "Mine [x=" + x + ", y=" + y + ", r=" + r + "]";
	}

	
}
