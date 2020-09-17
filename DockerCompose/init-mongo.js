db.createUser(
	{
		user: "najoh2907",
		pwd: "Prueba123@",
		roles: [
			{
				role: "readWrite",
				db: "AREP-DOCKER-01"
			}
		]
	}
)