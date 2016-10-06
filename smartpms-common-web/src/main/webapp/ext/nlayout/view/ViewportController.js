var M_TITLE = '';
var IMG_RESOURCE = '';
Ext.define('Ext.nlayout.view.ViewportController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.mainviewport',
    
    listen : {
        controller : {
            '#' : {
                unmatchedroute : 'onRouteChange'
            }
        }
    },
    routes: {
        ':node': 'onRouteChange'
    },

    setCurrentView: function(hashTag, _resource) {
        hashTag = (hashTag || '').toLowerCase();
        IMG_RESOURCE = '';
        var me = this,
            refs = me.getReferences(),
            mainCard = refs.mainCardPanel,
            mainLayout = mainCard.getLayout(),
            navigationList = refs.navigationTreeList,
            viewModel = me.getViewModel(),
            vmData = viewModel.getData(),
            store = navigationList.getStore(),
            node = store.findNode('resourceId', hashTag),
            resourceTypeCode = node ? node.get('resourceTypeCode') : M_RESOURCE_TYPE,
            resourceContent = _resource == null ? node.get('resourceContent') : _resource.resourceContent,
            resourceName = node ? node.get('resourceName') : null,
            view = node ? node.get('url') : M_URL,
            lastView = vmData.currentView,
            existingItem = mainCard.child('component[resourceId=' + hashTag + ']'),
            newView;
        hashTag = node ? hashTag : M_RESOURCE_ID;
    	M_TITLE = resourceName == null ? M_RESOURCE_NAME : resourceName;
        // Kill any previously routed window
        if (lastView && lastView.isWindow) {
            lastView.destroy();
        }

        lastView = mainLayout.getActiveItem();
        if (!existingItem) {
        	if (resourceTypeCode == 'PAGE') {
        		if (view.indexOf("http://") != -1) {
	 			    var option = "left=100,top=100,width=1200,height=800,location=no,titlebar=no,scrollbars=yes";
	 			    var title = resourceName;
	 		    	var popup = window.open(view, title, option);
	 		        popup.focus();
	 		        return ;
        		} else {
		        	newView = Ext.create('Ext.Component',{
		        		margin: '10 10 10 10',
		    			autoEl: { 
				              tag: 'iframe', 
				              width: '98%', 
				              height: '98%', 
				              focusOnLoad: true, 
				              frameborder: 0, 
				              src: '/int' + view 
					     },
					     hideMode: 'offsets',
		                 resourceId: hashTag
		    		});
        		}
        	} else if (resourceTypeCode == 'IMAGE') {
				newView = Ext.create('Ext.Panel',{
        			autoScroll : true,
        			margin: '10 10 10 10',
        			bodyStyle: {
        		        background: 'none',
        		        border : 'none'
        		    },
        			hideMode: 'offsets',
        			items : [
        			   {
        				   xtype : 'panel',
        				   height : 750,
        				   autoScroll:true,
        				   bodyStyle: {
        				        background: 'none',
        				        border : 'none'
        				   },
        				   html : '<div style="">' + resourceContent + '</div>',
        			   },
        			   {
	   		    	    	xtype : 'form',
	   		    			labelWidth: 80,
	   		    			labelAlign: 'right',
	   		    			bodyStyle: {
		   		 		        background: 'none',
		   		 		        border : 'none'
		   		 		    },
	   		    			border : false,
	   		    			items :[
	   		    			{
	   		    				xtype : 'filegrid'
	   		    			},{
	   		    				xtype : 'form',
	   		    				id : 'file-down-form',
	   		    				maxHeight : 0,
	   		    				defaultType: 'hiddenfield',
	   		    				items: [{
	   		    					name : 'fileName'
	   		    				},{
	   		    					name : 'filePath'
	   		    				},{
	   		    					name : 'filePath'
	   		    				}]
	   		    			}]
	   		    	    }
        			],
	                resourceId: hashTag
        		});
				IMG_RESOURCE = hashTag;
        	} else {
        		return ;
        	}
        }

        if (!newView || !newView.isWindow) {
            // !newView means we have an existing view, but if the newView isWindow
            // we don't add it to the card layout.
            if (existingItem) {
                // We don't have a newView, so activate the existing view.
                if (existingItem !== lastView) {
                    mainLayout.setActiveItem(existingItem);
                }
                newView = existingItem;
            }
            else {
                // newView is set (did not exist already), so add it and make it the
                // activeItem.
                Ext.suspendLayouts();
                mainLayout.setActiveItem(mainCard.add(newView));
                Ext.resumeLayouts(true);
            }
        }

        navigationList.setSelection(node);

        if (newView.isFocusable(true)) {
            newView.focus();
        }

        vmData.currentView = newView;
    },

    onNavigationTreeSelectionChange: function (tree, node) {
        if (node && node.get('resourceId')
        		&& node.get('resourceTypeCode') !== 'MENU') {
        	
            this.redirectTo( node.get("resourceId"));
        }
    },
    
    onNavigationTreeRender : function() {
    },

    onToggleNavigationSize: function () {
        var me = this,
            refs = me.getReferences(),
            navigationList = refs.navigationTreeList,
            wrapContainer = refs.mainContainerWrap,
            collapsing = !navigationList.getMicro(),
            new_width = collapsing ? 64 : 250;

        if (Ext.isIE9m || !Ext.os.is.Desktop) {
            Ext.suspendLayouts();

            refs.senchaLogo.setWidth(new_width);

            navigationList.setWidth(new_width);
            navigationList.setMicro(collapsing);

            Ext.resumeLayouts(); // do not flush the layout here...

            // No animation for IE9 or lower...
            wrapContainer.layout.animatePolicy = wrapContainer.layout.animate = null;
            wrapContainer.updateLayout();  // ... since this will flush them
        }
        else {
            if (!collapsing) {
                // If we are leaving micro mode (expanding), we do that first so that the
                // text of the items in the navlist will be revealed by the animation.
                navigationList.setMicro(false);
            }

            // Start this layout first since it does not require a layout
            refs.senchaLogo.animate({dynamic: true, to: {width: new_width}});

            // Directly adjust the width config and then run the main wrap container layout
            // as the root layout (it and its chidren). This will cause the adjusted size to
            // be flushed to the element and animate to that new size.
            navigationList.width = new_width;
            wrapContainer.updateLayout({isRoot: true});

            // We need to switch to micro mode on the navlist *after* the animation (this
            // allows the "sweep" to leave the item text in place until it is no longer
            // visible.
            if (collapsing) {
                navigationList.on({
                    afterlayoutanimation: function () {
                        navigationList.setMicro(true);
                    },
                    single: true
                });
            }
        }
    },

    onMainViewRender:function() {
    	this.redirectTo(M_RESOURCE_ID);
    },

    onRouteChange:function(id){
    	if (id == 'file') {
    		if(IMG_RESOURCE != '')
    			FileUpload._openFileUploadForm(IMG_RESOURCE);
    	} else {
	    	var me = this;
	    	Ext.getBody().mask("Loading...");
			Ext.Ajax.request({
				url: '/int/resource/info/get.json',
				method : 'POST',
				headers : {'Content-Type' : 'application/json'},
				params : (Ext.JSON.encode({resourceId : id})),
				success: function(res, eOtps) {
					var result = JSON.parse(res.responseText);
					if (result != null && result.info != null && result.info.resourceId != null
							&& result.info.resourceId != '') {
						me.setCurrentView(id, result.info);
					}
					Ext.getBody().unmask();
				},
				failure: function(res, eOtps) {
					Ext.getBody().unmask();
				}
				
			});
    	}
    },

    onSearchRouteChange: function () {
        this.setCurrentView('search');
    },

    onEmailRouteChange: function () {
        this.setCurrentView('email');
    }
});


