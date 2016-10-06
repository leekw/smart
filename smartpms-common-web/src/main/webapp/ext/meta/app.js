Ext.Loader.setConfig({enabled: true});

Ext.application({
    name: 'Ext.meta',
    
    appFolder:'/int/ext/meta',

    controllers: [
        'Meta' 
    ],

    autoCreateViewport: true
});
