Ext.Loader.setConfig({enabled: true});

Ext.application({
    name: 'Ext.layout',
    
    appFolder:'/int/ext/layout',

    controllers: [
        'LayoutMain'
    ],

    autoCreateViewport: true
});