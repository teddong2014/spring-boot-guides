package com.ted.w2e;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.AreaReference;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFTable;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTable;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableColumn;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableColumns;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableStyleInfo;

public class W2EMain {

	public static XWPFDocument doc;
	public static File docFile = null;
	public static Pattern emptyLine = Pattern.compile("\\s*");
	public static final Pattern line0 = Pattern.compile("^推荐职位([\u4e00-\u9fa5]*)$");
	//刘洋[北京][1984-07-19][硕士][3年][私人18701699527]2
	public static final Pattern line1 = Pattern.compile(
			"^(.+)(\\[[\u4e00-\u9fa5]+\\])(\\[\\d{4}-\\d{2}-\\d{2}\\])(\\[[\u4e00-\u9fa5]+]\\])(\\[\\d+年\\])\\[私人(\\d{11})\\](\\d+)$|^([\u4e00-\u9fa5]+)\\[私人(\\d{11})\\](\\d+[\u4e00-\u9fa5]*)$");
	public static final Pattern line2 = Pattern.compile("^最近公司([\u4e00-\u9fa5|\\(\\)]+)--(.*)$");
	public static final Pattern line3 = Pattern.compile("^备注(\\d+)邮件(\\d+)任务(\\d+)pre-CVS0CVS0CCM0Floating(\\d+)$");
	public static final Pattern line4 = Pattern.compile("^([\u4e00-\u9fa5]+)|(异动指数\\d+%[\u4e00-\u9fa5]*)$");
	public static final Pattern line5 = Pattern
			.compile("^更新：([\u4e00-\u9fa5]+)\\s(\\d{4}-\\d{2}-\\d{2}\\s\\d{2}:\\d{2})$");
	public static final Pattern line6 = Pattern.compile("^创建者：([\u4e00-\u9fa5]+)$");
	public static final Pattern line7 = Pattern.compile("^拥有者：([\u4e00-\u9fa5]+)$");

	/*public static void main(String[] args) throws Exception {
		InputStream fis = null;
		try {
//			docFile = new File("C:\\Users\\Administrator\\Downloads\\阿里巴巴 - 副本.docx");
			docFile = new File("C:\\Users\\Administrator\\Downloads\\阿里巴巴.docx");
			fis = new FileInputStream(docFile);
			doc = new XWPFDocument(fis);
		} finally {
			if (fis != null) {
				try {
					fis.close();
					fis = null;
				} catch (IOException ioEx) {
					System.out.println("IOException caught trying to close " + "FileInputStream in the constructor of "
							+ "UpdateEmbeddedDoc.");
				}
			}
		}
		Workbook wb = new XSSFWorkbook();
		XSSFSheet sheet = createTable(wb);
		resolveBlock(sheet);
		write2File(wb);
	}*/
	
	public static XSSFSheet createTable(Workbook wb) throws FileNotFoundException, IOException {

		XSSFSheet sheet = (XSSFSheet) wb.createSheet();

		// Create
		XSSFTable table = sheet.createTable();
		table.setDisplayName("Test");
		CTTable cttable = table.getCTTable();

		// Style configurations
		CTTableStyleInfo style = cttable.addNewTableStyleInfo();
		style.setName("TableStyleMedium2");
		style.setShowColumnStripes(false);
		style.setShowRowStripes(true);

		//Set which area the table should be placed in
        AreaReference reference = new AreaReference(new CellReference(0, 0), 
                new CellReference(1000, 15));
        cttable.setRef(reference.formatAsString());
        cttable.setId(1);
        cttable.setName("Test");
        cttable.setTotalsRowCount(1);
        
        CTTableColumns columns = cttable.addNewTableColumns();
        columns.setCount(16);
        CTTableColumn column;
        XSSFRow row;
        XSSFCell cell;
        String[] headers = new String[]{
        		"推荐职位", 
        		"姓名", 
        		"所在城市",
        		"私人电话",
        		"联系次数",
        		"最近公司",
        		"最近职位",
        		"备注数",
        		"邮件数",
        		"任务数",
        		"某比率",
        		"目前状态",
        		"更新人",
        		"更新时间",
        		"创建人",
        		"拥有者"};
        for(int i=0; i<headers.length; i++) {
            //Create column
            column = columns.addNewTableColumn();
            column.setName("Column");
            column.setId(i+1);
            
        }
        
        //Create row
        row = sheet.createRow(0);
        for(int j=0; j<headers.length; j++) {
            //Create cell
            cell = row.createCell(j);
            cell.setCellValue(headers[j]);
        }
		return sheet;
	}
	
