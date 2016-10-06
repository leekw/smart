Ext.Loader.setConfig({enabled: true});
Ext.application({
    name: 'Ext.role',
    
    appFolder:'/int/ext/role',

    controllers: [
        'Role' 
    ],

    autoCreateViewport: true
});