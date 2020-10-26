package Cab.Invoice.Generator;

public class InvoiceGenerator {
	private static final int COST_PER_TIME = 1;
	private static final double MINIMUM_COST_PER_KILOMETER = 10;
	private static final double MINIMUM_FARE = 5;

	/**
	 * UC 1 : returns total fare
	 * 
	 * @param distance
	 * @param time
	 * @return
	 */
	public double calculateFare(double distance, int time) {
		double totalfare = distance * MINIMUM_COST_PER_KILOMETER + time * COST_PER_TIME;
		if (totalfare < MINIMUM_FARE) {
			return MINIMUM_FARE;
		}
		return totalfare;
	}

	/**
	 * UC2 : calculates total fare of multiple rides
	 * 
	 * @param rides
	 * @return
	 */
	public double calculateFare(Ride[] rides) {
		double totalFare = 0;
		for (Ride ride : rides) {
			totalFare += this.calculateFare(ride.distance, ride.time);
		}
		return totalFare;
	}
}
