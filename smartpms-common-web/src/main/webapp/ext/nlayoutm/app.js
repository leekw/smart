Ext.Loader.setConfig({enabled: true});

Ext.application({
    name: 'Ext.nlayoutm',
    
    appFolder:'/int/ext/nlayoutm',
    
    extend: 'Ext.nlayoutm.Application',

    requires: [
       'Ext.nlayoutm.*'
    ],

    autoCreateViewport: true
});