Ext.Loader.setConfig({enabled: true});

Ext.application({
    name: 'Ext.cutover',
    
    appFolder:'/int/ext/cutover',

    controllers: [
        'Cutover' 
    ],

    autoCreateViewport: true
});
