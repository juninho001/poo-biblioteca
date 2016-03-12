#Criando um Sistema de Biblioteca Desktop Java
Projeto da disciplina de POO do curso de ADS no qual foi criado um Sistema de Biblioteca Desktop fazendo uso de vários recursos da linguagem Java Orientados a Objetos aprendidos em sala além da biblioteca SWING (javax.swing.JFrame; javax.swing.JOptionPane;) para recursos Visuais e bibliotecas de Leitura e escritas de arquivos (java.io.File; java.io.FileInputStream; java.io.FileOutputStream;) para recursos de CRUD (Create, Read, Update e Delete) de informações;
  
#Descrição do Projeto:
Cada grupo (2 componentes no máximo) deve desenvolver um software para umabiblioteca de uma universidade. O sistema será utilizado por um funcionário da biblioteca para realizar o cadastro de usuários, cadastro de livros, além de permitir a realização de empréstimos dos livros aos usuários. Devido à proximidade com o fim do semestre, nem todas as funcionalidades corriqueiras de um sistema para ser usado para uma biblioteca, como reservas, pagamento de multas, etc. devem ser implementadas. As funcionalidades esperadas para o sistema são as seguintes:

- RUD de livros
- CRUD de usuários
- Realizar Empréstimo
- Devolver Livros

As principais entidades manipuladas pelo sistema são descritas a seguir. Podem ser adicionados novos atributos que permita a realização das operações do sistema.

- Aluno: CPF, nome, endereço, telefone, email e curso
- Funcionário: CPF, matrícula, nome, endereço, telefone, email, cargo e setor
- Livro: ISBN, titulo, autor(es), editora, número de páginas, quantidade

#Lógica de funcionamento do sistema:
A lógica de funcionamento do sistema é a seguinte: O funcionário da biblioteca previamente cadastrado acessa o sistema, após isso são exibidas as funcionalidades: Cadastro de Livros, Cadastro de Usuários, Emprestar Livro e Devolver Livro. 

Caso o funcionário escolha Cadastro de Livros ou Cadastro de Usuários ele deve ser direcionado para formulários específicos para realizar o cadastro dessas entidades, bem como edições ou remoções. 

Caso o funcionário opte por emprestar livro, ele deve ser direcionado a uma tela, onde ele possa pesquisar por livros a partir do título ou ISBN. Após buscar o sistema deve indicar se o livro está disponível ou não. 

Caso esteja disponível ele pode optar por realizar empréstimo ao usuário e o sistema gera um comprovante informando o livro, o usuário e qual a data de entrega do mesmo. 

Se o funcionário optar por devolver livro, ele deverá ser direcionado para uma tela, onde seja possível pesquisar por empréstimos utilizando dados dos livros ou dos usuários, e então possa finalizar esse empréstimo.

#Regras para empréstimos:

- Um usuário fica bloqueado três dias para cada dia de atraso na devolução de um livro.
- Um usuário do tipo aluno tem um prazo de 10 dias para devolução do livro, já o funcionário tem um prazo de 15 dias
- Não é possível realizar empréstimo a usuários bloqueados.

#Detalhes da Implementação

- Utilizar os conceitos de POO estudados
- Dividir as responsabilidades das classes (não sobrecarregar as classes)
- Usar interface gráfica swing
- A persistência dos dados deve ser feito usando arquivos (obrigatório)
- Criar o JavaDoc do projeto
