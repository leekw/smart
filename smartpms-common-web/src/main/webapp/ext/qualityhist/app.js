Ext.Loader.setConfig({enabled: true});

Ext.application({
    name: 'Ext.qualityhist',
    
    appFolder:'/int/ext/qualityhist',

    controllers: [
        'QualityHist' 
    ],

    autoCreateViewport: true
});
