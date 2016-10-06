Ext.Loader.setConfig({enabled: true});

Ext.application({
    name: 'Ext.ncutoverm',
    
    appFolder:'/int/ext/ncutoverm',
    
    controllers: [
      'CutoverDashboard' 
    ],

    autoCreateViewport: true
});