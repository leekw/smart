Ext.define('Ui.external.controller.RegUser', {
    extend: 'Ext.app.Controller',
    stores: ['OrgTree'],
    models: ['OrgTree'],

    views: ['OrgTree'],

    refs: [{
    	ref: 'orgTree',
        selector: 'orgtree'
    }],
    
    init: function() {

        this.control({
        	'orgtree' : {
        		beforeload : this.subMenuBeforeLoad
        	}
        });
        
    },
    subMenuBeforeLoad : function(store, operation, eOpts) {
		var proxy = store.getProxy();
	    var node = operation.node;
	    if (node != null && proxy != null) {
	    	if (node.data.id != 'root') {
	    		proxy.extraParams.parentOrgId = node.data.id;
	    	}
	    	
	    }
	}

    
});