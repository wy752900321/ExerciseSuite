package com.cenrise.source;

import com.cenrise.database.meta.RowMetaInterface;
import com.cenrise.database.meta.ValueMetaInterface;
import com.cenrise.exception.DGFStepException;
import com.cenrise.source.variables.VariableSpace;
import com.cenrise.source.xml.FileInputList;
import com.cenrise.database.meta.RowMetaInterface;
import com.cenrise.database.meta.ValueMeta;
import com.cenrise.database.meta.ValueMetaInterface;
import com.cenrise.exception.DGFStepException;
import com.cenrise.source.variables.VariableSpace;
import com.cenrise.source.xml.FileInputList;

/**
 * 元数据类，存放组件的配置信息，并负责存储和读取配置信息到文件或资源库。
 * 
 * @author jiadp
 * 
 *
 */
public class XMLSourceMeta {

	public static final String[] RequiredFilesDesc = new String[] { "false",
			"true" };
	private static final String YES = "Y";
	public static final String[] RequiredFilesCode = new String[] { "N", "Y" };

	/** 文件/目录名称列表. */
	private String fileName[];

	/** 包含正则表达式列表 */
	private String fileMask[];

	/** 如果需要一个文件,数组的布尔值为字符串. */
	private String fileRequired[];

	/** 排除的正则表达式 */
	private String excludeFileMask[];

	/** 输出中包含文件名 */
	private boolean includeFilename;

	/** 在输出文件名中包含字段名 */
	private String filenameField;

	/** 行号字段应包含在输出中 */
	private boolean includeRowNumber;

	/** 字段的名称包含行号的输出 */
	private String rowNumberField;

	/** 最大数量或行 */
	private long rowLimit;

	/** 跳过数或行数在开始阅读 */
	private String loopxpath;

	/** 导入的字段... */
	private XMLSourceField inputFields[];

	/**
	 * 编码用于阅读:null或空字符串意味着系统 默认编码
	 */
	private String encoding;

	/** Is In fields */
	private String xmlField;

	/** Is In fields */
	private boolean inFields;

	/** Is a File */
	private boolean IsAFile;

	/** 表示:添加结果文件名 **/
	private boolean addResultFile;

	/** 表示：设置名称空间 **/
	private boolean nameSpaceAware;

	/** 表示：集XML验证 **/
	private boolean validating;

	/** 表示 : 我们处理使用令牌吗? */
	private boolean usetoken;

	/** 表示 : 我们忽略空文件吗 */
	private boolean IsIgnoreEmptyFile;

	/** 布尔值的字符串数组,表示如果我们需要获取子文件夹。 */
	private String includeSubFolders[];

	/** 表示：如果没有文件不要失败 */
	private boolean doNotFailIfNoFile;

	/** 表示：忽略注解 */
	private boolean ignorecomments;

	/** 表示：读取url作为源 */
	private boolean readurl;

	/** Flag : read url as source */
	private String prunePath;

	/** 附加字段 **/
	private String shortFileFieldName;// 文件扩展名字段名称
	private String pathFieldName;// 文件路径字段名称
	private String hiddenFieldName;// 是否为隐藏文件字段名称
	private String lastModificationTimeFieldName;// 最后修改时间字段名称
	private String uriNameFieldName;// 文件URI字段名称
	private String rootUriNameFieldName;// 文件根URI字段名称
	private String extensionFieldName;
	private String sizeFieldName;

	public XMLSourceMeta() {
		// setDefault();
	}

	/**
	 * @return Returns the shortFileFieldName.
	 */
	public String getShortFileNameField() {
		return shortFileFieldName;
	}

	/**
	 * @param field
	 *            The shortFileFieldName to set.
	 */
	public void setShortFileNameField(String field) {
		shortFileFieldName = field;
	}

	/**
	 * @return Returns the pathFieldName.
	 */
	public String getPathField() {
		return pathFieldName;
	}

	/**
	 * @param field
	 *            The pathFieldName to set.
	 */
	public void setPathField(String field) {
		this.pathFieldName = field;
	}

	/**
	 * @return Returns the hiddenFieldName.
	 */
	public String isHiddenField() {
		return hiddenFieldName;
	}

	/**
	 * @param field
	 *            The hiddenFieldName to set.
	 */
	public void setIsHiddenField(String field) {
		hiddenFieldName = field;
	}

	/**
	 * @return Returns the lastModificationTimeFieldName.
	 */
	public String getLastModificationDateField() {
		return lastModificationTimeFieldName;
	}

	/**
	 * @param field
	 *            The lastModificationTimeFieldName to set.
	 */
	public void setLastModificationDateField(String field) {
		lastModificationTimeFieldName = field;
	}

