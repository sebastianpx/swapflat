package com.swapflat

import com.swapflat.SecUser
import com.swapflat.Flat



class User extends SecUser {

	String firstName
	String lastName
	String email

	static hasMany = [flats: Flat, friends: User]



}
