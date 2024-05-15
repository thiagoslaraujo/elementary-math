pipeline {
	agent any

	stages {
		stage("Build Docker Image") {
			steps {
				sh "echo 'Construção da imagem'"
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