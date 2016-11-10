Ext.define('Ui.admin.org.controller.Org', {
    extend: 'Ext.app.Controller',
    stores: ['OrgTree','OrgUser', 'OrgRole'],
    models: ['OrgTree','OrgUser', 'OrgRole'],

    views: ['OrgTree','OrgUserGrid'],

    refs: [{
    	ref: 'orgTree',
        selector: 'orgtree'
    }],
    
    init: function() {

        this.control({
        	'orgtree' : {
        		
        	}
        });
        
    }

    
});