Ext.Loader.setConfig({enabled: true});

Ext.application({
    name: 'Ext.dlog',
    
    appFolder:'/int/ext/dlog',

    controllers: [
        'DLog' 
    ],

    autoCreateViewport: true
});
