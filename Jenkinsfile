pipeline {
	agent any

	stages {
		stage("Build Docker Image") {
			steps {
				sh "echo 'Construção da imagem'"
				dockerImage = docker.build("elementary-math-core:v1")
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