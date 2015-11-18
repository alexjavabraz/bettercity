<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
  <head>
    <title>Cotia Melhor aplicativo social</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, height=device-height, initial-scale=1, maximum-scale=1, user-scalable=no" />
    
    <meta name="description" content="O CotiaMelhor e uma plataforma para que o cidadao mostre os problemas da cidade, solicite melhorias, de sugestoes e concorra a premios. Solu&#231;&#227;o tecnológica para quest&#245;es de relevância p&#250;blica">
    <meta name="keywords" content="css4html, css+for+html, css 4 html, css4, css4 html, css, css3, html, html5" />

	<meta property="og:title" content="Faça sua cidade melhor, exerça a cidadania" />
	<meta property="og:type" content="website" />
	<meta property="og:url" content="http://www.cotiamelhor.com.br" />
	<meta property="og:site_name" content="CotiaMelhor" />
	<meta property="og:locale" content="pt_br" />
    <meta property="og:image" content="http://palloi.github.io/responsive-header-only-css/assets/images/image-shared.png" />
    <meta property="og:keywords" content="aplicativo social, cotiamelhor, melhorar minha cidade, " />
    <meta property="og:description" content="Mostre o que você quer melhorar no seu bairro, na sua cidade!" />
    
    <link href="assets/images/icos/favicon.ico" rel="shortcut icon">
	<link href="http://fonts.googleapis.com/css?family=Cookie|Open+Sans:400,700" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="assets/stylesheets/style.css" />
    <link rel="stylesheet" type="text/css" href="assets/stylesheets/footer.css" />
    
    <!--[if lt IE 9]>
			<script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
	<![endif]-->
    
    <script type="text/javascript" src="js/jquery/jquery-1.9.1.min.js"></script>
  </head>
  <body ng-app>
 	 <input id="pac-input" class="controls" type="text" placeholder="Search Box">
    <header>
      <h1 class="float-l">
        Melhorar minha cidade
      </h1>
      
      <input type="checkbox" id="control-nav" />
      <label for="control-nav" class="control-nav"></label>
      <label for="control-nav" class="control-nav-close"></label>

      <nav class="float-r">
        <ul class="list-auto">
          <li>
            <a href="#CotiaMelhor" title="Cidade Melhor, Cotia Melhor">O Cotia Melhor</a>
          </li>
          <li>
            <a href="#Cotia_Melhor_como_funciona" title="Como funciona o Cidade Melhor">Como funciona?</a>
          </li>
          <li>
            <a href="#Cotia_Melhor_Ja" title="Comece a melhorar a cidade Já">Melhore Cotia j&#225;</a>
          </li>
          <li>
            <a href="#mapaProblemas" title="Confira no mapa">Onde precisa melhorar</a>
          </li>
          
          <li>
            <a href="#contato" title="Entre em contato">Contato</a>
          </li>          
        </ul>
      </nav>
    </header>

   <div id="pw-mask" style="display:block"></div>

	<div id="signwall" class="shadow js-center-fixed"
		style="position: absolute; margin: 0px; top: 0px; left: 395px;">
		<div class="big-header">
			<div class="homebutton">
				<a href="http://www.estadao.com.br/"
					class="adtm-noticia-6-voltar-para-home"
					onclick="ga('send','event', 'Paywall - 2014', 'Notícia 6', 'Voltar para home');">
					<img src="http://www.estadao.com.br/paywall/img-tpl/voltar-home.png"></a>
			</div>
		</div>
		<div id="sw-content">
		
		</div>
		<div class="half-left">
			<a
				href="http://acesso.estadao.com.br/login/cadastrar.php?origem=paywall&amp;r=http://economia.estadao.com.br/noticias/geral,pf-deflagra-operacao-contra-pirataria-na-internet-e-prende-grupo-que-gerenciava-mega-filmes-hd,1798343"
				class="js-pw-link-cadastro adtm-noticia-6-cadastre-se"
				onclick="ga('send','event', 'Paywall - 2014', 'Notícia 6', 'Cadastre-se');"><img
				src="http://www.estadao.com.br/paywall/img-tpl/cadastrar.png"></a><br>
			<span><b>É cadastrado? </b><a
				href="http://acesso.estadao.com.br/login/?r=http://economia.estadao.com.br/noticias/geral,pf-deflagra-operacao-contra-pirataria-na-internet-e-prende-grupo-que-gerenciava-mega-filmes-hd,1798343"
				class="js-pw-link-login adtm-noticia-6-fazer-login"
				onclick="ga('send','event', 'Paywall - 2014', 'Notícia 6', 'Fazer Login');">Faça
					seu login.</a> </span> <span><b>Não desejo me cadastrar.</b><a
				href="http://www.estadao.com.br/"
				class="adtm-noticia-6-voltar-para-home"
				onclick="ga('send','event', 'Paywall - 2014', 'Notícia 6', 'Voltar para home');">Voltar
					para home.</a> </span>
			<div id="social-links">
				<a id="js-pw-login-fb"
					href="https://acesso.estadao.com.br/login/autenticar?provider=Facebook&amp;r=http://economia.estadao.com.br/noticias/geral,pf-deflagra-operacao-contra-pirataria-na-internet-e-prende-grupo-que-gerenciava-mega-filmes-hd,1798343"><img
					src="http://www.estadao.com.br/paywall/img-tpl/fb.png"></a> <a
					id="js-pw-login-google"
					href="https://acesso.estadao.com.br/login/autenticar?provider=Google&amp;r=http://economia.estadao.com.br/noticias/geral,pf-deflagra-operacao-contra-pirataria-na-internet-e-prende-grupo-que-gerenciava-mega-filmes-hd,1798343"><img
					src="http://www.estadao.com.br/paywall/img-tpl/google.png"></a>
			</div>
		</div>
		<div class="half-right">
			<a
				href="http://www.assineestadao.com.br/modal5m/?pOg=33094&amp;utm_source=modal_5m&amp;utm_medium=modal_5m&amp;utm_campaign=modal_5m"
				class="adtm-noticia-6-assine"
				onclick="ga('send','event', 'Paywall - 2014', 'Notícia 6', 'Assine');"><img
				src="http://www.estadao.com.br/paywall/img-tpl/assine-agora.png"></a>
			<div class="a-left">
				<img src="http://www.estadao.com.br/paywall/img-tpl/seta-duvida.gif">
			</div>
			<div class="wrap">
				<span><b>Dúvidas? </b><a
					href="http://www.estadao.com.br/mais-pra-ler/"
					class="adtm-noticia-6-duvidas-tutorial"
					onclick="ga('send','event', 'Paywall - 2014', 'Notícia 6', 'Dúvidas - tutorial');">Veja
						como funciona</a> </span>
				<p>
					o novo formato de acesso ao<br> Portal Estadão
				</p>
			</div>
		</div>
	</div>

	<form id="form">
			
			<h1>Login</h1>
			
			<ul>
				<li class="style">
					<input type="email" placeholder="Seu e-mail" name="email" required  />
				</li>
				<li class="style">
					<input type="password" placeholder="Sua senha" name="password" required  />
				</li>			
			</ul>
			
	</form>    
    
		<footer id="contato" class="footer-distributed">

			<div class="footer-left">

				<h3>Melhorar minha Cidade</h3>

				<p class="footer-links">
					<a href="#CotiaMelhor">O Cotia Melhor</a>
					·
					<a href="#Cotia_Melhor_como_funciona">Como Funciona?</a>
					·
					<a href="#Cotia_Melhor_Ja">Melhore a Cidade já</a>
					·
					<a href="#mapaProblemas">Onde Precisamos Melhorar</a>
				</p>

				<div class="footer-icons">

					<a href="#"><i class="fa fa-facebook"></i></a>
					<a href="#"><i class="fa fa-twitter"></i></a>
					<a href="#"><i class="fa fa-linkedin"></i></a>
					<a href="#"><i class="fa fa-github"></i></a>

				</div>
				<p class="footer-company-name"><a href='www.bjbraz.com.br' style="text-decoration: none;color: aliceblue;">BJBraz Sistemas &copy; 2015</a></p>
			</div>

			<div class="footer-right">

				<form action="#" method="post">

					<input type="text" name="email" placeholder="Digite seu E-mail" />
					<textarea name="message" placeholder="Nos diga o que você achou do CotiaMelhor?"></textarea>
					<button>Enviar</button>

				</form>

			</div>
			
			<div id="formInsert" style="display:none">
				<div id="form">
					<nav class="{{ ativo }}" ng-click="$event.preventDefault()">
						<!-- Quando um link no menu é clicado, nós definimos a variável ativa -->
						<a href="#mapaProblemas" class="home" ng-click="ativo='home'">Home</a>
						<a href="#mapaProblemas" class="projects" ng-click="ativo='projects'">Projetos</a>
						<a href="#mapaProblemas" class="services" ng-click="ativo='services'">Serviços</a>
						<a href="#mapaProblemas" class="contact" ng-click="ativo='contact'">Contato</a>
					</nav>
					<p ng-hide="ativo">Por favor, click em um item do menu</p>
					<p ng-show="ativo">Sua Escolha <b>{{ ativo }}</b></p>
				</div>
			</div>

		</footer>    
    	<!-- Incluindo o AngularJS do Google CDN -->
        <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.1.1/angular.min.js"></script>
  </body>
</html>