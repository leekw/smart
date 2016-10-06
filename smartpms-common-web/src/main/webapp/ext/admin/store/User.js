Ext.define('Ext.admin.store.User', {
    extend: 'Ext.data.Store',
    model: 'Ext.admin.model.User',
    autoDestroy: true,
    pageSize : 500,
    remoteSort : true,
    proxy: {
        type: 'ajax',
        enablePaging : true,
        url: '/int/user/list/get.json',
        headers: {
            'Content-Type': 'application/json'
        },
        reader: {
            type: 'json',
            rootProperty: 'data.users',
            totalProperty : 'data.total'
        },
        actionMethods: {
            create : 'POST',
            read   : 'POST',
            update : 'POST',
            destroy: 'POST'
        },
        extraParams : {
        	maxRowSize : 0,
        	start : 0, 
        	limit : 500
        	
        }
    },
    autoLoad : true,
    listeners : {
    	beforeload : function(store, op, eOpts) {
    		var proxy = store.getProxy();
    		proxy.extraParams.page = store.currentPage;
    	}
    }
});