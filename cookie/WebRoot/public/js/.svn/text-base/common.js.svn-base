/**
 * @authors Liu Hui
 * @mail    504886265@qq.com
 */
$(document).ready(function(){
    //通用切换
    $('.tabover dt').mouseover(function(){
        var dataTab=$(this).attr("data-tab");
        $(this).addClass("curr").siblings("dt").removeClass("curr");
        if(dataTab){
            var strData = new Array();
            strData = dataTab.split(' ');
            for (var i = 0; i < strData.length; i++) {
                $('#'+strData[i]).show().siblings(".tabcon").hide();
            };
        }
    });
    $('.tabclick dt').click(function(){
        var dataTab=$(this).attr("data-tab");
        $(this).addClass("curr").siblings("dt").removeClass("curr");
        if(dataTab){
            var strData = new Array();
            strData = dataTab.split(' ');
            for (var i = 0; i < strData.length; i++) {
                $('#'+strData[i]).show().siblings(".tabcon").hide();
            };
        }
    });
    //input提示
    $(".tipCall").each(function(){
        //var tipw = $(this).parents("dd").width()-$(this).width()-60;
        var tip = $(this).siblings(".tipbar");
        //tip.width(tipw)
        $(this).focus(function(){
            tip?tip.show():void 0;
        }).blur(function(){
            tip?tip.hide():void 0;
        })
    })
    
    $('body').on("click", "#menu .parent span", function() {
        if($(this).parent().find('ul:hidden').length > 0){
            $('#menu .parent span').removeClass('curr');
            $('#menu .parent .sub').slideUp();
            $(this).addClass('curr')
            $(this).parent().find(".sub").slideDown(200);
        }else{
            $(this).removeClass('curr')
            $(this).parent().find(".sub").slideUp(200);
        }
        return false;
    });
    $("body").on("click", ".sub li a", function(){
        $(".sub li a").removeClass("over");
        $(this).addClass("over");
    });
    $(".listTable tbody tr").hover(function() {
        $(this).addClass('over')
    }, function() {
        $(this).removeClass('over')
    });



});