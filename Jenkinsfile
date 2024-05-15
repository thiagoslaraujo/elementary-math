pipeline {
	agent any

	stages {
		stage("Build Docker Image") {
			steps {
				sh "echo 'Construção da imagem'"
				dockerapp = docker.build("thiagoslaraujo/elementary-math-core:latest", '-f Dockerfile')
			}
		}

		stage("Push Docker Image") {
			steps {
				sh "echo 'Envio da imagem'"
			}
		}

		stage("Deploy no Kubernetes") {
			steps {
				sh "echo 'Deploy no Kubernetes'"
			}
		}
	}
}