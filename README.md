# API de Coleta de DAdos das Automações do Toada Lab

## Release Notes:
* *1.0.0:* Estrutura inicial de coleta de informações do Clóvis e da Judith. Os dados coletados incluem quantidade de processos etiquetados, quantidade de processos lidos, quantidade de etiquetas inseridas, o tempo de trabalho do Clóvis ou da Judith, a data de execução e o Local Implantado onde o robô rodou.
* *1.0.1:* Correções na coleta de dados e nas rotas de acesso da API, permitindo requisições realizadas por todo o TJMA (inserção do Cros-Origin - CORS).
* *2.0.0:* Reestruturação das Entidades, Novas tabelas no banco para coleta de informações do robô Mário Lúcio; Corrções nas tabelas "Robôs", "Execuções Clóvis e Judith"; Inserção da entidade "Interações Usuário" para estimar quantidade de interações que o usuário humano teria ao realizar as tarefas dos robôs (quantidade de cliques e caracteres digitados).
* *2.1.0:* Reestruturação das Entidades "Robôs" e "Execuções Mário Lúcio", permitindo uma coleta de dados que facilitem o tratamento dos dados no Power Bi para geração de relatórios mais intuitivos para a alta gestão do TJMA; Inserção das colunas "Quantidade de Minutas inseridas" na entidade "Execuções Clóvis e Judith". 
* *2.2.0:* Inserção da Entidade "Processos Remetidos" para coleta da quantidade de processos remetidos ao segundo grau pelo robô da SEJUD.  
* *2.2.1:* Inserção das colunas "Quantidade Palavras Lidas" e "Quantidade d eCaracteres Lidos" na tabela "Interações Usuários".

### Notas:
* O projeto está usando o *Lombok*
* Para instalar o *Lombok*, siga os passos abaixo:
  
**Instalando o Lombok no Eclipse: **
* Na pasta do eclipse .me, repositório de dependencias baixadas pelo maven, onde o lombok foi baixado (C:\Users\seu_nome_de_usuario\.m2\repository\org\projectlombok\lombok\1.18.24), abra o CMD como Administrador;
* Digite: java -jar lombok-1.18.24.jar
* Na tela de instalação do lombok selecione specify location vá até a pasta do eclipse e selecione eclipse.ini.
* Na pasta do eclipse, abra o arquivo eclipse.init. No arquivo eclipse.ini digite no fim da lista -vmargs javaagent:C:\caminho-do-eclipse-na-sua-máquina\lombok.jar , salve a alteração.
* Dê um quit na tela de instalação do lombok.
  
## Do Projeto
A API foi contruída com o objetivo de coletar dados de funcionamento dos robôs para análises estatísticas de uso das automações do Tribunal de Justiça do Maranhão.
  
### Tecnologias Utilizadas
* Java 17 ou superior: a estrutura do projeto utiliza "records" para criação das DTOs, disponibilizadas no Java a partir da versão 17.
* Spring Boot (JPA, Postgres Driver)
* Database Relacional em Postgres


### Das Entidades Envolvidas
