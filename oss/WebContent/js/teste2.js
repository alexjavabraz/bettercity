function OrderFormController ($scope) {

	// Defina o modelo de propriedades. O View vai fazer o loop
	// através do array services e gerar um elemento li
	// para cada um dos itens.

	$scope.services = [
		{
			name: 'Desenvolvimento Web',
			price: 3000,
			active: true
		}, {
			name: 'Design',
			price: 2000,
			active: false
		}, {
			name: 'Integração',
			price: 2500.1245,
			active: false
		}, {
			name: 'Treinamento',
			price: 2200,
			active: false
		}, {
			name: 'Suporte',
			price: 1850.3562,
			active: false
		}
	];

	$scope.toggleActive = function (s) {
		s.active = !s.active;	
	};

	// Método útil para calcular o preço total
	$scope.total = function () {

		var total = 0;

		// Uso o método auxiliar do Angular 'forEach'
		// para iterar o array services

		angular.forEach ($scope.services, function (s) {
			if (s.active) {
				total += s.price;
			}
		});

		return total;
	};

}