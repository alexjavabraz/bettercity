// Defina um novo módulo. Desta vez iremos declarar uma dependência 
// no módulo ngResource, assim poderemos trabalhar com a API do Instagram

var app = angular.module ("switchableGrid", ['ngResource']);

// Crie e registre o novo serviço "instagram"
app.factory ('instagram', function ($resource) {

	return {
		fetchPopular: function (callback) {

			// O módulo ngResource nos dá o service $resource
			// Isto irá trabalhar com AJAX facilmente.
			// Aqui eu estou usando um client_id como um teste app.
			// Troque isto pelo seu

			var api = $resource ('https://api.instagram.com/v1/media/popular?client_id=:client_id&callback=JSON_CALLBACK', {
				client_id: '642176ece1e7445e99244cec26f4de1f'
			}, {
				// Isto irá criar uma ação que nós nomeamos "fetch"
				// Isso emite uma requisição JSONP a URL da fonte. 
				// JSONP requer que a parte callback=JSON_CALLBACK
				// seja inclusa na URL.

				fetch: { method: 'JSONP' } 
			});

			api.fetch (function (response) {

				// Chame a função callback suplementar
				callback (response.data);
			});
		}
	}
});

// O controlador. Note que eu inclui nosso service instragram que
// nós definimos abaixo. Ele estará disponível dentro da função automaticamente

function SwitchableGridController ($scope, instagram) {

	// Define o layout da aplicação. Clicando nos botões da 
	// barra de ferramentas para mudar seus valores

	$scope.layout = 'grid';

	$scope.pics = [];

	// Use o service instragram e busque uma lista das fotos populares
	instagram.fetchPopular (function (data) {

		// Atribuindo ao array pics irá ocorrer que
		// o Angular automaticamente irá redesenhar o View
		$scope.pics = data;
	});
	
}