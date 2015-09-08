package db.his.domain;

import java.util.List;

public class Page {
	private int totalrecord;//记录总记录数
	private int totalpage;//记录总页数
	private int pagesize=5;//页面大小
	private List list;//记住页面数据
	private int pagenum;//记住页号
	private int startindex;//开始取位置
	private String url;//记住地址
	
	public Page(int pagenum,int totalrecord){
		this.pagenum=pagenum;
		this.totalrecord=totalrecord;
	//算出总页数
		this.totalpage = (this.totalrecord+this.pagesize-1)/this.pagesize;
	//算出用户想看的页的数据从数据库哪个地方开始取
		this.startindex = (this.pagenum-1)*this.pagesize;
	}
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getTotalrecord() {
		return totalrecord;
	}

	public void setTotalrecord(int totalrecord) {
		this.totalrecord = totalrecord;
	}

	public int getTotalpage() {
		return totalpage;
	}

	public void setTotalpage(int totalpage) {
		this.totalpage = totalpage;
	}

	public int getPagesize() {
		return pagesize;
	}

	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}

	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}

	public int getPagenum() {
		return pagenum;
	}

	public void setPagenum(int pagenum) {
		this.pagenum = pagenum;
	}

	public int getStartindex() {
		return startindex;
	}

	public void setStartindex(int startindex) {
		this.startindex = startindex;
	}
	
}
