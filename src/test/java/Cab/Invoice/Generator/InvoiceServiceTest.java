package Cab.Invoice.Generator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class InvoiceServiceTest {
	static InvoiceGenerator invoiceGenerator = null;

	@BeforeAll
	public static void setUp() {
		invoiceGenerator = new InvoiceGenerator();
	}

	@Test
	void givenDistanceAndTime_shouldReturn_totalFare() {
		double distance = 2.0;
		int time = 5;
		double fare = invoiceGenerator.calculateFare(distance, time);
		assertEquals(25.0, fare, 0.0);
	}

	@Test
	public void givenLessDistanceOrTime_ShouldReturn_minFare() {
		double distance = 0.1;
		int time = 1;
		double fare = invoiceGenerator.calculateFare(distance, time);
		assertEquals(5.0, fare, 0.0);
	}

	@Test
	public void givenMultipleRides_shouldReturn_InvoiceSummary() {
		Ride[] rides = { new Ride(2.0, 5), new Ride(0.1, 1) };
		InvoiceSummary summary = invoiceGenerator.calculateFare(rides);
		InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 30);
		assertEquals(expectedInvoiceSummary, summary);
	}
}
