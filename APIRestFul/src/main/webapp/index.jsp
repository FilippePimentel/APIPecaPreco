<html>
<head>
<TITLE>API PEÇA PREÇO</TITLE>
</head>
<body bgcolor="FFFFFF">
<H1>API PEÇA PREÇO</H1>

<H2>http://localhost:8080/APIRestFul/rest</H2>

<H3><B> /cliente  ------ Métodos abaixo ------- </B></H3>
<I>-> /cadastrar(Cliente) 					- POST	- Retorna String  		- Sucesso ou Falha</I>
<BR> <I>-> /listarTodos(Sem parâmetros) 	- GET	- Retorna List(Cliente)</I>
<BR> <I>-> /buscarPorNome(String nome)		- GET	- Retorna Cliente  		- Falha -> Null</I>
<BR> <I>-> /buscarPorID(Int id)				- GET	- Retorna Cliente 		- Falha -> Null</I>
<BR> <I>-> /excluir(JSON id)				- POST	- Retorna String  		- Sucesso ou Falha</I>
<BR> <I>-> /atualizar(JSON Carro)			- POST	- Retorna String  		- Sucesso ou Falha</I>
<BR> <I>-> /login(JSON usuario e senha)		- POST	- Retorna Boolean  		- True ou False</I>
  
<BR>

<H3><B> /carro  ------ Métodos abaixo ------- </B></H3>
<I>-> /cadastrar(Carro) 					- POST	- Retorna String  		- Sucesso ou Falha</I>
<BR> <I>-> /listarTodos(Sem parâmetros) 	- GET	- Retorna List(Carro)</I>
<BR> <I>-> /buscarPelaPlaca(String placa)	- GET	- Retorna Carro  		- Falha -> Null</I>
<BR> <I>-> /buscarPorID(Int id)				- GET	- Retorna Carro 		- Falha -> Null</I>
<BR> <I>-> /buscarPeloModelo(String modelo)	- GET	- Retorna Carro  		- Falha -> Null</I>
<BR> <I>-> /excluir(JSON id)				- POST	- Retorna String  		- Sucesso ou Falha</I>
<BR> <I>-> /atualizar(JSON Cliente)			- POST	- Retorna String  		- Sucesso ou Falha</I>

</body>
</html>
