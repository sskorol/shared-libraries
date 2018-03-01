def hostIp(String name) {
    sh "docker-compose ps -q ${name} > container.id"
    def id = readFile('container.id').trim()
    sh "docker inspect -f {{.NetworkSettings.IPAddress}} ${id} > host.ip"
    readFile('host.ip').trim()
}

def fullNameOf(String partialName) {
	sh "docker ps --format {{.Names}} -f name=${partialName} > container.name"
    readFile('container.name').trim()
}

def adjustEnv(String projectName) {
	def workspace = "${WORKSPACE}".replace("\\", "/").replace(":", "")
	sh """echo BUILD_ID=${BUILD_ID} > .env
			echo WORK_DIR=/${workspace} >> .env
			echo COMPOSE_PROJECT_NAME=${projectName} >> .env"""
}
