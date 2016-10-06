Ext.define('Ext.login.view.LoginModel', {
    extend: 'Ext.app.ViewModel',
    alias: 'viewmodel.loginmodel',

    data: {
        userid : !Cookies._getCookie("INT_USER") ? '' : Cookies._getCookie("INT_USER"),
        fullName : '',
        password : '',
        email    : '',
        persist: Cookies._getCookie("INT_USER") ? true : false,
        agrees : false
    }
});