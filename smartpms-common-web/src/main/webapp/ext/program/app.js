Ext.Loader.setConfig({enabled: true});

Ext.application({
    name: 'Ext.program',
    
    appFolder:'/int/ext/program',

    controllers: [
        'Program' 
    ],

    autoCreateViewport: true
});
