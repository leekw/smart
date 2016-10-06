Ext.Loader.setConfig({enabled: true});
Ext.application({
    name: 'Ext.admin',
    
    appFolder:'/int/ext/admin',

    controllers: [
        'Admin' 
    ],

    autoCreateViewport: true
});