Ext.Loader.setConfig({enabled: true});
Ext.application({
    name: 'Ext.setting',
    
    appFolder:'/int/ext/setting',

    controllers: [
        'Setting' 
    ],

    autoCreateViewport: true
});