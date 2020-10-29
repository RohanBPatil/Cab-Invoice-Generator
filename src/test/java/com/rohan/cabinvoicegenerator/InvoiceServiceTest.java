package com.rohan.cabinvoicegenerator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class InvoiceServiceTest {
	static InvoiceService invoiceService = null;
	static Ride[] rides = null;
	static RideRepository rideRepository = new RideRepository();
	static InvoiceSummary expectedInvoiceSummary = null;

	@BeforeAll
	public static void setUp() {
		invoiceService = new InvoiceService();
		rides = new Ride[] { new Ride(CabRide.NORMAL, 2.0, 5), new Ride(CabRide.PREMIUM, 0.1, 1) };
		expectedInvoiceSummary = new InvoiceSummary(2, 45);
	}

	@Test
	public void givenMultipleRides_shouldReturn_InvoiceSummary() {
		InvoiceSummary summary = invoiceService.calculateFare(rides);
		assertEquals(expectedInvoiceSummary, summary);
	}

	@Test
	public void givenUserIDAndRides_shouldReturn_InvoiceSummary() {
		String userId = "abc@xyz";
		rideRepository.addRides(userId, rides);
		invoiceService.setRideRepository(rideRepository);
		InvoiceSummary summary = invoiceService.getInvoiceSummary(userId);
		assertEquals(expectedInvoiceSummary, summary);
	}
}
