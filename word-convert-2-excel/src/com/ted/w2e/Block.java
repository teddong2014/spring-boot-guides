package com.ted.w2e;

public class Block {
	public Column recPosition = new Column("�Ƽ�ְλ");
	public Column name = new Column("����");
	public Column city = new Column("���ڳ���");
	public Column mobile = new Column("˽�˵绰");
	public Column ctctCnt = new Column("��ϵ����");
	public Column latestServe = new Column("�����˾");
	public Column latestPosiion = new Column("���ְλ");
	public Column memoCnt = new Column("��ע��");
	public Column mailCnt = new Column("�ʼ���");
	public Column taskCnt = new Column("������");
	public Column preCnt = new Column("ĳ����");
	public Column status = new Column("Ŀǰ״̬");
	public Column updPerson = new Column("������");
	public Column updTime = new Column("����ʱ��");
	public Column creator = new Column("������");
	public Column owner = new Column("ӵ����");
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
