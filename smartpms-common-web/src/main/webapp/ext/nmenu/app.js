Ext.Loader.setConfig({enabled: true});
Ext.application({
    name: 'Ext.nmenu',
    
    appFolder:'/int/ext/nmenu',

    controllers: [
        'Menu' 
    ],

    autoCreateViewport: true
});