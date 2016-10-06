Ext.Loader.setConfig({enabled: true});

Ext.application({
    name: 'Ext.quality',
    
    appFolder:'/int/ext/quality',

    controllers: [
        'Quality' 
    ],

    autoCreateViewport: true
});
