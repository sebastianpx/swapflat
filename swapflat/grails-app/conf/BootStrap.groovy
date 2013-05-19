import com.swapflat.SecRole
import com.swapflat.SecUserSecRole
import com.swapflat.User
import com.swapflat.Flat




class BootStrap {

    def init = { servletContext ->
    	def userRole = SecRole.findByAuthority('ROLE_USER') ?: new SecRole(authority: 'ROLE_USER').save(failOnError: true)
		def adminRole = SecRole.findByAuthority('ROLE_ADMIN') ?: new SecRole(authority: 'ROLE_ADMIN').save(failOnError: true)

		User adminUser = User.findByUsername('admin') ?: new User(
				username: 'admin',
				password: 'admin',
				email: 'seb@piedoux.fr',
				firstName: 'Sebastian',
				lastName: 'Piedoux',
				
				enabled: true).save(failOnError: true)

		if (!adminUser.authorities.contains(adminRole)) {
			SecUserSecRole.create adminUser, adminRole
		}
		
		User normalUser = User.findByUsername('sebastian') ?: new User(
			username: 'sebastian',
			password: 'sebastian',
			email: 'seb@piedoux.fr',
			firstName: 'Sebastian',
			lastName: 'Piedoux',
			enabled: true).save(failOnError: true)

		if (!normalUser.authorities.contains(userRole)) {
			SecUserSecRole.create normalUser, userRole
		}

		Flat flat = new Flat(
			 city: 'Berlin',
			 zipCode: '10247',
			 country: 'Germany',
			 street: 'Karl Marx Str.',
			 number: '20',
			 numberRooms: 2,
			 numberSleepingPlaces: 2,
			 hasInternet: true,
			 isShared: false
		)

		normalUser.addToFlats(flat)

    }
    def destroy = {
    }
}
