Ext.define('Ext.board.store.Team', {
    extend: 'Ext.data.Store',
    model: 'Ext.board.model.Team',
    autoDestroy: true,
    proxy: {
        type: 'ajax',
        url: '/int/team/list/get.json',
        headers: {
            'Content-Type': 'application/json'
        },
        reader: {
            type: 'json',
            rootProperty: 'teams'
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