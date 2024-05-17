pipeline {
	agent any

	stages {
		stage("Build Docker Image") {
			steps {
				script {
					dockerapp = docker.build("thiagoslaraujo/elementary-math-core:v1")
				}
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