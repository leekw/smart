Ext.Loader.loadScript({url:'/int/ext/common/CommonCode.js'});
Ext.Loader.loadScript({url:'/int/ext/common/Org.js'});
Ext.define('Ext.dlog.view.Viewport', {
    extend: 'Ext.Viewport',    
    overflowY : 'auto',
    requires: [
       'Ext.dlog.view.DLogPanel',
       'Ext.dlog.view.DLogDetailGrid',
       'Ext.ux.BoxReorderer'
    ], 
    
    initComponent: function() {
        var me = this;
        
        Ext.apply(me, {
            items: [
                {
                    xtype: 'dlogpanel'
                }
            ]
        });
                
        me.callParent(arguments);
    }
});
