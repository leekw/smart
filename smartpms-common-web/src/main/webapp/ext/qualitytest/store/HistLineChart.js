Ext.define('Ext.qualitytest.store.HistLineChart', {
    extend: 'Ext.data.Store',
    model: 'Ext.qualitytest.model.ChartData',
    autoDestroy: false,
    proxy: {
        type: 'ajax',
        url: '/int/quality/test/hist/chart/get.json',
        headers: {
            'Content-Type': 'application/json'
        },
        reader: {
            type: 'json',
            rootProperty: 'data'
        },
        actionMethods: {
            create : 'POST',
            read   : 'POST',
            update : 'POST',
            destroy: 'POST'
        },
        extraParams : { maxRowSize : 0 }
    },
    autoLoad : false,
    listeners : {
    	load: function( store, records, successful, eOpts ) {
    		
    	}
    }
    
});