<html>

<head>
	<title><g:message code="default.welcome.title" args="[meta(name:'app.name')]"/> </title>
	<meta name="layout" content="kickstart" />
</head>

<body>

	<section id="intro" class="first">

		<h1>Find your friends around the world!</h1>
		<form id='searchFriendsForm' class='form-horizontal' action='searchFriends' method='GET' autocomplete='off'>
			<fieldset class="form">
				<div class="control-group fieldcontain ${hasErrors(bean: _DemoPageInstance, field: 'name', 'error')} ">
					<label for='username' class="control-label"><g:message code="springSecurity.login.username.label"/>:</label>
					<div class="controls">
						<input type='text' class='span4' name='username' id='username'/>
					</div>
				</div>
			</fieldset>
			<div class="controls">
				<input type='submit' id="submit" class="btn btn-success" value='Search'/>
			</div>
		</form>
	</section>

	<section id="searchResult" class="first">
		<g:if test="${searchResult}">
			<g:each var="f" in="${searchResult}">
				${f}
			</g:each>
		</g:if>
		<g:else>
		  "No friends ...."
		</g:else>
	</section>

	<section id="searchFriends" class="first">

		<g:if test="${friendList}">
			<g:each  in="${resultFriends}">
				${resultFriend}
			</g:each>
		</g:if>
	</section>

</body>

</html>
