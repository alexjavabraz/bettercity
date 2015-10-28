var phonecatApp = angular.module('phonecatApp', []);

phonecatApp.controller('PhoneListCtrl', function ($scope){
											$scope.phones=[{'name':'Nexus S', 'snippet':'Fast just got faster with Nexus S.', 'age':1},
											               {'name':'Motorola XOOM with WI-FI', 'snippet':'The next, next generation tablet.', 'age':2},
											               {'name':'Motorola XOOM', 'snippet':'The Next, Next Generation tablet2.', 'age':3}
											               ];
											
											$scope.orderProp = 'age';
										}
		
);