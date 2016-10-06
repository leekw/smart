Ext.define('Ext.role.store.RoleAuth', {
    extend: 'Ext.data.Store',
    model: 'Ext.role.model.RoleAuth',
    autoDestroy: true,
    proxy: {
        type: 'ajax',
        enablePaging : true,
        url: '/int/role/auth/list/get.json',
        headers: {
            'Content-Type': 'application/json'
        },
        reader: {
            type: 'json',
            rootProperty: 'resources'
        },
        actionMethods: {
            create : 'POST',
            read   : 'POST',
            update : 'POST',
            destroy: 'POST'
        },
        extraParams : {
        	maxRowSize : 0
        }
    },
    autoLoad : false,
    listeners : {
    	beforeload : function(store, op, eOpts) {
    	}
    }
});