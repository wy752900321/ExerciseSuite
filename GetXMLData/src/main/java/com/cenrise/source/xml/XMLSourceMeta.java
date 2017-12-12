package com.cenrise.source.xml;


/**
 * 元数据类，存放组件的配置信息，并负责存储和读取配置信息到文件或资源库。
 * 
 * @author jiadp
 * 
 *
 */
public class XMLSourceMeta {
	
	public static final String[] RequiredFilesDesc = new String[] { "否", "是"};
	public static final String[] RequiredFilesCode = new String[] {"N", "Y"};

	/** Array of filenames */
	private String fileName[];

	/** Wildcard or filemask (regular expression) */
	private String fileMask[];

	/** Array of boolean values as string, indicating if a file is required. */
	private String fileRequired[];

	/** Wildcard or filemask to exclude (regular expression) */
	private String excludeFileMask[];

	/** Flag indicating that we should include the filename in the output */
	private boolean includeFilename;

	/** The name of the field in the output containing the filename */
	private String filenameField;

	/** Flag indicating that a row number field should be included in the output */
	private boolean includeRowNumber;

	/** The name of the field in the output containing the row number */
	private String rowNumberField;

	/** The maximum number or lines to read */
	private long rowLimit;

	/** The number or lines to skip before starting to read */
	private String loopxpath;

	/** The fields to import... */
	private XMLSourceField inputFields[];

	/**
	 * The encoding to use for reading: null or empty string means system
	 * default encoding
	 */
	private String encoding;

	/** Is In fields */
	private String xmlField;

	/** Is In fields */
	private boolean inFields;

	/** Is a File */
	private boolean IsAFile;

	/** Flag: add result filename **/
	private boolean addResultFile;

	/** Flag: set Namespace aware **/
	private boolean nameSpaceAware;

	/** Flag: set XML Validating **/
	private boolean validating;

	/** Flag : do we process use tokens? */
	private boolean usetoken;

	/** Flag : do we ignore empty files */
	private boolean IsIgnoreEmptyFile;

	/**
	 * Array of boolean values as string, indicating if we need to fetch sub
	 * folders.
	 */
	private String includeSubFolders[];

	/** Flag : do not fail if no file */
	private boolean doNotFailIfNoFile;

	/** Flag : ignore comments */
	private boolean ignorecomments;

	/** Flag : read url as source */
	private boolean readurl;

	// Given this path activates the streaming algorithm to process large files
	private String prunePath;

	/** Additional fields **/
	private String shortFileFieldName;
	private String pathFieldName;
	private String hiddenFieldName;
	private String lastModificationTimeFieldName;
	private String uriNameFieldName;
	private String rootUriNameFieldName;
	private String extensionFieldName;
	private String sizeFieldName;

	/**
	 * @return Returns the shortFileFieldName.
	 */
    public String getShortFileNameField()
    {
    	return shortFileFieldName;
    }
    /**
	 * @param field The shortFileFieldName to set.
	 */
    public void setShortFileNameField(String field)
    {
    	shortFileFieldName=field;
    }
	
	/**
	 * @return Returns the pathFieldName.
	 */
    public String getPathField()
    {
    	return pathFieldName;
    }
    /**
	 * @param field The pathFieldName to set.
	 */
    public void setPathField(String field)
    {
    	this.pathFieldName=field;
    }
	/**
	 * @return Returns the hiddenFieldName.
	 */
    public String isHiddenField()
    {
    	return hiddenFieldName;
    }
    /**
	 * @param field The hiddenFieldName to set.
	 */
    public void setIsHiddenField(String field)
    {
    	hiddenFieldName=field;
    }
	/**
	 * @return Returns the lastModificationTimeFieldName.
	 */
    public String getLastModificationDateField()
    {
    	return lastModificationTimeFieldName;
    }
    /**
	 * @param field The lastModificationTimeFieldName to set.
	 */
    public void setLastModificationDateField(String field)
    {
    	lastModificationTimeFieldName=field;
    }
    /**
	 * @return Returns the uriNameFieldName.
	 */
    public String getUriField()
    {
    	return uriNameFieldName;
    }
    /**
	 * @param field The uriNameFieldName to set.
	 */
    public void setUriField(String field)
    {
    	uriNameFieldName=field;
    }
    /**
	 * @return Returns the uriNameFieldName.
	 */
    public String getRootUriField()
    {
    	return rootUriNameFieldName;
    }
    /**
	 * @param field The rootUriNameFieldName to set.
	 */
    public void setRootUriField(String field)
    {
    	rootUriNameFieldName=field;
    }
    /**
	 * @return Returns the extensionFieldName.
	 */
    public String getExtensionField()
    {
    	return extensionFieldName;
    }
    /**
	 * @param field The extensionFieldName to set.
	 */
    public void setExtensionField(String field)
    {
    	extensionFieldName=field;
    }
    /**
	 * @return Returns the sizeFieldName.
	 */
    public String getSizeField()
    {
    	return sizeFieldName;
    }
    /**
	 * @param field The sizeFieldName to set.
	 */
    public void setSizeField(String field)
    {
    	sizeFieldName=field;
    }
	/** 
	 * @return the add result filesname flag
	 */
	public boolean addResultFile()
	{
		return addResultFile;
	}
	

	
	/** 
	 * @return the validating flag
	 */
	public boolean isValidating()
	{
		return validating;
	}
	
