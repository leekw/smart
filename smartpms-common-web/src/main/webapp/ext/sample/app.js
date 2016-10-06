Ext.Loader.setConfig({enabled: true});

Ext.application({
    name: 'Ext.sample',
    
    appFolder:'/int/ext/sample',

    controllers: [
        'Sample' 
    ],

    autoCreateViewport: true
});