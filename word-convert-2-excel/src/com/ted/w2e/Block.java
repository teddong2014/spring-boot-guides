package com.ted.w2e;

public class Block {
	public Column recPosition = new Column("推荐职位");
	public Column name = new Column("姓名");
	public Column city = new Column("所在城市");
	public Column mobile = new Column("私人电话");
	public Column ctctCnt = new Column("联系次数");
	public Column latestServe = new Column("最近公司");
	public Column latestPosiion = new Column("最近职位");
	public Column memoCnt = new Column("备注数");
	public Column mailCnt = new Column("邮件数");
	public Column taskCnt = new Column("任务数");
	public Column preCnt = new Column("某比率");
	public Column status = new Column("目前状态");
	public Column updPerson = new Column("更新人");
	public Column updTime = new Column("更新时间");
	public Column creator = new Column("创建人");
	public Column owner = new Column("拥有者");
	@Override
	public String toString() {
		return "[" + recPosition.toString() + ","
				+ name.toString() + ","
				+ city.toString() + ","
				+ mobile.toString() + ","
				+ ctctCnt.toString() + ","
				+ latestServe.toString() + ","
				+ latestPosiion.toString() + ","
				+ memoCnt.toString() + ","
				+ mailCnt.toString() + ","
				+ taskCnt.toString() + ","
				+ preCnt.toString() + ","
				+ status.toString() + ","
				+ updPerson.toString() + ","
				+ updTime.toString() + ","
				+ creator.toString() + ","
				+ owner.toString() + "]";
	}
}
