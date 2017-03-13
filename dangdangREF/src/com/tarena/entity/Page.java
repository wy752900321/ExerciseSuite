package com.tarena.entity;

import java.io.Serializable;

public class Page implements Serializable {
	private static final long serialVersionUID = 1L;
	private int pageNo = 1;// 当前页
	private int pageSize = 2;// 每页显示的条数
	private int begin;// 起始位置
	private int sumCount;// 总页数
	private int sumItem;// 总条数
	private String pageInfo;// 页面显示的信息
	private int prevPage;//获取前一页
	private int nextPage;//获取下一页
	

	public Page() {
	}

	public Page(int pageNo) {
		super();
		this.pageNo = pageNo;
	}

	public Page(int pageNo, int pageSize) {
		super();
		this.pageNo = pageNo;
		this.pageSize = pageSize;
	}

	public int getPrevPage() {
		return this.pageNo-1;
	}

	public void setPrevPage(int prevPage) {
		this.prevPage = prevPage;
	}

	public int getNextPage() {
		return this.pageNo+1;
	}

	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}

	public int getSumCount() {
		if (sumItem % pageSize == 0) {
			sumCount = sumItem / pageSize;
		} else {
			sumCount = sumItem / pageSize + 1;
		}
		return sumCount;
	}

	public void setPageInfo(String pageInfo) {
		this.pageInfo = pageInfo;
	}

	public void setSumCount(int sumCount) {
		this.sumCount = sumCount;
	}

	public int getSumItem() {
		return sumItem;
	}

	public void setSumItem(int sumItem) {
		this.sumItem = sumItem;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getBegin() {
		return (pageNo - 1) * pageSize;
	}

	public void setBegin(int begin) {
		this.begin = begin;
	}

	// 获取首页、上一页、下一页、尾页
	private String getFirstNextLastPage() {
		String info = "";
		if (pageNo != 1) {
			// 获取首页
			info += "<a href=\"javascript:subPage(1)\">首页</a>\n";
			// 获取上一页
			info += "<a href=\"javascript:subPage("+getPrevPage()+")\">上一页</a>\n";
		}
		if (pageNo !=getSumCount()) {
			// 获取下一页
			info += "<a href=\"javascript:subPage("+getNextPage()+")\">下一页</a>\n";
			// 获取尾页
			info += "<a href=\"javascript:subPage("+getSumCount()+")\">尾页</a>\n";
		}
		return info;
	}

	//获取上一页
	private String getFirstPrev(){
		String info ="";
		//首页
		String first="<div class='list_r_title_text3a'><img src='../images/page_up_gray.gif' /></div>\r\n";
		//上一页
		String prev="<div class='list_r_title_text3a'><a name=link_page_next href=\"javascript:subPage("+getPrevPage()+")\"><img src='../images/page_up.gif' /></a></div>\r\n";
		
		if(pageNo==1){
         //首页
			info+=first;
		}
		if(pageNo!=1){
			info+=prev;
		}
		return info;
	}
	
	// 获取 ［第？页/ 共？页］
	private String getPageNoInfo(){
		return "<div class='list_r_title_text3b'>[第"+pageNo+"页/共"+getSumCount()+"页]</div>\r\n";
	}
	
	//获取下一页
	private String getNextLast(){
		String info="";
		//下一页
		String next="<div class='list_r_title_text3a'><a name=link_page_next href=\"javascript:subPage("+getNextPage()+")\"><img src='../images/page_down.gif' /></a></div>\r\n";
		//尾页
		String last="<div class='list_r_title_text3a'><img src='../images/page_down_gray.gif' /></div>\r\n";
		if(pageNo!=getSumCount()){
	           //下一页
				info+=next;
			}
			if(pageNo==getSumCount()){
				//最后一页
				info+=last;
			}
		return info;
	}
	
    //获取js
	private String getScript(){
		String info="<script type=\"text/javascript\">"+"\n"+
			              "function subPage(pageNo){"+"\n"+
		                  "document.form1.elements[\"page.pageNo\"].value=pageNo;"+"\n"+
	                  	"document.form1.submit();"+"\n"+
	                 "}"+"\n"+
	              "</script>"+"\n";
		return info;
	}
	public String getPageInfo() {
		String info = "";
		//获取js
		info+=getScript();
		// 获取隐藏域
		info += "<input type=\"hidden\" name=\"page.pageNo\" value=\"1\"/>\n";
    	//获取上一页
		info+=getFirstPrev();
		//  获取 ［第？页/ 共？页］
		info+=getPageNoInfo();
    	//获取下一页
		info+=getNextLast();
		return info;
	}

	public static void main(String[] args) {
		Page page = new Page();
		System.out.println(page.getPageInfo());
	}
}
