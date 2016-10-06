Ext.Loader.setConfig({enabled: true});
Ext.application({
    name: 'Ext.user',
    
    appFolder:'/int/ext/user',

    controllers: [
        'User' 
    ],

    autoCreateViewport: true
});