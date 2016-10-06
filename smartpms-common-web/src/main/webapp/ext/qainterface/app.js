Ext.Loader.setConfig({enabled: true});

Ext.application({
    name: 'Ext.qainterface',
    
    appFolder:'/int/ext/qainterface',

    controllers: [
        'QaInterface' 
    ],

    autoCreateViewport: true
});