	/**
	 * @return Returns the uriNameFieldName.
	 */
	public String getUriField() {
		return uriNameFieldName;
	}

	/**
	 * @param field
	 *            The uriNameFieldName to set.
	 */
	public void setUriField(String field) {
		uriNameFieldName = field;
	}

	/**
	 * @return Returns the uriNameFieldName.
	 */
	public String getRootUriField() {
		return rootUriNameFieldName;
	}

	/**
	 * @param field
	 *            The rootUriNameFieldName to set.
	 */
	public void setRootUriField(String field) {
		rootUriNameFieldName = field;
	}

	/**
	 * @return Returns the extensionFieldName.
	 */
	public String getExtensionField() {
		return extensionFieldName;
	}

	/**
	 * @param field
	 *            The extensionFieldName to set.
	 */
	public void setExtensionField(String field) {
		extensionFieldName = field;
	}

	/**
	 * @return Returns the sizeFieldName.
	 */
	public String getSizeField() {
		return sizeFieldName;
	}

	/**
	 * @param field
	 *            The sizeFieldName to set.
	 */
	public void setSizeField(String field) {
		sizeFieldName = field;
	}

	/**
	 * @return the add result filesname flag
	 */
	public boolean addResultFile() {
		return addResultFile;
	}

	/**
	 * @return the validating flag
	 */
	public boolean isValidating() {
		return validating;
	}

	/**
	 * @param validating
	 *            the validating flag to set
	 */
	public void setValidating(boolean validating) {
		this.validating = validating;
	}

	/**
	 * @return the readurl flag
	 */
	public boolean isReadUrl() {
		return readurl;
	}

	/**
	 * @param readurl
	 *            the readurl flag to set
	 */
	public void setReadUrl(boolean readurl) {
		this.readurl = readurl;
	}

	public void setAddResultFile(boolean addResultFile) {
		this.addResultFile = addResultFile;
	}

	/**
	 * @return Returns the input fields.
	 */
	public XMLSourceField[] getInputFields() {
		return inputFields;
	}

	/**
	 * @param inputFields
	 *            The input fields to set.
	 */
	public void setInputFields(XMLSourceField[] inputFields) {
		this.inputFields = inputFields;
	}

	/**
	 * @return Returns the excludeFileMask.
	 */
	public String[] getExludeFileMask() {
		return excludeFileMask;
	}

	/**
	 * @param excludeFileMask
	 *            The excludeFileMask to set.
	 */
	public void setExcludeFileMask(String[] excludeFileMask) {
		this.excludeFileMask = excludeFileMask;
	}

	/**
	 * Get XML field.
	 */
	public String getXMLField() {
		return xmlField;
	}

	/**
	 * Set XML field.
	 */
	public void setXMLField(String xmlField) {
		this.xmlField = xmlField;
	}

	/**
	 * Get the IsInFields.
	 */
	public boolean isInFields() {
		return inFields;
	}

	/**
	 * @param inFields
	 *            set the inFields.
	 */
	public void setInFields(boolean inFields) {
		this.inFields = inFields;
	}

	/**
	 * @return Returns the fileMask.
	 */
	public String[] getFileMask() {
		return fileMask;
	}

	/**
	 * @param fileMask
	 *            The fileMask to set.
	 */
	public void setFileMask(String[] fileMask) {
		this.fileMask = fileMask;
	}

	public String[] getFileRequired() {
		return fileRequired;
	}

	public void setFileRequired(String[] fileRequiredin) {
		this.fileRequired = fileRequiredin;
		// for (int i = 0; i < fileRequiredin.length; i++) {
		// this.fileRequired[i] = getRequiredFilesCode(fileRequiredin[i]);
		// }
	}

	public void setIncludeSubFolders(String[] includeSubFoldersin) {
		this.includeSubFolders = includeSubFoldersin;
		/*
		 * for (int i = 0; i < includeSubFoldersin.length; i++) {
		 * this.includeSubFolders[i] =
		 * getRequiredFilesCode(includeSubFoldersin[i]); }
		 */
	}

	/**
	 * @return Returns the fileName.
	 */
	public String[] getFileName() {
		return fileName;
	}

	/**
	 * @param fileName
	 *            The fileName to set.
	 */
	public void setFileName(String[] fileName) {
		this.fileName = fileName;
	}

	/**
	 * @return Returns the filenameField.
	 */
	public String getFilenameField() {
		return filenameField;
	}

	/**
	 * @param filenameField
	 *            The filenameField to set.
	 */
	public void setFilenameField(String filenameField) {
		this.filenameField = filenameField;
	}

