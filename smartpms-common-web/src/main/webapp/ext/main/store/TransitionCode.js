Ext.define('Ext.main.store.TransitionCode', {
    extend: 'Ext.data.Store',
    model: 'Ext.main.model.MainCode',
    autoDestroy: true,
    proxy: {
        type: 'ajax',
        url: '/int/jira/transition/step/list/get.json',
        headers: {
            'Content-Type': 'application/json'
        },
        reader: {
            type: 'json',
            rootProperty: 'codes'
        },
        actionMethods: {
            create : 'POST',
            read   : 'POST',
            update : 'POST',
            destroy: 'POST'
        },
        extraParams : { maxRowSize : 0 }
    },
    autoLoad : true
});