Ext.Loader.setConfig({enabled: true});

Ext.application({
    name: 'Ext.qainterfacesys',
    
    appFolder:'/int/ext/qainterfacesys',

    controllers: [
        'QaInterface' 
    ],

    autoCreateViewport: true
});
