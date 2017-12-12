package com.cenrise.source.xml;

import java.text.DateFormatSymbols;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.tools.FileObject;
import javax.xml.parsers.SAXParser;

import com.cenrise.database.meta.RowMetaInterface;

/**
 * 数据类，存放组件运行时数据
 * 
 * @author jiadp
 *
 */
public class XMLSourceData {
	public String thisline, nextline, lastline;
	public Object[] previousRow;
	public Object[] thisRow;
	public RowMetaInterface inputRowMeta;
	public RowMetaInterface outputRowMeta;
	public RowMetaInterface convertRowMeta;
	public int nr_repeats;

	public NumberFormat nf;
	public DecimalFormat df;
	public DecimalFormatSymbols dfs;
	public SimpleDateFormat daf;
	public DateFormatSymbols dafs;

	public int nrInputFields;
	public boolean stopPruning; // used for a trick to stop the reader in
								// pruning mode
	public boolean errorInRowButContinue; // true when actual row has an error
											// and error handling is active:
											// means continue (error handling in
											// this step should be redesigned)

	public int nrReadRow;

	public FileObject file;
	public int filenr;

	public int itemCount;
	public int itemPosition;
	public long rownr;
	public int indexOfXmlField;

	RowMetaInterface outputMeta;

	public String filename;
	public String shortFilename;
	public String path;
	public String extension;
	public boolean hidden;
	public Date lastModificationDateTime;
	public String uriName;
	public String rootUriName;
	public long size;

	public SAXParser saxParser;

	public XMLSourceHandler xmlHandler;
	public boolean last_file;
	public List<Map<String, String>> rowList;
	public Map<String, String> thisRowMap;
	public Object[] readrow;
	public int totalpreviousfields;

	/**
	 * 
	 */
	public XMLSourceData() {

		thisline = null;
		nextline = null;
		nf = NumberFormat.getInstance();
		df = (DecimalFormat) nf;
		dfs = new DecimalFormatSymbols();
		daf = new SimpleDateFormat();
		dafs = new DateFormatSymbols();

		nr_repeats = 0;
		previousRow = null;
		filenr = 0;

		indexOfXmlField = -1;

		nrInputFields = -1;
		stopPruning = false;
		errorInRowButContinue = false;
		nrReadRow = 0;
		readrow = null;
		totalpreviousfields = 0;
	}
}
