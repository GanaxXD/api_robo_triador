# API de Coleta de DAdos das Automações do Toada Lab

### Notas:
* O projeto está usando o *Lombok*
* Para instalar o *Lombok*, siga os passos abaixo:
  
**Instalando o Lombok no Eclipse: **
* Na pasta do eclipse .me, repositório de dependencias baixadas pelo maven, onde o lombok foi baixado (C:\Users\seu_nome_de_usuario\.m2\repository\org\projectlombok\lombok\1.18.24), abra o CMD como Administrador;
* Digite: java -jar lombok-1.18.24.jar
* Na tela de instalação do lombok selecione specify location vá até a pasta do eclipse e selecione eclipse.ini.
* Na pasta do eclipse, abra o arquivo eclipse.init. No arquivo eclipse.ini digite no fim da lista -vmargs javaagent:C:\caminho-do-eclipse-na-sua-máquina\lombok.jar , salve a alteração.
* Dê um quit na tela de instalação do lombok.