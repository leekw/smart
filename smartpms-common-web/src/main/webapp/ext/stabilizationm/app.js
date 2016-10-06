Ext.Loader.setConfig({enabled: true});

Ext.application({
    name: 'Ext.stabilizationm',
    
    appFolder:'/int/ext/stabilizationm',
    
    controllers: [
      'StabilizationDashboard' 
    ],

    autoCreateViewport: true
});