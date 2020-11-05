;(
	function($){
		$.extend({
				"axtCheckIp":function(ip){
					var regip= /^(([0-1]?\d{1,2}|2[0-4]\d|25[0-5])\.){3}([0-1]?\d{1,2}|2[0-4]\d|25[0-5])$/;
					if(ip == null || ip == "")
						return false;
					if(regip.test(ip)){
						return true;
					}
					return false;
				}
		});
		//手机号码验证规则
		$.extend({
				"axtCheckCellphoneNumber":function(mobile){
					var isMobile=/^(?:13\d|15\d|18\d)\d{5}(\d{3}|\*{3})$/; 
					if(mobile == null || mobile == ""){
						return false;
					}
					if(isMobile.test(mobile)){
						return true;
					}
					return false;
				}
		});
		//座机验证规则
		$.extend({
				"axtCheckPhone":function(phone){
					var isPhone=/^((0\d{2,3})-)?(\d{7,8})(-(\d{3,}))?$/;
					if(phone == null || phone == ""){
						return false;
					}
					if(isPhone.test(phone)){
						return true;
					}
					return false;
				}
		});
		
		$.extend({
				"axtCheckMac":function(mac){
					var regmac1 = /^[A-Fa-f0-9]{1,2}\-[A-Fa-f0-9]{1,2}\-[A-Fa-f0-9]{1,2}\-[A-Fa-f0-9]{1,2}\-[A-Fa-f0-9]{1,2}\-[A-Fa-f0-9]{1,2}$/;
        			var regmac2 = /^[A-Fa-f0-9]{1,2}[A-Fa-f0-9]{1,2}[A-Fa-f0-9]{1,2}[A-Fa-f0-9]{1,2}[A-Fa-f0-9]{1,2}[A-Fa-f0-9]{1,2}$/;
					if(mac == null || mac == "")
						return false;
					if(regmac1.test(mac) || regmac2.test(mac)){
						return true;
					}
					return false;
				}
		});
		
		$.extend({
				"axtCheckEmail":function(email){
					var regEmail= /^([a-zA-Z0-9]+[_|\-|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\-|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
					if(email == null || email == "")
						return false;
					if(regEmail.test(email)){
						return true;
					}
					return false;
				}
		})
		
		$.extend({
			"axtCheckPwd":function(pwd){
				pwd = $.trim(pwd);
				var regPwd = /^[a-zA-Z]{1}[0-9a-zA-Z]{7,19}$/;
				var reg1 = /^[0-9]{8,20}$/;
				var reg2 = /^[a-zA-Z]{8,20}$/;
				if(pwd == "" || pwd == null){
					return false;
				}else if(regPwd.test(pwd) && !reg1.test(pwd) && !reg2.test(pwd)){
					return true;
				}else{
					return false;
				}
			}
		})
		
		$.extend({
				"axtCheckNumber":function(num){
					if($.isNumeric(num))
						return true;
					return false;
				}
		})
		
		$.extend({
				"axtCheckPort":function(port){
					var numPort ;
					if(port == null || port == "")
						return false;
					if($.trim(port) == ""){
						return false;
					}
					try{
						numPort = parseInt(port);
					}catch(e){
						return false;
					}
				    if(numPort < 65535 && numPort > 0){
				    	return true;
				    }
					return false;
				}
		})
		
		$.extend({
				"axtCheckMask":function(mask){
					var regmask = /^(([0-1]?\d{1,2}|2[0-4]\d|25[0-5])\.){3}([0-1]?\d{1,2}|2[0-4]\d|25[0-5])$/;
					if(mask == null || mask == "")
						return false;
					if(regmask.test(mask)){
						return true;
					}
					return false;
				}
		});
		
		$.extend({
				"axtIp2Int":function(ip){
					var regIp = /^(([0-1]?\d{1,2}|2[0-4]\d|25[0-5])\.){3}([0-1]?\d{1,2}|2[0-4]\d|25[0-5])$/;
					if(ip == null || ip == "")
						return null;
					if(regIp.test(ip)){
						var num = 0;
   						ip = ip.split(".");
   						num = Number(ip[0]) * 256 * 256 * 256 + Number(ip[1]) * 256 * 256 + Number(ip[2]) * 256 + Number(ip[3]);
    					num = num >>> 0;
    					return num;
					}
					return null;
				}
		});
		
		$.extend({
				"axtInt2Ip":function(num){
					var regIp = /^(([0-1]?\d{1,2}|2[0-4]\d|25[0-5])\.){3}([0-1]?\d{1,2}|2[0-4]\d|25[0-5])$/;
					if(num == null || num == "")
						return null;
					var str;
				    var tt = new Array();
				    tt[0] = (num >>> 24) >>> 0;
				    tt[1] = ((num << 8) >>> 24) >>> 0;
				    tt[2] = (num << 16) >>> 24;
				    tt[3] = (num << 24) >>> 24;
				    str = String(tt[0]) + "." + String(tt[1]) + "." + String(tt[2]) + "." + String(tt[3]);
					if(regIp.test(str)){
						return str;
					}
					return null;
				}
		});
		
		$.extend({
			"getDate": function(n){
				var date=new Date();
				var year = date.getFullYear();
				var month = date.getMonth()+1;
				if(month < 10){
					month = "0"+month;
				}
				var day = date.getDate();
				if(day < 10){
					day = "0"+day;
				}
				var hour = date.getHours();
				if(hour < 10){
					hour = "0"+hour;
				}
				var minute = date.getMinutes();
				if(minute < 10){
					minute = "0"+minute;
				}
				var second = date.getSeconds();
				if(second < 10){
					second = "0"+second;
				}
				var week = date.getDay();
				if(n == 1){
					hour = hour - 1;
					if(hour < 10){
						hour = "0"+hour;
					}
				}else if(n == 2){
					hour = hour - 5;
					if(hour < 10){
						hour = "0"+hour;
					}
				}else if(n == 3){
					hour = "00";
					minute = "00";
					second = "00";
				}else if(n == 4){
					week = week==0?7:week;
					week = week - 1;
					var one=week*24*60*60000+hour*60*60000+minute*60000+second*1000;
					var oneOld=date.getTime()
					var t=oneOld-one;
					date =new Date(t);
					year = date.getFullYear();
					month = date.getMonth()+1;
					if(month < 10){
						month = "0"+month;
					}
					day = date.getDate();
					if(day < 10){
						day = "0"+day;
					}
					hour = "00";
					minute = "00";
					second = "00";
					return year+"-"+month+"-"+day+" "+hour+":"+minute+":"+second;
				}
				return year+"-"+month+"-"+day+" "+hour+":"+minute+":"+second;
			}
		})
		
		$.fn.extend({
			MultDropList : function(options) {
				var op = $.extend({
					wraperClass : "wraper",
					data : "",
					selected : ""
				}, options);
				return this.each(function() {
					var $this = $(this); //指向TextBox 
					var $hf = $(this).next(); //指向隐藏控件存 
					var conSelector = "#" + $this.attr("id")+ ",#" + $hf.attr("id");
					var $wraper = $(conSelector).wrapAll('<div style="width:179px; display: inline; "><div></div></div>').parent().parent().addClass(op.wraperClass);
					var $list = $('<div class="list"></div>').appendTo($wraper);
					//控制弹出页面的显示与隐藏 
					$this.click(function(e) {
						$list.toggle();
						e.stopPropagation();
					});
					$(document).click(function() {
						$list.hide();
					});
					$list.filter("*").click(function(e) {
						e.stopPropagation();
					});
			/* 		$(document).focusout(function() {
						$list.hide();
					}); */
					//加载默认数据 
					$list.append('<tbody><tr><td><input type="hidden" class="selectAll" value="" /></td></tr></tbody>');
					var $ul = $list.find("tbody");
					//加载json数据 
					var listArr = op.data.split("|");
					var jsonData;
					for ( var i = 0; i < listArr.length; i++) {
						jsonData = eval("(" + listArr[i] + ")");
						$ul.append('<tr><td><input type="checkbox" value="' + jsonData.k + '" /><span>'+ jsonData.v+ '</span></td></tr>');
					}
					//加载勾选项 
					var seledArr;
					if (op.selected.length > 0) {
						seledArr = selected.split(",");
					} else {
						seledArr = $hf.val().split(",");
					}
					$.each(seledArr, function(index) {
						$("td input[value='"+ seledArr[index]+ "']", $ul).attr("checked", "checked");
						var vArr = new Array();
						$("input[class!='selectAll']:checked",$ul).each(function(index) {
							vArr[index] = $(this).next().text();
						});
						$this.val(vArr.join(","));
					});
					//全部选择或全不选 
					$("td:first input", $ul).click(function() {
						if ($(this).attr("checked")) {
							$("td input", $ul).attr("checked","checked");
						} else {
							$("td input", $ul).removeAttr("checked");
						}
					});
					//点击其它复选框时，更新隐藏控件值,文本框的值 
					$("input", $ul).click(function() {
						var kArr = new Array();
						var vArr = new Array();
						$("input[class!='selectAll']:checked",	$ul).each(function(index) {
							kArr[index] = $(	this).val();
							vArr[index] = $(this).next().text();
						});
						$hf.val(kArr.join(","));
						$this.val(vArr	.join(","));
					});
				});
			}
		});
		
		$.extend({
				"changeColor":function(id){
					$("#"+id+" tr").each(function(i){
						if(i%2 == 0){
							$(this).addClass("oddtr");
						}else{
							$(this).addClass("eventr");
						}
					});
					$("body").on("mouseover", "#"+id+" tr:gt(0)", function(){
				    	$(this).addClass("overtr");
				    });
				    $("body").on("mouseout", "#"+id+" tr:gt(0)", function(){
				    	 $(this).removeClass("overtr");
				     });
				     $("body").on("click", "#"+id+" tr:gt(0)", function(){
				    	 $("#"+id+" tr:gt(0)").removeClass("clicktr");
				    	 $(this).addClass("clicktr");
				     });
				}
		});
	}
)(jQuery)