Ext.Loader.setConfig({enabled: true});

Ext.application({
    name: 'Ext.working',
    
    appFolder:'/int/ext/working',

    controllers: [
        'Working'
    ],

    autoCreateViewport: true
});