Ext.Loader.setConfig({enabled: true});

Ext.application({
    name: 'Ext.programvf',
    
    appFolder:'/int/ext/programvf',

    controllers: [
        'Programvf' 
    ],

    autoCreateViewport: true
});
