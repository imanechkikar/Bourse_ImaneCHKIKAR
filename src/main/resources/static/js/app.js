/**
 * 
 */


var app =  angular.module("Societe", ['ui.router']);


app.config(function($stateProvider,$urlRouterProvider){
	
	$stateProvider.state("home",{
		url:"/home",
		templateUrl:"view/home.html",
		controller:"HomeController"
	      }
	);
	
	$stateProvider.state("ordre",{
		url:"/ordre",
		templateUrl:"view/Ordre.html",
		controller:"OrdreController"
	      }
	);
	
	$stateProvider.state("societe",{
		url:"/societe",
		templateUrl:"view/Societe.html",
		controller:"SocieteController"
	      }
	);
	
	$urlRouterProvider.otherwise("home");
}
		

);


app.controller("OrdreController",function($scope,$http){
	$http.get("listesocietes")
    .success(function(data){
   	  $scope.societes=data;
   	}
    );
	
	$scope.ordre={};
	$scope.ok=false;
	$scope.saveOrdre=function(){
		console.log($scope.ordre);
		$http({
			method  : 'POST',
			url     : '/ordre',
			data    : JSON.stringify($scope.ordre ),
			headers :{'Content-Type': 'application/json'} 
		}).success(function(){
			$scope.ok=true;
		});
	}
   
	
	
	
	
});

app.controller("SocieteController",function($scope,$http){
	
});

  
app.controller("HomeController",function($scope,$http){
	
	$scope.societe=null;
	$scope.listeOrdres=null;
	$scope.codeSociete="MA0000012296";
	$scope.pagecourante=0;
	$scope.size=5;
	$scope.pages=null;
	$scope.total=0;
	$scope.moyenne=0;
	$scope.up=null;
	$scope.ok=false;
	
	$scope.chargerSociete= function(){
		$http.get("societes/"+$scope.codeSociete)
		     .success(function(data){
		    	  $scope.societe=data;
		    	  $scope.chargerOrdres();
		    	  $http.get("societes/"+$scope.codeSociete+"/Totaux")
		    	    .success(function(data){
		    	   	  $scope.total=data;
		    	   	   }
		    	     );
		    	  $http.get("societes/"+$scope.codeSociete+"/Moyenne")
		    	    .success(function(data){
		    	   	  $scope.moyenne=data;
		    	   	   }
		    	     );
		         }
		      );
	};
	
	$scope.chargerOrdres= function(){
		$http.get("societes/"+$scope.codeSociete+"/Orders?page="+$scope.pagecourante+"&size="+$scope.size)
		     .success(function(data){
		    	  $scope.listeOrdres=data;
		    	  console.log(data.content);
		    	  $scope.pages=new Array(data.totalPages);
		         }
		      );
	};
	
	$scope.goTo=function($index){
		$scope.pagecourante=$index;
		$scope.chargerOrdres();
	}
	
	$scope.deleteOrd=function(idOrdre){
		$http.delete("ordre?id="+idOrdre)
		.success(function (data) {
			$scope.chargerOrdres();
		});
	};
	
	$scope.updateOrd=function(order){
		$scope.up=order;
		$http.get("listesocietes")
	    .success(function(data){
	   	  $scope.societes=data;
	   	}
	    );
	}
	
   $scope.upOrdre=function(up){
		
		console.log($scope.up);
		$http({
			method  : 'POST',
			url     : '/ordre',
			data    : JSON.stringify($scope.up ),
			headers :{'Content-Type': 'application/json'} 
		}).success(function(){
			$scope.ok=true;
			$scope.up=null;
			alert($scope.ok);
			
		});
			
		
	}
	
});

