	public static void createRow(XSSFSheet sheet, Block block, int rowNum) {
		XSSFRow row = sheet.createRow(rowNum);
		XSSFCell cell;
		cell = row.createCell(0);
        cell.setCellValue(block.recPosition.getValue());
        cell = row.createCell(1);
        cell.setCellValue(block.name.getValue());
        cell = row.createCell(2);
        cell.setCellValue(block.city.getValue());
        cell = row.createCell(3);
        cell.setCellValue(block.mobile.getValue());
        cell = row.createCell(4);
        cell.setCellValue(block.ctctCnt.getValue());
        cell = row.createCell(5);
        cell.setCellValue(block.latestServe.getValue());
        cell = row.createCell(6);
        cell.setCellValue(block.latestPosiion.getValue());
        cell = row.createCell(7);
        cell.setCellValue(block.memoCnt.getValue());
        cell = row.createCell(8);
        cell.setCellValue(block.mailCnt.getValue());
        cell = row.createCell(9);
        cell.setCellValue(block.taskCnt.getValue());
        cell = row.createCell(10);
        cell.setCellValue(block.preCnt.getValue());
        cell = row.createCell(11);
        cell.setCellValue(block.status.getValue());
        cell = row.createCell(12);
        cell.setCellValue(block.updPerson.getValue());
        cell = row.createCell(13);
        cell.setCellValue(block.updTime.getValue());
        cell = row.createCell(14);
        cell.setCellValue(block.creator.getValue());
        cell = row.createCell(15);
        cell.setCellValue(block.owner.getValue());
	}
	
	public static void write2File(Workbook wb) throws Exception {
		FileOutputStream fileOut = new FileOutputStream("C:\\Users\\Administrator\\Downloads\\2.xlsx");
		wb.write(fileOut);
		fileOut.close();
	}
	
	public static void resolveBlock(XSSFSheet sheet) throws OpenXML4JException, IOException {
		List<XWPFParagraph> paragraphs = doc.getParagraphs();
		Block block = null;
		int rowNum = 1;
		List<String> blockLines = null;
		boolean isBlockSupported = true;
		for (XWPFParagraph para : paragraphs) {
			String line = para.getParagraphText();
			if (emptyLine.matcher(line).matches()) {
				continue;
			} else {
				if (isBlockBegin(line)) {
					isBlockSupported = true;
					blockLines = new ArrayList<String>();
					blockLines.add(line);
					continue;
				}
				if (isBlockEnd(line)) {
					blockLines.add(line);
					if (isBlockSupported) {
						block = new Block();
						for (int i = 0; i < blockLines.size(); i++) {
							String resolveLine = blockLines.get(i);
							switch (i) {
							case 0:
								resolveLine0(resolveLine, block);
							case 1:
								resolveLine1(resolveLine, block);
								break;
							case 2:
								resolveLine2(resolveLine, block);
								break;
							case 3:
								resolveLine3(resolveLine, block);
								break;
							case 4:
								resolveLine4(resolveLine, block);
								break;
							case 5:
								resolveLine5(resolveLine, block);
								break;
							case 6:
								resolveLine6(resolveLine, block);
								break;
							case 7:
								resolveLine7(resolveLine, block);
							default:
								break;
							}
						}
						createRow(sheet, block, rowNum);
						rowNum ++;
					}
					continue;
				}
				if (!isLineSupported(line)) {
					System.out.println("异常格式行：" + line);
					isBlockSupported = false;
				} else {
					blockLines.add(line);
				}
			}
		}
	}

	private static boolean isBlockBegin(String text) {
		if (text.startsWith("推荐职位")) {
			return true;
		} else {
			return false;
		}
	}

	private static boolean isBlockEnd(String text) {
		if (text.startsWith("拥有者")) {
			return true;
		} else {
			return false;
		}
	}

	private static boolean isLineSupported(String line) {
		if (line1.matcher(line).matches()
				|| line2.matcher(line).matches()
				|| line3.matcher(line).matches()
				|| line4.matcher(line).matches()
				|| line5.matcher(line).matches()
				|| line6.matcher(line).matches()
				) {
			return true;
		} else {
			return false;
		}
	}
	
	private static void resolveLine0(String line, Block block) {
		Matcher matcher = line0.matcher(line);
		if (matcher.find()) {
			String group1 = matcher.group(1);
			block.recPosition.setValue(group1);
		}
	}

