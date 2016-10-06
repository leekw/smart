Ext.Loader.setConfig({enabled: true});

Ext.application({
    name: 'Ext.loginm',
    
    appFolder:'/int/ext/loginm',

    controllers: [
        'LoginMobile'
    ],

    autoCreateViewport: true
});