	/**
	 * @return Returns the includeFilename.
	 */
	public boolean includeFilename() {
		return includeFilename;
	}

	/**
	 * @param includeFilename
	 *            The includeFilename to set.
	 */
	public void setIncludeFilename(boolean includeFilename) {
		this.includeFilename = includeFilename;
	}

	/**
	 * @return Returns the includeRowNumber.
	 */
	public boolean includeRowNumber() {
		return includeRowNumber;
	}

	/**
	 * @param includeRowNumber
	 *            The includeRowNumber to set.
	 */
	public void setIncludeRowNumber(boolean includeRowNumber) {
		this.includeRowNumber = includeRowNumber;
	}

	/**
	 * @return Returns the rowLimit.
	 */
	public long getRowLimit() {
		return rowLimit;
	}

	/**
	 * @param rowLimit
	 *            The rowLimit to set.
	 */
	public void setRowLimit(long rowLimit) {
		this.rowLimit = rowLimit;
	}

	/**
	 * @return Returns the LoopXPath
	 */
	public String getLoopXPath() {
		return loopxpath;
	}

	/**
	 * @param loopxpath
	 *            The loopxpath to set.
	 */
	public void setLoopXPath(String loopxpath) {
		this.loopxpath = loopxpath;
	}

	/**
	 * @param usetoken
	 *            the "use token" flag to set
	 */
	public void setuseToken(boolean usetoken) {
		this.usetoken = usetoken;
	}

	/**
	 * @return the use token flag
	 */
	public boolean isuseToken() {
		return usetoken;
	}

	/**
	 * @return the IsIgnoreEmptyFile flag
	 */
	public boolean isIgnoreEmptyFile() {
		return IsIgnoreEmptyFile;
	}

	/**
	 * @param IsIgnoreEmptyFile
	 *            the IsIgnoreEmptyFile to set
	 */
	public void setIgnoreEmptyFile(boolean IsIgnoreEmptyFile) {
		this.IsIgnoreEmptyFile = IsIgnoreEmptyFile;
	}

	/**
	 * @return the doNotFailIfNoFile flag
	 */
	public boolean isdoNotFailIfNoFile() {
		return doNotFailIfNoFile;
	}

	/**
	 * @param doNotFailIfNoFile
	 *            the doNotFailIfNoFile to set
	 */
	public void setdoNotFailIfNoFile(boolean doNotFailIfNoFile) {
		this.doNotFailIfNoFile = doNotFailIfNoFile;
	}

	/**
	 * @return the ignorecomments flag
	 */
	public boolean isIgnoreComments() {
		return ignorecomments;
	}

	/**
	 * @param ignorecomments
	 *            the ignorecomments to set
	 */
	public void setIgnoreComments(boolean ignorecomments) {
		this.ignorecomments = ignorecomments;
	}

	/**
	 * @param nameSpaceAware
	 *            the name space aware flag to set
	 */
	public void setNamespaceAware(boolean nameSpaceAware) {
		this.nameSpaceAware = nameSpaceAware;
	}

	/**
	 * @return the name space aware flag
	 */
	public boolean isNamespaceAware() {
		return nameSpaceAware;
	}

	/**
	 * @return Returns the rowNumberField.
	 */
	public String getRowNumberField() {
		return rowNumberField;
	}

	/**
	 * @param rowNumberField
	 *            The rowNumberField to set.
	 */
	public void setRowNumberField(String rowNumberField) {
		this.rowNumberField = rowNumberField;
	}

	/**
	 * @return the encoding
	 */
	public String getEncoding() {
		return encoding;
	}

	/**
	 * @param encoding
	 *            the encoding to set
	 */
	public void setEncoding(String encoding) {
		this.encoding = encoding;
	}

	public boolean getIsAFile() {
		return IsAFile;
	}

	public void setIsAFile(boolean IsAFile) {
		this.IsAFile = IsAFile;
	}

	/**
	 * @return the prunePath
	 */
	public String getPrunePath() {
		return prunePath;
	}

	public String[] getIncludeSubFolders() {
		return includeSubFolders;
	}

	/**
	 * @param prunePath
	 *            the prunePath to set
	 */
	public void setPrunePath(String prunePath) {
		this.prunePath = prunePath;
	}

	public String getRequiredFilesCode(String tt) {
		if (tt == null)
			return RequiredFilesCode[0];
		if (tt.equals(RequiredFilesDesc[1]))
			return RequiredFilesCode[1];
		else
			return RequiredFilesCode[0];
	}