	/** 
	 * @param validating the validating flag to set
	 */
	public void setValidating(boolean validating)
	{
		this.validating= validating;
	}
	/** 
	 * @return the readurl flag
	 */
	public boolean isReadUrl()
	{
		return readurl;
	}
	
	/** 
	 * @param readurl the readurl flag to set
	 */
	public void setReadUrl(boolean readurl)
	{
		this.readurl= readurl;
	}
	
	
	public void setAddResultFile(boolean addResultFile)
	{
		this.addResultFile=addResultFile;
	}
	
	/**
     * @return Returns the input fields.
     */
    public XMLSourceField[] getInputFields()
    {
        return inputFields;
    }
    
    /**
     * @param inputFields The input fields to set.
     */
    public void setInputFields(XMLSourceField[] inputFields)
    {
        this.inputFields = inputFields;
    }
    
	/**
	 * @return Returns the excludeFileMask.
	 */
	public String[] getExludeFileMask()
	{
		return excludeFileMask;
	}
	/**
	 * @param excludeFileMask The excludeFileMask to set.
	 */
	public void setExcludeFileMask(String[] excludeFileMask)
	{
		this.excludeFileMask = excludeFileMask;
	}
    
    /**
     * Get XML field.
     */
    public String getXMLField()
    {
        return xmlField;
    }
    
    /**
     * Set XML field.
     */ 
    public void setXMLField(String xmlField)
    {
        this.xmlField = xmlField;
    }
    
    /**  
     * Get the IsInFields.
     */
    public boolean isInFields()
    {
        return inFields;
    }
    
    /**  
     * @param inFields set the inFields.
     */
    public void setInFields(boolean inFields)
    {
        this.inFields = inFields;
    }

    /**
     * @return Returns the fileMask.
     */
    public String[] getFileMask()
    {
        return fileMask;
    }
    
    /**
     * @param fileMask The fileMask to set.
     */
    public void setFileMask(String[] fileMask)
    {
        this.fileMask = fileMask;
    }
    
	public String[] getFileRequired() {
		return fileRequired;
	}
    
	public void setFileRequired(String[] fileRequiredin) {
		for (int i=0;i<fileRequiredin.length;i++)
		{
			this.fileRequired[i] = getRequiredFilesCode(fileRequiredin[i]);
		}
	}

	public void setIncludeSubFolders(String[] includeSubFoldersin) {
		for (int i=0;i<includeSubFoldersin.length;i++)
		{
			this.includeSubFolders[i] = getRequiredFilesCode(includeSubFoldersin[i]);
		}
	}
	
	
    /**
     * @return Returns the fileName.
     */
    public String[] getFileName()
    {
        return fileName;
    }
    
    /**
     * @param fileName The fileName to set.
     */
    public void setFileName(String[] fileName)
    {
        this.fileName = fileName;
    }
    
    /**
     * @return Returns the filenameField.
     */
    public String getFilenameField()
    {
        return filenameField;
    }
    
    /**
     * @param filenameField The filenameField to set.
     */
    public void setFilenameField(String filenameField)
    {
        this.filenameField = filenameField;
    }
    
