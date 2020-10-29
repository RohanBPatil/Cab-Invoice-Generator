package com.rohan.cabinvoicegenerator;

public class Ride {
	public int time;
	public double distance;
	public CabRide cabRide;

	public Ride(CabRide cabRide, double distance, int time) {
		this.time = time;
		this.distance = distance;
		this.cabRide = cabRide;
	}
}
