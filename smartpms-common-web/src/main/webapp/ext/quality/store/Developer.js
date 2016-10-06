Ext.define('Ext.quality.store.Developer', {
    extend: 'Ext.data.Store',
    model: 'Ext.quality.model.Developer',
    autoDestroy: true,
    grouper : {
    	groupFn : function(item) {
    		return '<b>' + item.get("module") + '/' + item.get("developer") + '</b>';
    	}
    },
    proxy: {
        type: 'ajax',
        url: '/int/quality/developer/get.json',
        headers: {
            'Content-Type': 'application/json'
        },
        reader: {
            type: 'json',
            rootProperty: 'developers'
        },
        actionMethods: {
            create : 'POST',
            read   : 'POST',
            update : 'POST',
            destroy: 'POST'
        },
        extraParams : { maxRowSize : 0}
    },
    autoLoad : false
});