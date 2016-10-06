var IframeContent = {
	_getHtml : function() {
		var result = '<iframe id="notice-tp-critical" width="0" height="0" src="/int/etc/critical-template.html?version=1.0.0" frameborder="0" allowfullscreen></iframe>'
				   + '<iframe id="notice-tp-complete" width="0" height="0" src="/int/etc/complete-template.html?version=1.0.0" frameborder="0" allowfullscreen></iframe>'
				   + '<iframe id="notice-tp-normal" width="0" height="0" src="/int/etc/normal-template.html?version=1.0.0" frameborder="0" allowfullscreen></iframe>'
			       ;
		return result;
	}
};
Ext.define('Ext.notice.view.NoticePanelNew', {
	extend : 'Ext.form.Panel',
	alias : 'widget.noticepanelnew',
	id : 'notice-panel',
	bodyPadding : 5,
	border : false,
	layout : {
		type : 'vbox',
		align: 'stretch'
	},
	items : [ 
	    {
	    	id : 'notice-list',
			xtype : 'noticegrid',
			border:true
		}, {
			hidden:true,
			collapsible:false,
			xtpe : 'panel',
            html: IframeContent._getHtml()
		}
	]
});