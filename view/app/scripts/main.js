/**
 * 简单ajax封装  为了注册时候一步验证
 * @param  {[type]} url [description]
 * @return {[type]}     [description]
 */
function ajax(url,callback){
	var httpRequest;
	if (window.XMLHttpRequest) { // Mozilla, Safari, ...
	    httpRequest = new XMLHttpRequest();
	} else if (window.ActiveXObject) { // IE 8 and older
	    httpRequest = new ActiveXObject("Microsoft.XMLHTTP");
	}
	httpRequest.open('GET', url, true);
	httpRequest.send();
	httpRequest.onreadystatechange = function(){
		// 解析完成
		if (httpRequest.readyState === 4) {
    		callback(httpRequest.responseText);
		}
	}
	
}
/**
 * 简单兼容事件监听方法
 * @param {[type]}   dom      [description]
 * @param {[type]}   event    [description]
 * @param {Function} callback [description]
 */
function addEventListener(el,event,callback){
	if(window.addEventListener){
		el.addEventListener(event,callback);
	}else if(window.attachEvent){
		el.attachEvent('on'+type,callback);
	}
}

window.onload = function(){
	// 注意ie6/7的getElementById的bug
	var username = document.getElementById('username');
	addEventListener(username,'blur',function(){
		var str = username.value; 
		str = str.replace(/(^\s*)|(\s*$)/g, "");
		if (!str) {
			return;
		};
		ajax("/user?username="+str,function(data){
			// ie6/7原生不支持JSON
			var msg = JSON.parse(data);
			var contorls = username.parentNode.parentNode;
			var p = contorls.lastElementChild;
			if ( p.nodeName != "P" ) {
				p = document.createElement('p');
			};
			p.innerText = msg.message;
			var form = document.getElementById('registerform');
			if (msg.enable) {
				form.className = 'form-vertical';
			}else{
				form.className = 'form-vertical error';
			}
			username.parentNode.parentNode.appendChild(p);
		});
	});
}