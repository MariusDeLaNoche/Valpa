var debug = '';
$(window).on('load',()=>{	
	$('#jstree_div').jstree({
		'core' : {
			'data' : [
				{
					"text" : "Root node",
					"state" : { "opened" : true },
					"libelleTechnique" : "patatechaudetest.pgm",
					"children" : [
						{
							"text" : "Child node 1",
							"icon" : "jstree-file",
							"libelleTechnique" : "jaimelespommes.haricotvert"
						},
						{
							"text" : "Child node 2",
							"state" : { "opened" : true },
							"libelleTechnique" : "mariacoccinelle.rpz",
							"children" : [
								{
									"text" : "Test file",
									"libelleTechnique" : "rondoudou.kawai",
									"icon" : "jstree-file"
								},
								{
									"text" : "Test folder",
									"libelleTechnique" : "bw4ss_SAMA.amonakoyum"
								}
							]
						}
					]
				}
			]
		}
	});
	
	// Event déclenché si changement sur jstree
	$('#jstree_div').on('changed.jstree', function (e, data) {
	    var i, j, r = [];
	    for(i = 0, j = data.selected.length; i < j; i++) {
	      r.push(data.instance.get_node(data.selected[i]).original.libelleTechnique);
	    }
	    console.log(r.join(', '));
	  })
	  // create the instance
	  .jstree();
   
});

//window.onload(function(){
//	
//})
