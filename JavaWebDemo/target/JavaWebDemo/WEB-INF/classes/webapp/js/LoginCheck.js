/**
 * Created by CodingTest on 2017/7/29.
 */
document.onkeydown = function(e){
    var event = e || window.event;
    var code = event.keyCode || event.which || event.charCode;
    if (code == 13) {
        login();
    }
}
$(function(){
    $("input[name='login']").focus();
});
function cleardata(){
    $('#loginForm').form('clear');
}
function login(){
    if($("input[name='login']").val()=="" || $("input[name='password']").val()==""){
        $("#showMsg").html("用户名或密码为空，请输入");
        $("input[name='login']").focus();
    }else{
        //ajax异步提交
        $.ajax({
            type:"POST",   //post提交方式默认是get
            url:"login.action",
            data:$("#loginForm").serialize(),   //序列化
            error:function(request) {      // 设置表单提交出错
                $("#showMsg").html(request);  //登录错误提示信息
            },
            success:function(data) {
                document.location = "index.action";
            }
        });
    }
}
