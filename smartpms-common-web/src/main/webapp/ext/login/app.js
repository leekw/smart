Ext.Loader.setConfig({enabled: true});

Ext.application({
    name: 'Ext.login',
    
    appFolder:'/int/ext/login',

    controllers: [
        'Login'
    ],

    autoCreateViewport: true
});