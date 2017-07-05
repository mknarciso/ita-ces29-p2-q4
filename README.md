```
  /$$$$$$  /$$$$$$$$  /$$$$$$          /$$$$$$   /$$$$$$        /$$$$$$$   /$$$$$$ 
 /$$__  $$| $$_____/ /$$__  $$        /$$__  $$ /$$__  $$      | $$__  $$ /$$__  $$
| $$  \__/| $$      | $$  \__/       |__/  \ $$| $$  \ $$      | $$  \ $$|__/  \ $$
| $$      | $$$$$   |  $$$$$$  /$$$$$$ /$$$$$$/|  $$$$$$$      | $$$$$$$/  /$$$$$$/
| $$      | $$__/    \____  $$|______//$$____/  \____  $$      | $$____/  /$$____/ 
| $$    $$| $$       /$$  \ $$       | $$       /$$  \ $$      | $$      | $$      
|  $$$$$$/| $$$$$$$$|  $$$$$$/       | $$$$$$$$|  $$$$$$/      | $$      | $$$$$$$$
 \______/ |________/ \______/        |________/ \______/       |__/      |________/
```                                                                                
                                                                                                                                                            
Segunda Prova de CES-29 Engenharia de Software!
01/07/2017

## Questão 4

Refatore o projeto contido na QUESTÃO 2, de forma que o mesmo tenha ao menos 90% de cobertura de testes e não apresente nenhum problema de estilo (considerando como padrão o Google´ Style) (4.0 PONTOS). ATENTE PARA AS OBSERVAÇÕES:

OBS1 – Faça um clone do repositório onde você salvou o resultado da QUESTÃO 2 e construa um novo projeto (NÃO ATUALIZE O PROJETO CONSTRUÍDO NA QUESTÃO 2)

OBS2 – O Projeto deve ser um projeto Maven, onde todas as bibliotecas necessárias devem ser configuradas dentro do POM (a correção vai ser binária, caso o projeto não compile ao se rodar o POM).

OBS3 – Todos os plugins e ferramentas necessárias devem ser configuradas através do MAVEN, não devendo ser necessário a instalação manual de nenhuma ferramenta.

OBS4 – Todos os testes e verificações realizadas pelos plugins devem ser feitos automaticamente pelo MAVEN.

## Comentários

Foi gerado projeto Maven e remanufaturado de forma que fosse possível executar os testes unitários através do Maven.

Com relação ao check style: Foi executado através do Eclipse, conforme visto em aula, e através do Maven, com o comando: `mvn site`. O resultado, 0 erros, encontra-se em target/site/checkstyle.html

Com relação ao teste de cobertura, for verificada a existência do plugin JaCoCo, para execução total a partir do Maven, porém não foi possível configurar no tempo de prova. O teste foi feito com o Plug-in EclEmma, seguindo os mesmos passos vistos em aula:

![Alt text](cobertura.png?raw=true "Teste de Cobertura")