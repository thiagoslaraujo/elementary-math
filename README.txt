#Para criar o pacote maven
	- mvn package
	(*) verificar dentro da pasta /target se um novo arquivo foi gerado com a data/hora atual





#Para criar a imagem no mac
	- docker build -t elementary-math-core:1.0 . --platform="linux/amd64"
	




#Para criar a imagem para o DOCKER
	- docker tag elementary-math-core:1.0 elementary-math-core:latest
	
	- docker tag elementary-math-core thiagoslaraujo/elementary-math-core:1.0
	- docker tag elementary-math-core thiagoslaraujo/elementary-math-core:latest

#Para enviar a imagem para o DOCKER HUB
	- docker push thiagoslaraujo/elementary-math-core
	- docker push thiagoslaraujo/elementary-math-core:1.





#Para subir o cluster do Kind
	- kind create cluster --name k8s-elementary-math --config kind-config.yaml
	
#Para deleter o cluster
	- kind delete cluster --name k8s-elementary-math