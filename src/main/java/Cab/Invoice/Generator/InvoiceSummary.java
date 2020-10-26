package Cab.Invoice.Generator;

public class InvoiceSummary {
	private double average;
	private double totalfare;
	private int numOfRides;

	public InvoiceSummary(int numOfRides, double totalFare) {
		this.numOfRides = numOfRides;
		this.totalfare = totalFare;
		this.average = numOfRides / totalFare;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		InvoiceSummary that = (InvoiceSummary) o;
		return numOfRides == that.numOfRides && Double.compare(that.totalfare, totalfare) == 0
				&& Double.compare(that.average, average) == 0;
	}
}
