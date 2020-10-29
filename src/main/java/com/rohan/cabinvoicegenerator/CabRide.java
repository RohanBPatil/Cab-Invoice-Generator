package com.rohan.cabinvoicegenerator;

public enum CabRide {
	NORMAL(10, 1, 5), PREMIUM(15, 2, 20);
	
	private final double costPerKm;
	private final double costPerMin;
	private final double minCostPerRide;
	
	CabRide(double costPerKm, double costPerMin, double minCostPerRide) {
		this.costPerKm = costPerKm;
		this.costPerMin = costPerMin;
		this.minCostPerRide = minCostPerRide;
	}
	
	public double calcCostOfCabRide(Ride ride) {
		double rideCost = ride.distance * costPerKm + ride.time * costPerMin;
		return Math.max(rideCost, minCostPerRide);
	}
}
