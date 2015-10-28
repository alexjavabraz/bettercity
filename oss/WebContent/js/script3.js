// Definindo um novo módulo para nossa aplicação
var app = angular.module ("instantSearch", []);

// Crie um filtro de pesquisa instantânea

app.filter ('searchFor', function () {

	// Todos os filtros devem retornar uma função. O primeiro 
	// parâmetro é um dado que será filtrado, e o segundo é um 
	// argumento que vai ser passado com dois pontos
	// searchFor: searchString

	return function (arr, searchString) {

		if (!searchString) {
			return arr;
		}

		var result = [];

		searchString = searchString.toLowerCase();

		// Usando o útil método forEach para iterar através do array
		angular.forEach (arr, function (item) {

			if (item.title.toLowerCase().indexOf(searchString) !== -1) {
				result.push(item);
			}
		});

		return result;
	};

});

// O Controlador

function InstantSearchController ($scope) {

	// O modelo de dados. Estes itens normalmente são requisitados via Ajax,
	// mas aqui estão simplificados. Veja o próximo exemplo para 
	// dicas usando Ajax.

	$scope.tutoriais = [
		{
			url: 'http://tutorialzine.com/2013/07/50-must-have-plugins-for-extending-twitter-bootstrap/',
			title: '50 Must-have plugins for extending Twitter Bootstrap',
			image: 'http://cdn.tutorialzine.com/wp-content/uploads/2013/07/featured_4-100x100.jpg'
		},
		{
			url: 'http://tutorialzine.com/2013/08/simple-registration-system-php-mysql/',
			title: 'Making a Super Simple Registration System With PHP and MySQL',
			image: 'http://cdn.tutorialzine.com/wp-content/uploads/2013/08/simple_registration_system-100x100.jpg'
		},
		{
			url: 'http://tutorialzine.com/2013/08/slideout-footer-css/',
			title: 'Create a slide-out footer with this neat z-index trick',
			image: 'http://cdn.tutorialzine.com/wp-content/uploads/2013/08/slide-out-footer-100x100.jpg'
		},
		{
			url: 'http://tutorialzine.com/2013/06/digital-clock/',
			title: 'How to Make a Digital Clock with jQuery and CSS3',
			image: 'http://cdn.tutorialzine.com/wp-content/uploads/2013/06/digital_clock-100x100.jpg'
		},
		{
			url: 'http://tutorialzine.com/2013/05/diagonal-fade-gallery/',
			title: 'Smooth Diagonal Fade Gallery with CSS3 Transitions',
			image: 'http://cdn.tutorialzine.com/wp-content/uploads/2013/05/featured-100x100.jpg'
		},
		{
			url: 'http://tutorialzine.com/2013/05/mini-ajax-file-upload-form/',
			title: 'Mini AJAX File Upload Form',
			image: 'http://cdn.tutorialzine.com/wp-content/uploads/2013/05/ajax-file-upload-form-100x100.jpg'
		},
		{
			url: 'http://tutorialzine.com/2013/04/services-chooser-backbone-js/',
			title: 'Your First Backbone.js App – Service Chooser',
			image: 'http://cdn.tutorialzine.com/wp-content/uploads/2013/04/service_chooser_form-100x100.jpg'
		}
	];  
}




