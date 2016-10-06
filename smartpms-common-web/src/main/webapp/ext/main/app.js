Ext.Loader.setConfig({enabled: true});

Ext.application({
    name: 'Ext.main',
    
    appFolder:'/int/ext/main',

    controllers: [
        'Main' 
    ],

    autoCreateViewport: true
});
