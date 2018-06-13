var jsTreeRef = '';
$(window).on('load',()=>{	
	// Test AJAX
	$.jstree.defaults.core.data = true;
	$('#jstree_div').jstree({
		"plugins" : [ "wholerow" ],
	    'core' : {
	        'data' : {
	            'url' : 'accueil?para=tree',
	            'data' : function (node) {
	                return { 
	                	'id' : node.id,
	                	'text' : node.text,
	                	'icon' : node.icon,
	                	'state' : node.state,
	                	'children' : node.children
	                };
	            }
	        }
	    }
	});
	
	debug = jsTreeRef = $.jstree.reference('#jstree_div');
	// jsTreeRef.get_json()[0] // Récupère l'arbo en json(pour l'envoi au serv ?)
	
	
	// Event déclenché si action sur jstree
	$('#jstree_div').on('changed.jstree', function (e, data) {
		// On récupère les noeuds sélectionnés
	    var i, j, r = [];
	    for(i = 0, j = data.selected.length; i < j; i++) {
	      r.push(data.instance.get_node(data.selected[i]).original.text);
	    }
	    console.log(r.join(', '));
	  }).jstree();
   
});
