Ext.Loader.setConfig({enabled: true});

Ext.application({
    name: 'Ext.accessdenied',
    
    appFolder:'/int/ext/accessdenied',

    controllers: [
        'AccessDenied'
    ],

    autoCreateViewport: true
});