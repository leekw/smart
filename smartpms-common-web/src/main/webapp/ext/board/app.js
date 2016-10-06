Ext.Loader.setConfig({enabled: true});

Ext.application({
    name: 'Ext.board',
    
    appFolder:'/int/ext/board',

    controllers: [
        'Board' 
    ],

    autoCreateViewport: true
});