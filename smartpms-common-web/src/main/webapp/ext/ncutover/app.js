Ext.Loader.setConfig({enabled: true});

Ext.application({
    name: 'Ext.ncutover',
    
    appFolder:'/int/ext/ncutover',
    
    controllers: [
      'CutoverDashboard' 
    ],

    autoCreateViewport: true
});