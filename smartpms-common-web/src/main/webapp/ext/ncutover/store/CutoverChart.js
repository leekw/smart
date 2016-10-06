Ext.define('Ext.ncutover.store.CutoverChart', {
    extend: 'Ext.data.Store',
    model: 'Ext.ncutover.model.CutoverChart',
    autoDestroy: true,
    proxy: {
        type: 'ajax',
        url: '/int/cutover/dashboard/chart/get.json',
        headers: {
            'Content-Type': 'application/json'
        },
        reader: {
            type: 'json',
            rootProperty: 'info'
        },
        actionMethods: {
            create : 'POST',
            read   : 'POST',
            update : 'POST',
            destroy: 'POST'
        },
        extraParams : { maxRowSize : 0}
    },
    autoLoad : false,
    listeners : {
    	load : function( store, records, successful, eOpts ) {
    		
    	}
    }
});