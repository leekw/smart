Ext.Loader.setConfig({enabled: true});

Ext.application({
    name: 'Ext.loginfail',
    
    appFolder:'/int/ext/loginfail',

    controllers: [
        'LoginFail'
    ],

    autoCreateViewport: true
});