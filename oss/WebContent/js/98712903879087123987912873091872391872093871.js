      var map;
      var pictureUser = '';
      var amarker = '';
      var userLogged = '';
      var marcacaoDoUsuarioNaoLogado = '';
      var address = '';
      var iconBase = 'http://localhost:8080/oss/assets/images/icos/';
      var localizacaoUsuario = '';
      var latitude;
      var longitude;
      var itens = [];
      
      var icons = {
    	problema: {
          name: 'Problema',
          icon: iconBase + 'problema.png'
        },
        melhorado: {
          name: 'Melhorado',
          icon: iconBase + 'problema-corrigido.png'
        },
        working: {
            name: 'Atuando',
            icon: iconBase + 'obra-em-andamento.png'
          },        
        info: {
          name: 'Informa&#231;&#227;o',
          icon: iconBase + 'poder-publico-analisando.png'
        }         
      }; 
      
      
      function criaString(title, address, detail, id){
    	  
    	  return '	<form name="frm'+id+'" action="detalhe-demanda.html"><div id='+id+' class="form">'+
				'	<nav class="" id='+id+'>'+
				'	<a id="'+id+'" class="melhorar-minha-cidade-opcao-selecionada">Problema</a>'+
				'	<a id="'+id+'" class="projects">Informação</a>'+
				'	<a id="'+id+'" class="services">Sugestão</a>'+
				'	<a id="'+id+'" put_before_onClick="this.className=\'melhorar-minha-cidade-opcao-selecionada\'" class="contact">Outro</a>'+
				'	</nav>'+
				'	<div class="formulario">'+
				'   <input type="hidden" name="id"  id="formulario_lat'+id+'" value="'+id+'">'+
				'   <input type="hidden" id="formulario_long'+id+'" value=>'+
				'	<div>'+
				'    <input type="text" class="formulario_input" id="formulario_titulo'+id+'" value="'+title+'" readonly /></div>'+
				'	<div>'+
				'   <textarea id="formulario_descricao'+id+'" class="formulario_textarea" maxlength="500" cols="50" rows="4">"'+detail+'"</textarea>'+
				'   </div>'+
				'	<div><input type="text" id="formulario_endereco'+id+'" class="formulario_input" value="'+address+'" readonly /></div>'+
				'	<div class="formulario_div_imagem"><img src="assets/images/icos/photo.png" class="formulario_imagem" id="formulario_imagem_'+id+'" onClick="enviarParaDetalhe('+id+');" class="formulario_button"/></div>'+
				'	<div class="formulario_div_btn"><button class="btn" />Ver detalhe</div>'+
				'	</div></form>';
    	  
      }
      
      function enviarParaDetalhe(id){
    	  
      }
      
      function initialize2() {
    	  /*FB.getLoginStatus();*/
    	  
    	  var titulo = '';
		  var descricao = '';
		  var endereco = '';
		  var alatitude = '';
		  var alongitude = '';
		  var tipo = '';
		  
          map = new google.maps.Map(document.getElementById('map-problema-apontado'), {
              zoom: 17,
              center: new google.maps.LatLng(-23.548466,-46.6332475),
              mapTypeId: google.maps.MapTypeId.SATELLITE,
              zoomControlOptions : {
                  style : google.maps.ZoomControlStyle.SMALL
              }
            });		  
    	  
          var QueryString = function () {
    		  var query_string = {};
    		  var query = window.location.search.substring(1);
    		  var vars = query.split("&");
    		  for (var i=0;i<vars.length;i++) {
    		    var pair = vars[i].split("=");
    		    if (typeof query_string[pair[0]] === "undefined") {
    		      query_string[pair[0]] = decodeURIComponent(pair[1]);
    		    } else if (typeof query_string[pair[0]] === "string") {
    		      var arr = [ query_string[pair[0]],decodeURIComponent(pair[1]) ];
    		      query_string[pair[0]] = arr;
    		    } else {
    		      query_string[pair[0]].push(decodeURIComponent(pair[1]));
    		    }
    		  } 
    		    return query_string;
    		}();
    		
    		var url = 'http://'+document.location.host+'/oss/rest/detalhe/get/'+QueryString.id;
    		
    		
    		$('#compartilharDetalheDemanda').click(function(e){
    			e.preventDefault();
    			FB.ui({
    			method: 'feed',
    			name: 'Ajude a melhorar a cidade você também.',
//    			link: 'http://localhost:8080/oss/detalhe-demanda.html?id=0',
    			picture: 'http://localhost:8080/oss/assets/images/melhore-a-cidade-fb.jpg',
    			caption: 'via MelhorarMinhaCidade.com.br',
    			description: "Com o APP MelhorarMinhaCidade você mostra o que precisa ser melhorado, para os órgãos competentes, compartilha com seus amigos, acumula pontos e concorre á prêmios. Mostre o que você quer melhorar no seu bairro, na sua cidade!",
    			});
    			});
    		
            
            $.get( url, { id: QueryString.id  }, 
  		    		function(result){
		  		    			if (result != '') {
								var json = JSON.parse(result);
								titulo = json.titulo;
								descricao = json.descricao;
								endereco = json.endereco;
								alatitude = json.latitude;
								alongitude = json.longitude;
								tipo = json.tipo;
								
								var centralizada = new google.maps.LatLng(   parseFloat(alatitude), parseFloat(alongitude)  );
					            
					            map.setCenter( centralizada );
					            
					            new google.maps.Marker({
	        					    position: centralizada,
	        					    map: map,
	        					    icon: icons['problema'].icon
	        					});
					            
					            document.getElementById('titulo-do-problema-cidade').innerHTML = titulo;
					            document.getElementById('texto-detalhe-do-problema').innerHTML = descricao;
					            document.getElementById('data-do-problema').innerHTML = endereco;
								
							}
  		    		},"text");
            

            
            
    		
          
      }//END INITIALIZE2
      
      function initialize() {
    	  /*FB.getLoginStatus();*/
          map = new google.maps.Map(document.getElementById('map'), {
            zoom: 14,
            center: new google.maps.LatLng(-23.6057502,-46.9178099),
            mapTypeId: google.maps.MapTypeId.ROADMAP
             
          });
        
        setInterval(function(){
        			var script = document.createElement('script');
        			console.log('finding points... ' + 'http://'+document.location.host+'/oss/rest/map');
			        script.src = 'http://'+document.location.host+'/oss/rest/map';
			        document.getElementsByTagName('head')[0].appendChild(script);
			        }, 10000);
        
        var legend = document.getElementById('legend');
        for (var key in icons) {
          var type = icons[key];
          var name = type.name;
          var icon = type.icon;
          var div = document.createElement('div');
          div.innerHTML = '<img src="' + icon + '" width=\"30px\" height=\"30px\"> ' + name;
          legend.appendChild(div);
        }

        map.controls[google.maps.ControlPosition.RIGHT_BOTTOM].push(legend); 
        
        if(navigator.geolocation){
        
        	navigator.geolocation.getCurrentPosition(

        			function(position){
        				latitude  = position.coords.latitude;
        				longitude = position.coords.longitude;
        				var accuracy  = position.coords.accuracy;
        				var timestamp = position.timestamp;
        				
        				if(accuracy < 50000){ //especified in meters

        					localizacaoUsuario = new google.maps.Marker({
        			            position: {lat: latitude, lng: longitude},
        			            map: map,
        			            icon: pictureUser,
        			            title: 'Você está aqui',
        			            label: 'Você está aqui',
        			            zIndex: 10,
        			            optimized: true,
        			            draggable: false
        			          });
        					
        					map.setCenter(localizacaoUsuario.getPosition());
        					
        					
        				}else{
        					console.log('Accuracy exced limit ' + accuracy);
        				}
        				
        				
        			}, 
        			function(error){
        					console.log(error);
        			},
        			
        			{timeout:10000}, {maximumAge:20000});
        	
        }
        
        //SEARCH
     // Create the search box and link it to the UI element.
  	  var input = document.getElementById('pac-input');
  	  var searchBox = new google.maps.places.SearchBox(input);
  	  map.controls[google.maps.ControlPosition.TOP_LEFT].push(input);

  	  // Bias the SearchBox results towards current map's viewport.
  	  map.addListener('bounds_changed', function() {
  	    searchBox.setBounds(map.getBounds());
  	  });

  	  var markers = [];
  	  // [START region_getplaces]
  	  // Listen for the event fired when the user selects a prediction and retrieve
  	  // more details for that place.
  	  searchBox.addListener('places_changed', function() {
  	    var places = searchBox.getPlaces();

  	    if (places.length == 0) {
  	      return;
  	    }

  	    // Clear out the old markers.
  	    markers.forEach(function(marker) {
  	      marker.setMap(null);
  	    });
  	    markers = [];

  	    // For each place, get the icon, name and location.
  	    var bounds = new google.maps.LatLngBounds();
  	    places.forEach(function(place) {
  	      var icon = {
  	        url: place.icon,
  	        size: new google.maps.Size(71, 71),
  	        origin: new google.maps.Point(0, 0),
  	        anchor: new google.maps.Point(17, 34),
  	        scaledSize: new google.maps.Size(25, 25)
  	      };

  	      // Create a marker for each place.
  	      markers.push(new google.maps.Marker({
  	        map: map,
  	        icon: icon,
  	        title: place.name,
  	        position: place.geometry.location
  	      }));

  	      if (place.geometry.viewport) {
  	        // Only geocodes have viewport.
  	        bounds.union(place.geometry.viewport);
  	      } else {
  	        bounds.extend(place.geometry.location);
  	      }
  	    });
  	    map.fitBounds(bounds);
  	  });        
        
       //END SEARCH
       
       // MAP MARKER
  		var labels = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ';
  		var labelIndex = 0;
  		// This event listener calls addMarker() when the map is clicked.
	    google.maps.event.addListener(map, 'click', function(event) {
	    	addDinamicMarker(event.latLng, map);
	    });
	 
	 	// Adds a marker to the map.
	    function addDinamicMarker(alocation, amap) {
	      // Add the marker at the clicked location, and add the next-available label
	      // from the array of alphabetical characters.
	      
	      amarker = new google.maps.Marker({
			        position: alocation,
			        label: labels[labelIndex++ % labels.length],
			        map: amap
		  });
	      
	      amap.setCenter(alocation);
	      
	      amarker.setMap(null);
	      amarker.setMap(amap);
	      
	      var conteudo = '';
	      
		  if(userLogged == ''){
			  conteudo = addPointNaoLogado();
		  }else{
			  conteudo =  addPoint( amarker.position.lat(),  amarker.position.lng());
		  }
	      
	      if(amap.getZoom() < 18){
	      	amap.setZoom(18);
	      	amarker.setMap(null);
	      }else{
	    	  marcacaoDoUsuarioNaoLogado =  new google.maps.InfoWindow({
      		    content: conteudo
    		  });
	    	  
	    	  amarker.addListener('click', function() {
	    		  marcacaoDoUsuarioNaoLogado.open(amap, amarker);
	          });
	    	  
	    	  marcacaoDoUsuarioNaoLogado.open(amap, amarker);
	      }
	 	}
      	//END MAP MARKER
      }//END INITIALIZE FUNCTION
      
      function addPointNaoLogado(){
    	  return document.getElementById('facaLogin').innerHTML;
      }
      
      function addPoint(lat, lng){
    	  
    	  var id = Math.random();
    	  
    	  codeLatLng(lat, lng, 'formulario_endereco'+id);
    	  
    	  return '	<div id='+id+' class="form">'+
				'	<nav class="" id='+id+'>'+
				'	<a  id="'+id+'a" onClick="select("'+id+'a", "'+id+'b", "'+id+'c", "'+id+'d");" class="home" >Problema</a>'+
				'	<a  id="'+id+'b" onClick="select("'+id+'b", "'+id+'a", "'+id+'c", "'+id+'d");" class="projects">Informação</a>'+
				'	<a  id="'+id+'c" onClick="select("'+id+'c", "'+id+'a", "'+id+'b", "'+id+'d");" class="services">Sugestão</a>'+
				'	<a  id="'+id+'d" onClick="select("'+id+'d", "'+id+'a", "'+id+'c", "'+id+'b");" class="contact">Outro</a>'+
				'	</nav>'+
				'	<div class="formulario"><input type="hidden" id="formulario_lat'+id+'" value="'+lat+'"><input type="hidden" id="formulario_long'+id+'" value="'+lng+'">'+
				'	<div><input type="text" class="formulario_input" id="formulario_titulo'+id+'" required placeholder="Qual o problema?" /></div>'+
				'	<div><textarea id="formulario_descricao'+id+'" class="formulario_textarea" maxlength="500" cols="50" rows="4" placeholder="Descreva o problema, com o máximo de detalhes"></textarea></div>'+
				'	<div><input type="text" id="formulario_endereco'+id+'" class="formulario_input" name="endereco" /></div>'+
				'	<div class="formulario_div_imagem"><img src="assets/images/icos/photo.png" class="formulario_imagem" id="formulario_imagem_'+id+'" onClick="insertDemanda('+id+')" class="formulario_button"/></div>'+
				'	<div class="formulario_div_btn"><button class="btn" onClick="insertDemanda('+id+')" class="formulario_button"/>Melhorar a cidade</div>'+
				'	</div>';
      }
      
      function codeLatLng(lat, lng, address) {
    	  var geocoder = new google.maps.Geocoder();
    	  
    	  var latlng = new google.maps.LatLng(lat, lng);
    	  geocoder.geocode({
    	    'latLng': latlng
    	  }, function (results, status) {
    	    if (status === google.maps.GeocoderStatus.OK) {
    	      if (results[1]) {
    	    	if(document.getElementById(address) != null){
    	        	document.getElementById(address).value=results[0].formatted_address;
    	        	console.log(results[0].formatted_address);
    	      	}
    	      } else {
    	        console.log('No results found');
    	      }
    	    } else {
    	      console.log('Geocoder failed due to: ' + status);
    	    }
    	  });
    	}
            
      
      // Loop through the results array and place a marker for each
      // set of coordinates.
      window.eqfeed_callback = function(results) {
    	  console.log('calling callback... ' + results.features.length);
    	  
        for (var i = 0; i < results.features.length; i++) {
          var coords = results.features[i].geometry.coordinates;
          var latLng = new google.maps.LatLng(coords[0],coords[1]);
          var title  = results.features[i].properties['title'];
          var place  = results.features[i].properties['place'];
          var zIndex = parseInt(results.features[i].id); //results.features[i].properties['mag'];
          var label  = results.features[i].properties['detail'];
          var iconType 	 = results.features[i].properties['type'];
          itens[zIndex] = place;
          
          new google.maps.Marker({
            position: latLng,
            map: map,
            title: title,
            label: label,
            icon: icons[iconType].icon,
            zIndex: zIndex,
            optimized: true,
            draggable: false
          }).addListener('click', function() {
        	  
        	  	new google.maps.InfoWindow({
        		    content: criaString( this.title, itens[this.zIndex], this.label, this.zIndex)
        		  }).open(map, this);
          });
          
        }
      }
      
      var myJSONData = '{"data":{"mode" : "subscribe","technologyareas":[1],"assettypes":["podcast","documents"]}}';
      var url        = 'res/demanda/ins';
      
		function insertDemanda(id) {
			var titulo    = document.getElementById('formulario_titulo'+id).value;
			var descricao = document.getElementById('formulario_descricao'+id).value;
			var endereco  = document.getElementById('formulario_endereco'+id).value;
    		var latitude  = document.getElementById('formulario_lat'+id).value;
    		var longitude = document.getElementById('formulario_long'+id).value;
			
			var url = 'http://'+document.location.host+"/rest/demanda/ins";
			
			//websocket.send('<br/><br/>Criado o ponto no mapa: <b>Titulo</b> '+titulo+' <b>Descricao:</b> '+descricao+' <b>Endereço:</b> '+endereco+' <b>Latitude:</b> '+latitude+' <b>Longitude:</b> '+ longitude);
			
		    $.post( url, { titulo: titulo, descricao: descricao, endereco: endereco, latitude: latitude, longitude: longitude }, 
		    		function(result){
		    			if('ok' == result){
		    				document.getElementById(id).innerHTML = document.getElementById('parabens').innerHTML;
		    			}
		    		},"text");
		}
      
		
	    $(document).ready(function () {
	    	
	    	var timeout = 1000;
	    	
	    	$("#pw-mask").click(function(){
	    					$('#pw-mask').hide(timeout)
			    			$('#signwall').hide(timeout);
		    		}
		    );
		    
		    $("#login").click(function(){
		    			console.log($("#login").html());
		    			loginFaceBook();
				    	if($("#login").html() == 'Acessar'){
				    			$("#pw-mask").show(timeout)
				    	    	$("#signwall").show(timeout);
				    	}else{
				    		
				    	}
		    		}
		    );
		    
		    
	    });
	    
	    
	    function insertCliente(name,first_name,last_name,email,id,birthday,gender,locale, religion) {
			var url = 'http://'+document.location.host+"/oss/rest/cliente/ins";
			
		    $.post( url, { nome:name,email:email,gender:gender,id:id, locale:locale,birthday:birthday,religion: religion }, 
		    		function(result){
		    			if('ok' == result){
		    			}
		    		},"text");
		}
	    
	    function enviarContato() {
			var url = 'http://'+document.location.host+"/oss/rest/contato/ins";
			
			var email   = document.getElementById('email');
			var message = document.getElementById('message');
			
		    $.post( url, { nome:'',email:email.value,descricao:message.value,lat:'', lon: ''}, 
		    		function(result){
		    			if('ok' == result){
		    			}
		    		},"text");
		    
		    email.value = '';
		    message.value= '';
		}	    
	    
	    // Here we run a very simple test of the Graph API after login is
		  // successful.  See statusChangeCallback() for when this call is made.
		  function loginFaceBook() {
		    console.log('Welcome!  Fetching your information.... ');
		    FB.api('/me?fields=name,first_name,last_name,email,picture,id,birthday,gender,locale, religion, hometown', function(response) {
		      console.log('Successful login for: ' + response.name);
		      console.log('name, ' + response.name + '.');
		      console.log('email, ' + response.email + '.');
		      console.log('first_name, ' + response.first_name + '.');
		      console.log('last_name, ' + response.last_name + '.');
		      console.log('id, ' + response.id + '.');
		      console.log('birthday, ' + response.birthday + '.');
		      console.log('Gender, ' + response.gender + '.');
		      console.log('locale, ' + response.locale + '.');
		      console.log('Religion, ' + response.religion + '.');
		      
		      pictureUser = response.picture.data.url;
	    	  userLogged = response;
		      
		      if('undefined' == pictureUser){
		    	  pictureUser = iconBase + 'voce-esta-aqui.png';
		      }else{
		    	  localizacaoUsuario.setIcon(pictureUser);
		      }
		      
		      insertCliente(response.name,response.first_name,response.last_name,response.email,response.id,response.birthday,response.gender,response.locale, response.religion);
		      
		      document.getElementById('pw-mask').style.display='none';
		      document.getElementById('signwall').style.display='none';
		      document.getElementById('login').innerHTML = response.name;
		      
		      if(marcacaoDoUsuarioNaoLogado != ''){
		    	  amarker.setMap(null);
		      }
		      
		    });
		  }//end loginFaceBook
		  
		  function select(a, b, c, d){
			  document.getElementById(a).className='melhorar-minha-cidade-opcao-selecionada';
			  document.getElementById(b).className='home';
			  document.getElementById(c).className='home';
			  document.getElementById(d).className='home';
		  }
	         
	    
	    