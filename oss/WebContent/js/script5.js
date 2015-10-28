// O controlador é uma função regular JavaScript. Ela é chamada
// uma vez quando o AngularJS roda dentro da declaração ng-controller 

function InlineEditorController ($scope) {

	// $scope é um objeto especial que faz
	// estas propriedades disponíveis para o View
	// como variáveis. Aqui nós definimos alguns valores padrão:

	$scope.showtooltip = false;
	$scope.text = 'Click aqui para editar!';

	// Algumas funções auxiliares que estarão
	// disponíveis nas declarações angular

	$scope.hideTooltip = function () {

		// Quando um model é alterado, o View vai ser automaticamente
		// atualizado pelo AngularJS. Neste caso irá esconder o tooltip

		$scope.showtooltip = false;
	}

	$scope.toggleTooltip = function (e) {
		e.stopPropagation ();
		$scope.showtooltip = !$scope.showtooltip;
	}
}