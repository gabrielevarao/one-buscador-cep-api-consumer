<p align="center"> <b> <sup>ONE - Oracle Next Education | Alura | Formação Java e Orientação a Objetos</sup></b></p> 
<h1 align="center">EnViaCEP</h1>


Projeto de conclusão do curso <i>Java: consumindo API, gravando arquivos e lidando com erros</i>. Nesta aplicação, ao buscar um CEP, suas respectivas informações - como logradouro, bairro, cidade - são escritas em um arquivo JSON criado no ato da consulta. Para isso, foi consumida a <a href="https://viacep.com.br/">API ViaCEP</a>.

## 💡 Conhecimentos consolidados

- Consumo de uma API HTTP em Java.
- Como receber e converter dados no formato JSON. 
- Uso da biblioteca externa GSON para fazer serialização e desserialização de dados.
- Tratamento de exceções.
- Manipulação de arquivos com o pacote java.io.

## ⚠️ Exceções personalizadas
Há duas situações que retornam erro da API ViaCEP:
- Quando o CEP não está no formato correto (uma String composta exclusivamente de 8 números). Retorno: 400 (Bad Request).
- Quando o CEP não existe no banco de dados. Retorno: {erro: true}.

Para essas situações, foram tomadas três ações:
1. Primeiramente, são excluídos do CEP espaços, hífens e pontos.
2. Em seguida, antes da requisição, o formato do CEP é validado.
   - Se tiver menos ou mais de 8 dígitos ou se for um código alfanumérico, é lançada uma exceção com a mensagem "Formato inválido."
3. Assim que a resposta é recebida, o corpo é validado.
   - Caso seja retornado o valor <b>true</b> para <b>erro</b>, é lançada uma exceção com a mensagem "CEP não encontrado."
