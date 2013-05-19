import com.swapflat.User
import com.swapflat.SecUser
import grails.plugins.springsecurity.Secured;
import grails.converters.JSON


class FriendsController {

	def springSecurityService
	def currentUser

	def beforeInterceptor = {
    	println "Tracing action ${actionUri}"
    	currentUser = SecUser.get(springSecurityService.principal.id)
    	if (!currentUser)
    		redirect(controller:login) 

	}		

	@Secured(['ROLE_USER'])
	def index = {
		String view = 'friends'
		println currentUser.friends as JSON
		render (view:'friends', model : [friendList: (currentUser.friends)])
	}

	@Secured(['ROLE_USER'])
	def searchFriends = {
		def username = params?.username
		println username
		def searchResult = User.findAllByUsername(username)
		println (searchResult as JSON)
		if (searchResult)
			render (view:'friends', model : [searchResult: (searchResult)])
		else 
			render "Couldn't render your potential friend ... $username ? Are you sure ?"

	}
	

}