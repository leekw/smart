Ext.Loader.setConfig({enabled: true});

Ext.application({
    name: 'Ext.qainterfacesvc',
    
    appFolder:'/int/ext/qainterfacesvc',

    controllers: [
        'QaInterface' 
    ],

    autoCreateViewport: true
});
