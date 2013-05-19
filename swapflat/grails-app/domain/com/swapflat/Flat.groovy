package com.swapflat

import com.swapflat.User

class Flat  {

	String city
	String zipCode
	String country
	String street
	String number
	int numberRooms
	int numberSleepingPlaces
	boolean hasInternet
	boolean isShared

	static belongsTo = [user: User]

	
	

}