	private static void resolveLine1(String line, Block block) {
		Matcher matcher = line1.matcher(line);
		if (matcher.find()) {
			String group1 = matcher.group(1);
			String group2 = matcher.group(2);
			String group3 = matcher.group(3);
			String group4 = matcher.group(4);
			String group5 = matcher.group(5);
			String group6 = matcher.group(6);
			String group7 = matcher.group(7);
			if (group1 != null) {
				block.name.setValue(group1);
				block.city.setValue(group2);
				block.mobile.setValue(group3);
				block.ctctCnt.setValue(group4);
			} else {
				block.name.setValue(group5);
				block.mobile.setValue(group6);
				block.ctctCnt.setValue(group7);
			}
		}
	}

	private static void resolveLine2(String line, Block block) {
		Matcher matcher = line2.matcher(line);
		if (matcher.find()) {
			String group1 = matcher.group(1);
			String group2 = matcher.group(2);
			block.latestServe.setValue(group1);
			block.latestPosiion.setValue(group2);
		}
	}

	private static void resolveLine3(String line, Block block) {
		Matcher matcher = line3.matcher(line);
		if (matcher.find()) {
			String group1 = matcher.group(1);
			String group2 = matcher.group(2);
			String group3 = matcher.group(3);
			String group4 = matcher.group(4);
			block.memoCnt.setValue(group1);
			block.mailCnt.setValue(group2);
			block.taskCnt.setValue(group3);
			block.preCnt.setValue(group4);
		}
	}

	private static void resolveLine4(String line, Block block) {
		Matcher matcher = line4.matcher(line);
		if (matcher.find()) {
			String group1 = matcher.group(1);
			String group2 = matcher.group(2);
			if (group1 != null && "".equals(group1.trim())) {
				block.status.setValue(group1);
			} else {
				block.status.setValue(group2);
			}
		}
	}

	private static void resolveLine5(String line, Block block) {
		Matcher matcher = line5.matcher(line);
		if (matcher.find()) {
			String group1 = matcher.group(1);
			String group2 = matcher.group(2);
			block.updPerson.setValue(group1);
			block.updTime.setValue(group2);
		}
	}

	private static void resolveLine6(String line, Block block) {
		Matcher matcher = line6.matcher(line);
		if (matcher.find()) {
			String group1 = matcher.group(1);
			block.creator.setValue(group1);
		}
	}

	private static void resolveLine7(String line, Block block) {
		Matcher matcher = line7.matcher(line);
		if (matcher.find()) {
			String group1 = matcher.group(1);
			block.owner.setValue(group1);
		}
	}

	
	 public static void main(String[] args) { 
		 // String text = "推荐职位";
	 
	 // String text = "丁洁[私人13858073197]1"; 
	 // String text = "闫立伟[深圳][私人15902000200]2";
	 
	 // String text = "最近公司阿里巴巴--运营专家"; // String text = "最近公司阿里巴巴--";
	 
	 // String text = "备注1邮件0任务0pre-CVS0CVS0CCM0Floating0";
	 
	 // String text = "现状稳定";
	  
	 // String text = "更新：廖文杰 2016-04-21 14:24";
	 
	 // String text = "创建者：管理员";
//	 String text = "刘洋[北京][1984-07-19][硕士][3年][私人18701699527]2";
	 String text = "刘洋[北京][1984-07-19][硕士][3年][私人18701699527]2未知";
	 Pattern line = Pattern.compile(
				"^"
				+ "((\\w+)|([\u4e00-\u9fa5]+))" // 姓名：全中文或者全中文
				+ "\\[([\u4e00-\u9fa5]+)\\]" // 地区：全中文
				+ "(\\[(\\d{4}-\\d{2}-\\d{2})\\]|)" // 出生日期：可为空
				+ "(\\[([\u4e00-\u9fa5]+)\\]|)" // 学历：可为空
				+ "(\\[(\\d+年)\\]|)" // 工作经验：可为空
				+ "\\[私人(\\d{11})\\]" // 手机号
				+ "(\\d+)" // 联系次数
				+ "([\u4e00-\u9fa5]+|)" // 其他：可为空 
				+ "$"
				);
	 Matcher matcher = line.matcher(text);
	 if (matcher.find()) {
		for (int i = 0; i <= matcher.groupCount(); i++) {
			System.out.println(i + " : " + matcher.group(i));
		}
		// 3
		// 4
		// 6
		// 8
		// 10
		// 11
		// 12
		// 13
	}
//	 Block block = new Block(); 
//	 new W2EMain().resolveLine1(text, block);
//	 System.out.println(block); 
	 }
	 
}
