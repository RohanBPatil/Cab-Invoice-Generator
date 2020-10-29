package com.rohan.cabinvoicegenerator;

public class InvoiceService {
	private RideRepository rideRepository;


	/**
	 * UC 2, 3 : calculates total fare of multiple rides and returning the invoice
	 * generated
	 * 
	 * @param rides
	 * @return
	 */
	public InvoiceSummary calculateFare(Ride[] rides) {
		double totalFare = 0;
		for (Ride ride : rides) {
			totalFare += ride.cabRide.calcCostOfCabRide(ride);
		}
		InvoiceSummary invoiceSummary = new InvoiceSummary(rides.length, totalFare);
		return invoiceSummary;
	}
	
	public InvoiceSummary getInvoiceSummary(String userId) {
		return this.calculateFare(rideRepository.getRides(userId));
	}
	
	public void setRideRepository(RideRepository rideRepository) {
		this.rideRepository = rideRepository;
	}
}
