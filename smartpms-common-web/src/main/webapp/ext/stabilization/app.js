Ext.Loader.setConfig({enabled: true});

Ext.application({
    name: 'Ext.stabilization',
    
    appFolder:'/int/ext/stabilization',
    
    controllers: [
      'StabilizationDashboard' 
    ],

    autoCreateViewport: true
});