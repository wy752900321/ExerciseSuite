package com.cenrise.source;

import com.cenrise.database.meta.ValueMetaInterface;

/**
 * 监控的字段信息
 * 
 * @author jiadp
 *
 */
public class XMLSourceField {

	public final static int RESULT_TYPE_VALUE_OF = 0;
	public final static int RESULT_TYPE_TYPE_SINGLE_NODE = 1;
	public final static String ResultTypeCode[] = { "valueof", "singlenode" };

	public final static int TYPE_TRIM_NONE = 0;
	public final static int TYPE_TRIM_LEFT = 1;
	public final static int TYPE_TRIM_RIGHT = 2;
	public final static int TYPE_TRIM_BOTH = 3;
	public final static String trimTypeCode[] = { "none", "left", "right",
			"both" };

	public final static int ELEMENT_TYPE_NODE = 0;
	public final static int ELEMENT_TYPE_ATTRIBUT = 1;
	public final static String ElementTypeCode[] = { "node", "attribute" };

	private String name;
	private String xpath;
	private int elementtype;// 节点(节点/属性)
	private int resulttype;// 结果类型(值/独立节点)
	private int type;// java.sql.Types
	private String format;
	private int length;
	private int precision;// 精度

	private String decimalSymbol;
	private String groupSymbol;

	public XMLSourceField(String fieldname) {
		this.name = fieldname;
		this.xpath = "";
		this.length = -1;
		this.type = ValueMetaInterface.TYPE_STRING;
		this.format = "";
		this.trimtype = TYPE_TRIM_NONE;
		this.elementtype = ELEMENT_TYPE_NODE;
		this.resulttype = RESULT_TYPE_VALUE_OF;
		this.groupSymbol = "";
		this.decimalSymbol = "";
		this.currencySymbol = "";
		this.precision = -1;
		this.repeat = false;
	}

	public XMLSourceField() {
		this("");
	}

	public boolean isRepeat() {
		return repeat;
	}

	public void setRepeat(boolean repeat) {
		this.repeat = repeat;
	}

	private String currencySymbol;// 货币符号
	private String decimalPointSymbol;// 小数点符号
	private String thousandSeparator;// 千分位分隔符
	private int trimtype;
	private boolean repeat;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getXpath() {
		return xpath;
	}

	public void setXpath(String xpath) {
		this.xpath = xpath;
	}

	public int getElementtype() {
		return elementtype;
	}

	public void setElementtype(int elementtype) {
		this.elementtype = elementtype;
	}

	public int getResulttype() {
		return resulttype;
	}

	public void setResulttype(int resulttype) {
		this.resulttype = resulttype;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public int getPrecision() {
		return precision;
	}

	public void setPrecision(int precision) {
		this.precision = precision;
	}

	public String getCurrencySymbol() {
		return currencySymbol;
	}

	public void setCurrencySymbol(String currencySymbol) {
		this.currencySymbol = currencySymbol;
	}

	public String getDecimalPointSymbol() {
		return decimalPointSymbol;
	}

	public void setDecimalPointSymbol(String decimalPointSymbol) {
		this.decimalPointSymbol = decimalPointSymbol;
	}

	public String getThousandSeparator() {
		return thousandSeparator;
	}

	public void setThousandSeparator(String thousandSeparator) {
		this.thousandSeparator = thousandSeparator;
	}

	public int getTrimtype() {
		return trimtype;
	}

	public void setTrimtype(int trimtype) {
		this.trimtype = trimtype;
	}

	public final static int getTrimTypeByCode(String tt) {
		if (tt == null)
			return 0;

		for (int i = 0; i < trimTypeCode.length; i++) {
			if (trimTypeCode[i].equalsIgnoreCase(tt))
				return i;
		}
		return 0;
	}

	public int getResultType() {
		return resulttype;
	}

	public void setResultType(int resulttype) {
		this.resulttype = resulttype;
	}

	public final static String getTrimTypeCode(int i) {
		if (i < 0 || i >= trimTypeCode.length)
			return trimTypeCode[0];
		return trimTypeCode[i];
	}

	public final static int getResultTypeByCode(String tt) {
		if (tt == null)
			return 0;

		for (int i = 0; i < ResultTypeCode.length; i++) {
			if (ResultTypeCode[i].equalsIgnoreCase(tt))
				return i;
		}

		return 0;
	}

	public final static String getResultTypeCode(int i) {
		if (i < 0 || i >= ResultTypeCode.length)
			return ResultTypeCode[0];
		return ResultTypeCode[i];
	}

	public String getResultTypeCode() {
		return getResultTypeCode(resulttype);
	}

	public String getDecimalSymbol() {
		return decimalSymbol;
	}

	public void setDecimalSymbol(String decimalSymbol) {
		this.decimalSymbol = decimalSymbol;
	}

	public String getGroupSymbol() {
		return groupSymbol;
	}

	public void setGroupSymbol(String groupSymbol) {
		this.groupSymbol = groupSymbol;
	}

}
