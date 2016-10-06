Ext.Loader.setConfig({enabled: true});

Ext.application({
    name: 'Ext.programcr',
    
    appFolder:'/int/ext/programcr',

    controllers: [
        'Programcr' 
    ],

    autoCreateViewport: true
});
