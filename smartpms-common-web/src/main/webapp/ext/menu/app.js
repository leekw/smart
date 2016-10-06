Ext.Loader.setConfig({enabled: true});
Ext.application({
    name: 'Ext.menu',
    
    appFolder:'/int/ext/menu',

    controllers: [
        'Menu' 
    ],

    autoCreateViewport: true
});