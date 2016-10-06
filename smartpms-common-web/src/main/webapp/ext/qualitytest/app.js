Ext.Loader.setConfig({enabled: true});

Ext.application({
    name: 'Ext.qualitytest',
    
    appFolder:'/int/ext/qualitytest',

    controllers: [
        'QualityTest' 
    ],

    autoCreateViewport: true
});
