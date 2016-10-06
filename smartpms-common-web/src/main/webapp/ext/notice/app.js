Ext.Loader.setConfig({enabled: true});

Ext.application({
    name: 'Ext.notice',
    
    appFolder:'/int/ext/notice',

    controllers: [
        'Notice' 
    ],

    autoCreateViewport: true
});