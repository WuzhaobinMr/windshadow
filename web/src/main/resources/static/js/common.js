function page_nav(frm,num){
	if(typeof(frm)!='object'){
		frm=document.forms[0];
	}
	with(frm){	 
	  pageNo.value=num;
	  submit();
  }
}

function jump_to(frm,pageno){
	if(typeof(frm)!='object'){
		frm=document.forms[0];
	}
    var regexp=/^\d+$/;
	if(!regexp.test(pageno)){
	  alert('璇疯緭鍏ユ纭殑鏁板瓧!');
	  return false;
	}
	if(pageno==frm.pageNo.value){
		return false;
	}
	if(pageno>0 && pageno<=parseInt(frm.totalPageCount.value)){
		page_nav(frm,pageno);
		return false;
	}else{
	  alert('椤靛彿閿欒锛�');
	  return false;
	}
}