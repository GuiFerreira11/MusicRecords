![capa-desafio-MusicRecords](https://github.com/user-attachments/assets/9629febc-2f7a-41a8-bf73-16c8e38a103b)


# Desafio Java - Salvando dados de Artistas e Músicas no banco de dados
![last commit](https://img.shields.io/github/last-commit/GuiFerreira11/MusicRecords) ![Java](https://img.shields.io/badge/Made_with-Java-orange?logo=data%3Aimage%2Fsvg%2Bxml%3Bbase64%2CPD94bWwgdmVyc2lvbj0iMS4wIiA%2FPjwhRE9DVFlQRSBzdmcgIFBVQkxJQyAnLS8vVzNDLy9EVEQgU1ZHIDEuMS8vRU4nICAnaHR0cDovL3d3dy53My5vcmcvR3JhcGhpY3MvU1ZHLzEuMS9EVEQvc3ZnMTEuZHRkJz48c3ZnIGhlaWdodD0iNTEycHgiIHN0eWxlPSJlbmFibGUtYmFja2dyb3VuZDpuZXcgMCAwIDUxMiA1MTI7IiB2ZXJzaW9uPSIxLjEiIHZpZXdCb3g9IjAgMCA1MTIgNTEyIiB3aWR0aD0iNTEycHgiIHhtbDpzcGFjZT0icHJlc2VydmUiIHhtbG5zPSJodHRwOi8vd3d3LnczLm9yZy8yMDAwL3N2ZyIgeG1sbnM6eGxpbms9Imh0dHA6Ly93d3cudzMub3JnLzE5OTkveGxpbmsiPjxnIGlkPSJfeDMxXzgxLWphdmEiPjxnPjxwYXRoIGQ9Ik0zMzMuMjgzLDMwNy4xMTdjOC44MDctNi4wMiwyMS4wMjMtMTEuMjMsMjEuMDIzLTExLjIzcy0zNC43NjgsNi4yOS02OS4zNTcsOS4xNjUgICAgYy00Mi4zMTUsMy41MDMtODcuNzc1LDQuMjIxLTExMC41OTUsMS4xNjdjLTUzLjk5Ni03LjE4NywyOS42NDctMjcuMDQ0LDI5LjY0Ny0yNy4wNDRzLTMyLjQzMy0yLjE1NC03Mi40MTMsMTcuMDcgICAgQzg0LjQyMiwzMTkuMDY2LDI0OC4zODMsMzI5LjQ4NywzMzMuMjgzLDMwNy4xMTd6IiBzdHlsZT0iZmlsbDojNTM4MkExOyIvPjxwYXRoIGQ9Ik0yNTYuNTYsMjc4LjI3N2MtMTcuMDctMzguMzYyLTc0LjY1OS03Mi4wNTQsMC0xMzAuOTlDMzQ5LjcyNyw3My43OTcsMzAxLjkzLDI2LDMwMS45MywyNiAgICBjMTkuMzE2LDc1LjkxNy02Ny45Miw5OC45MTctOTkuNDU2LDE0Ni4wODRDMTgxLjAwMSwyMDQuMzM3LDIxMi45ODYsMjM4LjkyNywyNTYuNTYsMjc4LjI3N3oiIHN0eWxlPSJmaWxsOiNGODk4MUQ7Ii8%2BPHBhdGggZD0iTTM1OS41MTgsMTE5Ljk3NWMwLjA5LDAtMTU3LjQwMywzOS4zNTEtODIuMjA1LDEyNS45NThjMjIuMTkxLDI1LjUxNi01Ljg0LDQ4LjUxNi01Ljg0LDQ4LjUxNiAgICBzNTYuMzMyLTI5LjEwOCwzMC40NTctNjUuNDk1QzI3Ny43NjIsMTk0Ljk5MywyNTkuMjU0LDE3OC4xMDMsMzU5LjUxOCwxMTkuOTc1eiIgc3R5bGU9ImZpbGw6I0Y4OTgxRDsiLz48cGF0aCBkPSJNMzU0LjAzOSwzNjIuOTk5Yy0wLjQ0OSwxLjA3OC0xLjc5NywyLjI0Ny0xLjc5NywyLjMzNiAgICBjMTE1LjI2Ni0zMC4yNzcsNzIuODYxLTEwNi44MjQsMTcuNzg3LTg3LjQxNmMtNC44NTIsMS43MDctNy4zNjUsNS42Ni03LjM2NSw1LjY2czMuMDUzLTEuMjU5LDkuODgzLTIuNjk2ICAgIEM0MDAuMzk2LDI3NS4wNDQsNDQwLjM3NywzMTguMTY4LDM1NC4wMzksMzYyLjk5OUwzNTQuMDM5LDM2Mi45OTl6IiBzdHlsZT0iZmlsbDojNTM4MkExOyIvPjxwYXRoIGQ9Ik0zOTYuNDQzLDQxOC45NzFjMCwwLDEzLjAyNywxMC42OTItMTQuMjg1LDE5LjA0N2MtNTIuMDE4LDE1LjcyMi0yMTYuMzM5LDIwLjQ4My0yNjEuOTc5LDAuNjMgICAgYy0xNi40NDEtNy4wOTksMTQuMzc0LTE3LjA3MiwyNC4wNzgtMTkuMTM3YzEwLjA2MS0yLjE1NywxNS45MDEtMS43OTksMTUuOTAxLTEuNzk5Yy0xOC4yMzgtMTIuODQ3LTExNy45NjMsMjUuMjQ3LTUwLjY3MSwzNi4xMTkgICAgQzI5Mi45NDUsNDgzLjY1Nyw0NDQuMDYxLDQ0MC40NDMsMzk2LjQ0Myw0MTguOTcxTDM5Ni40NDMsNDE4Ljk3MXoiIHN0eWxlPSJmaWxsOiM1MzgyQTE7Ii8%2BPHBhdGggZD0iTTE5NS41NTcsMzgxLjc3NmMtNzAuNzA2LDE5Ljc2Niw0My4wMzUsNjAuNTU1LDEzMy4wNTUsMjIuMDExICAgIGMtMTQuNzMyLTUuNzQ4LTI1LjMzNC0xMi4zOTctMjUuMzM0LTEyLjM5N2MtNDAuMTYsNy42MzctNTguNzU2LDguMTc1LTk1LjIzMyw0LjA0MyAgICBDMTc3Ljk0OCwzOTIuMDE5LDE5NS41NTcsMzgxLjc3NiwxOTUuNTU3LDM4MS43NzZMMTk1LjU1NywzODEuNzc2eiIgc3R5bGU9ImZpbGw6IzUzODJBMTsiLz48cGF0aCBkPSJNMzU3LjA5Miw0NjkuMTAzYy03MC43MDUsMTMuMjk2LTE1Ny45NDEsMTEuNzcxLTIwOS42MDIsMy4yMzNjMC0wLjA4OCwxMC42MDIsOC43MTYsNjUuMDQ2LDEyLjIyICAgIGM4Mi44MzQsNS4zMDIsMjEwLjA1MS0yLjk2NiwyMTMuMDE2LTQyLjEzNkM0MjUuNTUzLDQ0Mi40Miw0MTkuODAzLDQ1Ny4yNDUsMzU3LjA5Miw0NjkuMTAzTDM1Ny4wOTIsNDY5LjEwM3oiIHN0eWxlPSJmaWxsOiM1MzgyQTE7Ii8%2BPHBhdGggZD0iTTMxNy45MjIsMzQzLjE0NGMtNTMuMTg4LDEwLjI0My04NC4wMDMsOS45NzMtMTIyLjkwNCw1LjkzICAgIGMtMzAuMDk4LTMuMTQ1LTEwLjQyMi0xNy42OTgtMTAuNDIyLTE3LjY5OGMtNzcuOTgyLDI1Ljg3NCw0My4zMDQsNTUuMTY0LDE1Mi4yODEsMjMuMjY5ICAgIEMzMjUuMjg5LDM1MC42MDEsMzE3LjkyMiwzNDMuMTQ0LDMxNy45MjIsMzQzLjE0NHoiIHN0eWxlPSJmaWxsOiM1MzgyQTE7Ii8%2BPC9nPjwvZz48ZyBpZD0iTGF5ZXJfMSIvPjwvc3ZnPg%3D%3D) ![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)

Aplicação em java criada para salvar dados de artistas e bandas e suas música. Os dados dos artistas são obtidos com o Gemini, a IA do Google. 
O banco de dados escolhido para a presistência dos dados foi o PostgreSQL com a dependência do Spring Data JPA.

# 🛠️ Funcionalidades do Projeto
A aplicação foi desenvolvida para ser utilizado no terminal do seu computador.

`Cadastrar artista`: Basta digitar o nome do artista ou banda que deseja cadastrar que a aplicação irá fazer uma busca e trazer dados como Genero musical do artista e uma lista com o nome e ano de lançamento de cada álbum do artista, além de um pequeno texto a respeito do artista procurado;

`Cadastrar música`: Escolhendo um artista já cadastrado anteriormente, você pode selecionar um álbum desse artista e cadastrar suas músicas favoritas;

`Listar artistas`: Não sabe quais artistas já cadastrou no banco de dados, sem problema, com essa opção você tem acesso a uma lista com o nome dos artista e seu genero musical;

`Listar músicas`: Aqui você pode listar todas as músicas, de todos os artistas que já cadastrou;

`Buscar música por artista`: Se você quer apenas músicas de um artista, essa opção permite filtrar as músicas salvas no banco de dados somente para aquele seu artista do coração;

`Pesquisar dados sobre um artista`: Aqui você tem acesso a um pequeno texto gerado pelo Gemini descrevendo o artista escolhido, assim como seu genero musical e uma lista dos álbuns lançados por ele.

# ⚙️ Rodando o Projeto você mesmo
Depois de [baixar o projeto](https://github.com/GuiFerreira11/MusicRecords/archive/refs/heads/main.zip) e se certificar que instalou e configurou os seguintes programas: PostegreSQL, Java 17+ e Maven 4+, será necessário criar um banco de dados no PostgreSQL e possuir uma [API Key](https://aistudio.google.com/app/apikey) do Google Gemini. Algumas informações precisam ser armazenadas em um arquivo com o nome `.env` na raiz do projeto, essas informações são:

`API_KEY_GEMINI=`

`DB_HOST=`

`DB_NAME=`

`DB_USER=`

`DB_PASSWORD=`

Com tudo configurado, basta digitar o comando `mvn exec:java` no seu terminal para rodar a aplicação.