    /**
     * @return Returns the includeFilename.
     */
    public boolean includeFilename()
    {
        return includeFilename;
    }
    
    /**
     * @param includeFilename The includeFilename to set.
     */
    public void setIncludeFilename(boolean includeFilename)
    {
        this.includeFilename = includeFilename;
    }
    
    /**
     * @return Returns the includeRowNumber.
     */
    public boolean includeRowNumber()
    {
        return includeRowNumber;
    }
    
    /**
     * @param includeRowNumber The includeRowNumber to set.
     */
    public void setIncludeRowNumber(boolean includeRowNumber)
    {
        this.includeRowNumber = includeRowNumber;
    }
    
    /**
     * @return Returns the rowLimit.
     */
    public long getRowLimit()
    {
        return rowLimit;
    }
    
    /**
     * @param rowLimit The rowLimit to set.
     */
    public void setRowLimit(long rowLimit)
    {
        this.rowLimit = rowLimit;
    }
    
    /**
     * @return Returns the LoopXPath
     */
    public String getLoopXPath()
    {
        return loopxpath;
    }

    /**
     * @param loopxpath The loopxpath to set.
     */
    public void setLoopXPath(String loopxpath)
    {
        this.loopxpath = loopxpath;
    }
    
	/** 
	 * @param usetoken the "use token" flag to set
	 */
    public void setuseToken(boolean usetoken)
	{
		this.usetoken= usetoken;
	}
	
	/** 
	 * @return the use token flag
	 */
	public boolean isuseToken()
	{
		return usetoken;
	}
	
	/** 
	 * @return the IsIgnoreEmptyFile flag
	 */
	public boolean isIgnoreEmptyFile()
	{
		return IsIgnoreEmptyFile;
	}
	
	/** 
	 * @param IsIgnoreEmptyFile the IsIgnoreEmptyFile to set
	 */
	public void setIgnoreEmptyFile(boolean IsIgnoreEmptyFile)
	{
		this.IsIgnoreEmptyFile= IsIgnoreEmptyFile;
	}
	
	
	/** 
	 * @return the doNotFailIfNoFile flag
	 */
	public boolean isdoNotFailIfNoFile()
	{
		return doNotFailIfNoFile;
	}
	
	/** 
	 * @param doNotFailIfNoFile the doNotFailIfNoFile to set
	 */
	public void setdoNotFailIfNoFile(boolean doNotFailIfNoFile)
	{
		this.doNotFailIfNoFile= doNotFailIfNoFile;
	}
	
	/** 
	 * @return the ignorecomments flag
	 */
	public boolean isIgnoreComments()
	{
		return ignorecomments;
	}
	
	/** 
	 * @param ignorecomments the ignorecomments to set
	 */
	public void setIgnoreComments(boolean ignorecomments)
	{
		this.ignorecomments= ignorecomments;
	}
	/** 
	 * @param nameSpaceAware the name space aware flag to set
	 */
	public void setNamespaceAware(boolean nameSpaceAware)
	{
		this.nameSpaceAware= nameSpaceAware;
	}
	
	/** 
	 * @return the name space aware flag
	 */
	public boolean isNamespaceAware()
	{
		return nameSpaceAware;
	}
	
    /**
     * @return Returns the rowNumberField.
     */
    public String getRowNumberField()
    {
        return rowNumberField;
    }
    
    /**
     * @param rowNumberField The rowNumberField to set.
     */
    public void setRowNumberField(String rowNumberField)
    {
        this.rowNumberField = rowNumberField;
    }
    
    /**
     * @return the encoding
     */
    public String getEncoding()
    {
        return encoding;
    }

    /**
     * @param encoding the encoding to set
     */
    public void setEncoding(String encoding)
    {
        this.encoding = encoding;
    }    
    
    public boolean getIsAFile()
    {
    	return IsAFile;
    }    
    
    public void setIsAFile(boolean IsAFile)
    {
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
	 * @param prunePath the prunePath to set
	 */
	public void setPrunePath(String prunePath) {
		this.prunePath = prunePath;
	}
	 public String getRequiredFilesCode(String tt)
     {
    	if(tt==null) return RequiredFilesCode[0]; 
 		if(tt.equals(RequiredFilesDesc[1]))
			return RequiredFilesCode[1];
		else
			return RequiredFilesCode[0]; 
     }

}