	public FileInputList getFiles(VariableSpace space) {
		return FileInputList.createFileList(space, fileName, fileMask,
				excludeFileMask, fileRequired, includeSubFolderBoolean());
	}

	private boolean[] includeSubFolderBoolean() {
		int len = fileName.length;
		boolean includeSubFolderBoolean[] = new boolean[len];
		for (int i = 0; i < len; i++) {
			includeSubFolderBoolean[i] = YES
					.equalsIgnoreCase(includeSubFolders[i]);
		}
		return includeSubFolderBoolean;
	}

	public void getFields(RowMetaInterface r, String name,
                          RowMetaInterface info[],/* StepMeta nextStep, */VariableSpace space)
			throws DGFStepException {
		for (int i = 0; i < inputFields.length; i++) {
			XMLSourceField field = inputFields[i];

			int type = field.getType();
			if (type == ValueMeta.TYPE_NONE)
				type = ValueMeta.TYPE_STRING;
			ValueMetaInterface v = new ValueMeta(
					space.environmentSubstitute(field.getName()), type);
			v.setLength(field.getLength());
			v.setPrecision(field.getPrecision());
			v.setOrigin(name);
			v.setConversionMask(field.getFormat());
			v.setDecimalSymbol(field.getDecimalSymbol());
			v.setGroupingSymbol(field.getGroupSymbol());
			v.setCurrencySymbol(field.getCurrencySymbol());
			r.addValueMeta(v);
		}

		if (includeFilename) {
			ValueMetaInterface v = new ValueMeta(
					space.environmentSubstitute(filenameField),
					ValueMeta.TYPE_STRING);
			v.setLength(250);
			v.setPrecision(-1);
			v.setOrigin(name);
			r.addValueMeta(v);
		}

		if (includeRowNumber) {
			ValueMetaInterface v = new ValueMeta(
					space.environmentSubstitute(rowNumberField),
					ValueMeta.TYPE_INTEGER);
			v.setLength(ValueMetaInterface.DEFAULT_INTEGER_LENGTH, 0);
			v.setOrigin(name);
			r.addValueMeta(v);
		}
		// Add additional fields

		if (getShortFileNameField() != null
				&& getShortFileNameField().length() > 0) {
			ValueMetaInterface v = new ValueMeta(
					space.environmentSubstitute(getShortFileNameField()),
					ValueMeta.TYPE_STRING);
			v.setLength(100, -1);
			v.setOrigin(name);
			r.addValueMeta(v);
		}
		if (getExtensionField() != null && getExtensionField().length() > 0) {
			ValueMetaInterface v = new ValueMeta(
					space.environmentSubstitute(getExtensionField()),
					ValueMeta.TYPE_STRING);
			v.setLength(100, -1);
			v.setOrigin(name);
			r.addValueMeta(v);
		}
		if (getPathField() != null && getPathField().length() > 0) {
			ValueMetaInterface v = new ValueMeta(
					space.environmentSubstitute(getPathField()),
					ValueMeta.TYPE_STRING);
			v.setLength(100, -1);
			v.setOrigin(name);
			r.addValueMeta(v);
		}
		if (getSizeField() != null && getSizeField().length() > 0) {
			ValueMetaInterface v = new ValueMeta(
					space.environmentSubstitute(getSizeField()),
					ValueMeta.TYPE_INTEGER);
			v.setOrigin(name);
			v.setLength(9);
			r.addValueMeta(v);
		}
		if (isHiddenField() != null && isHiddenField().length() > 0) {
			ValueMetaInterface v = new ValueMeta(
					space.environmentSubstitute(isHiddenField()),
					ValueMeta.TYPE_BOOLEAN);
			v.setOrigin(name);
			r.addValueMeta(v);
		}

		if (getLastModificationDateField() != null
				&& getLastModificationDateField().length() > 0) {
			ValueMetaInterface v = new ValueMeta(
					space.environmentSubstitute(getLastModificationDateField()),
					ValueMeta.TYPE_DATE);
			v.setOrigin(name);
			r.addValueMeta(v);
		}
		if (getUriField() != null && getUriField().length() > 0) {
			ValueMetaInterface v = new ValueMeta(
					space.environmentSubstitute(getUriField()),
					ValueMeta.TYPE_STRING);
			v.setLength(100, -1);
			v.setOrigin(name);
			r.addValueMeta(v);
		}

		if (getRootUriField() != null && getRootUriField().length() > 0) {
			ValueMetaInterface v = new ValueMeta(
					space.environmentSubstitute(getRootUriField()),
					ValueMeta.TYPE_STRING);
			v.setLength(100, -1);
			v.setOrigin(name);
			r.addValueMeta(v);
		}
	}
}
