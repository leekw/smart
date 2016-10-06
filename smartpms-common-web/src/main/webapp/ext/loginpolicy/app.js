Ext.Loader.setConfig({enabled: true});

Ext.application({
    name: 'Ext.loginpolicy',
    
    appFolder:'/int/ext/loginpolicy',

    controllers: [
        'LoginPolicy'
    ],

    autoCreateViewport: true
});