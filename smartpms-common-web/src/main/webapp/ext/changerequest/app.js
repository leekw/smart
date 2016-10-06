Ext.Loader.setConfig({enabled: true});

Ext.application({
    name: 'Ext.changerequest',
    
    appFolder:'/int/ext/changerequest',

    controllers: [
        'ChangeRequest' 
    ],

    autoCreateViewport: true
});