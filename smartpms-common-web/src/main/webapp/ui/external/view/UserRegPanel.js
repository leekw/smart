Ext.define('Ui.external.view.UserRegPanel', {
	extend : 'Ext.container.Container',
	alias : 'widget.userregpanel',
	id : 'user-reg-panel',
	layout: 'responsivecolumn',
    defaults: {
        xtype: 'container'
    },
	items : [
			{
				xtype:'panel',
				cls : 'reg-panel-body',
				title : '사용자 기본정보',
				bodyStyle : {
					'border-top': '1px solid #fff'
				},
				minHeight : 630,
				border : false,
				items : [
				    {
				    	xtype : 'form',
				    	defaults: {
				            labelWidth: 120
				        },
				        padding : 5,
				        border : false,
				        bodyStyle : {
				        	'box-shadow' : 'none',
				        	'padding' : '5px'
				        },
				        items :[
				            {
				            	fieldLabel: 'Photo',
				            	xtype : 'fieldcontainer',
							    name: 'photoPath',
							    height : 250,
							    anchor: '0',
							    layout : 'vbox',
							    items : [
							        {
							        	xtype : 'tbtext',
							        	id : 'userPhoto',
							        	html : '<img id="myPhoto" src="" height="200" width="200">',
							        	height : 210,
							        	width : '40%'
							        },
									{
									    xtype: 'filefield',
									    emptyText: 'Select an image',
									    name: 'photo-path',
									    width : '80%',
									    buttonText: '',
									    buttonConfig: {
									        iconCls: 'fa-picture-o'
									    },
									    listeners : {
									    	change : function() {
									    		var reader = new FileReader();
								    		    reader.onload = function(){
								    		      var output = document.getElementById('myPhoto');
								    		      output.src = reader.result;
								    		    };
								    		    reader.readAsDataURL(event.target.files[0]);
									    	}
									    }
									}
							    ]
							    
				            },
				            {
				            	xtype : 'fieldcontainer',
							    fieldLabel: 'ID',
							    layout : 'hbox',
							    anchor: "0",
							    items : [
							        {
							        	xtype : 'textfield',
							        	name : 'id',
							        	width : '41%',
							        	enforceMaxLength : true,
							        	maxLength : 15,
							        	enableKeyEvents: true,
							        	allowBlank: false,
							        	listeners : {
							        		keyUp : function ( obj , e , eOpts ) {
							        			var params = {
							        				userId : obj.getValue()
							        			};
							        			Ext.Ajax.request({
								    	    	    url: G_PATH + '/resource/user/vaild.json',
								    	    	    method: 'POST',
								    	    	    jsonData: Ext.encode(params),
								    	    	    success: function(response){
								    	    	    	var result = JSON.parse(response.responseText);
								    	    	    	if (result.error != null) {
								    	    				Ext.Msg.alert('Exception', result.error.message);
								    	    			} else {
								    	    				if (result.vaildInfo != null && result.vaildInfo.userId != null && result.vaildInfo.userId != '') {
								    	    					Ext.Msg.alert('Error', '이미 등록된 아이디 입니다.');
								    	    				}
								    	    			}
								    	    	    },
								    	    	    failure: function(){
								    	    	    	Ext.Msg.alert('Error', '조회 중 오류가 발생되었습니다.');
								    	    	    }
								    	    	});
							        		}
							        	}
							        },
							        {
							        	xtype : 'tbtext',
							        	text : ' 영문자 소문자 + 숫자 조합(특수문자, 대문자, 한글 불가) - 최대15자'
							        }
							    ]
							},
							{
							    xtype : 'textfield',
								fieldLabel: '이름',
							    name: 'name',
							    anchor: '50%',
							    maxLength : 15,
							    enforceMaxLength : true,
							    allowBlank: false
							},
							{
								xtype : 'fieldcontainer',
								fieldLabel: 'Password',
								layout : 'hbox',
								anchor : '0',
								items : [
								     {
								    	 xtype : 'textfield',
								    	 inputType: 'password',
										 name: 'password',
										 id : 'password-first',
										 maxLength : 15,
										 enforceMaxLength : true,
										 allowBlank: false,
										 width : '41%'
								     },
								     {
								    	 xtype : 'textfield',
								    	 fieldLabel: 'Confirm Password',
								    	 inputType: 'password',
								    	 labelWidth : 150,
										 name: 'confirmPassword',
										 allowBlank: false,
										 maxLength : 15,
										 enforceMaxLength : true,
										 width : '58%',
										 validator: function(value) {
											 var checkValue = Ext.getCmp('password-first').getValue();
											 if (value != checkValue) {
												 return '기 입력된 패스워드와 동일하게 입력해야 합니다.'
											 } else {
												 return true;
											 }
										 }
								     }
								]
							},
							{
								xtype : 'fieldcontainer',
								fieldLabel: 'Email',
								layout : 'hbox',
								anchor : '0',
								items : [
								    {
								    	xtype : 'textfield',
								    	name : 'email',
								    	vtype : 'email',
								    	maxLength : 30,
								    	enforceMaxLength : true,
								    	width : '41%'
								    },
								    {
								    	xtype : 'tbtext',
							        	text : ' ex)abc@aaa.com'
								    }
								]
							},
							{
								xtype : 'fieldcontainer',
								fieldLabel: '연락처',
								layout : 'hbox',
								anchor : '0',
								items : [
								     {
								    	 xtype : 'textfield',
								    	 name : 'phoneNumber',
								    	 maxLength : 30,
								    	 enforceMaxLength : true,
								    	 width : '41%'
								     },
								     {
								    	 xtype : 'tbtext',
								    	 text : ' ex)010-1234-5678'
								     }
								]
							},
							{
							    xtype : CommonCode._getCombo('USER_TYPE', '사용자 유형', false, 'userType', {labelWidth:120, labelAlign : 'right', width: '50%'}),
							    anchor: '50%'
							}
				        ]
				    }
				],
				responsiveCls: 'big-60 small-100'
			},
			{
				xtype:'panel',
				cls : 'reg-panel-body',
				title : '사용자 소속조직',
				minHeight : 630,
				border : false,
				bodyStyle : {
					'border-top': '1px solid #fff'
				},
				items : [
				    {
				    	xtype : 'orgtree'
				    }
				],
				responsiveCls: 'big-40 small-100'
			},
			{
				items : [
				    {
				    	xtype : 'button',
						text : '사용자 등록요청'
				    }
				],
				responsiveCls: 'big-60 small-100'
			}
	],
	listeners : {
		afterrender : function(panel) {
    	}
	}
});