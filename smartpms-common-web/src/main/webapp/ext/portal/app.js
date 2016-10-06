Ext.Loader.setConfig({enabled: true});

Ext.application({
    name: 'Ext.portal',
    
    appFolder:'/int/ext/portal',

    controllers: [
        'Portal' 
    ],

    autoCreateViewport: true
});