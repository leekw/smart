Ext.Loader.setConfig({enabled: true});
Ext.application({
    name: 'Ext.session',
    
    appFolder:'/int/ext/session',

    controllers: [
        'Session' 
    ],

    autoCreateViewport: true
});