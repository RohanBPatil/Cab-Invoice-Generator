package Cab.Invoice.Generator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RideRepository {
	Map<String, ArrayList<Ride>> userRides;

	public RideRepository() {
		userRides = new HashMap<>();
	}
	
	public void addRides(String userId, Ride[] rides) {
		ArrayList<Ride> userRideList = userRides.get(userId);
		if(userRideList == null)
			userRides.put(userId, new ArrayList<>(Arrays.asList(rides)));
		else
			userRides.get(userId).addAll(Arrays.asList(rides));
	}
	
	public Ride[] getRides(String userId) {
		return userRides.get(userId).toArray(new Ride[0]);
	}
}
