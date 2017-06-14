package org.kettlesolutions.plugin.step.helloworld;

import java.util.List;
import java.util.Map;

import org.pentaho.di.core.CheckResult;
import org.pentaho.di.core.CheckResultInterface;
import org.pentaho.di.core.Const;
import org.pentaho.di.core.Counter;
import org.pentaho.di.core.annotations.Step;
import org.pentaho.di.core.database.DatabaseMeta;
import org.pentaho.di.core.exception.KettleException;
import org.pentaho.di.core.exception.KettleStepException;
import org.pentaho.di.core.exception.KettleXMLException;
import org.pentaho.di.core.row.RowMetaInterface;
import org.pentaho.di.core.row.ValueMeta;
import org.pentaho.di.core.row.ValueMetaInterface;
import org.pentaho.di.core.variables.VariableSpace;
import org.pentaho.di.core.xml.XMLHandler;
import org.pentaho.di.i18n.BaseMessages;
import org.pentaho.di.repository.ObjectId;
import org.pentaho.di.repository.Repository;
import org.pentaho.di.trans.Trans;
import org.pentaho.di.trans.TransMeta;
import org.pentaho.di.trans.step.BaseStepMeta;
import org.pentaho.di.trans.step.StepDataInterface;
import org.pentaho.di.trans.step.StepInterface;
import org.pentaho.di.trans.step.StepMeta;
import org.pentaho.di.trans.step.StepMetaInterface;
import org.w3c.dom.Node;

@Step(
		id="Helloworld",
		name="name",
		description="description",
		categoryDescription="categoryDescription", 
		image="org/kettlesolutions/plugin/step/helloworld/HelloWorld.png",
		i18nPackageName="org.kettlesolutions.plugin.step.helloworld"
) 
public class HelloworldStepMeta extends BaseStepMeta implements StepMetaInterface {
	/**
	 * PKG变量说明了messages包的位置，在messages包里有各种国际化的资源文件。
	 * 在本章后面经常要看到的BaseMessages.getString()方法，就是根据软件的国际化
	 * 设置，从不同的文件中获取文字。PKG变量通常位于类的最上方，被国际化图形工具使用，
	 * 通过国际化图形工具，国际化人员可以编辑不同的国际化资源文件。所以我们会在很多Kettle
	 * 代码里看见这样的结构。
	 */
	private static Class<?> PKG = HelloworldStep.class; //for i18n
	public enum Tag {//field_name用于保存用户输入的字段名：保存“Hello，world！"字符串的字段名。
		field_name,
	};
	
	private String fieldName;
	
	/**
	 * @return the fieldName
	 */
	public String getFieldName() {
		return fieldName;
	}

	/**
	 * @param fieldName the fieldName to set
	 */
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	/**
	 * checks parameters, adds result to List<CheckResultInterface>
	 * used in Action > Verify transformation
	 * 验证用户是否在对话框里输入了字段名，并把验证结果添加到检验转换时出现的问题列表里。（最好
	 * 要检验用户输入的所有选项，而不只是容易出错的选项）
	 */
	public void check(List<CheckResultInterface> remarks, TransMeta transMeta, StepMeta stepMeta, 
			RowMetaInterface prev, String input[], String output[], RowMetaInterface info) {
		
		if (Const.isEmpty(fieldName)) {
			CheckResultInterface error = new CheckResult(
				CheckResult.TYPE_RESULT_ERROR, 
				BaseMessages.getString(PKG, "HelloworldMeta.CHECK_ERR_NO_FIELD"), 
				stepMeta
			);
			remarks.add(error);
		} else {
			CheckResultInterface ok = new CheckResult(
				CheckResult.TYPE_RESULT_OK, 
				BaseMessages.getString(PKG, "HelloworldMeta.CHECK_OK_FIELD"), 
				stepMeta
			);
			remarks.add(ok);//把验证结果添加到检验转换时出现的问题列表里。
		}
	}

	/**
	 *	creates a new instance of the step (factory)
	 * getStep、getStepData和getDialogClassName()方法提供了与这个步骤里其它三个接口之间的桥梁
	 这个接口里还定义了几个方法来说明这四个接口如何结合到一起。
	String getDialogClassName():用来描述实现了StepDialogInterace接口的对话框类的名字。如果这个方法返回
				了null，调用类会根据实现了StepMetaInterface接口的类的类名和包名来自动生成对话框类的名字。
	StepInterface getStep():创建一个实现了StepInterface接口的类。
	StepInterface getStepData():创建一个实现了StepDataInterface接口的类。

	 */
	public StepInterface getStep(StepMeta stepMeta, StepDataInterface stepDataInterface,
			int copyNr, TransMeta transMeta, Trans trans) {
		return new HelloworldStep(stepMeta, stepDataInterface, copyNr, transMeta, trans);
	}

	/**
	 * creates new instance of the step data (factory)
	 * getStep、getStepData和getDialogClassName()方法提供了与这个步骤里其它三个接口之间的桥梁
	 */
	public StepDataInterface getStepData() {
		return new HelloworldStepData();
	}
	/**
	 * getStep、getStepData和getDialogClassName()方法提供了与这个步骤里其它三个接口之间的桥梁
	 */
	@Override
	public String getDialogClassName() {
		return HelloworldStepDialog.class.getName();
	}

	/**
	 * deserialize from xml 
	 * databases = list of available connections
	 * counters = list of sequence steps
	 * 
	 * 下面的四个方法loadXML()、getXML()、readRep()和saveRep()把元数据保存到XML文件或资源库里，
	 * 或者从XML文件或资源库读取元数据。保存到文件的方法利用了像XStream（http://xstream.codehaus.org）这
	 * 样的XML串行化技术。
	 */
	public void loadXML(Node stepDomNode, List<DatabaseMeta> databases,
			Map<String, Counter> sequenceCounters) throws KettleXMLException {
		fieldName = XMLHandler.getTagValue(stepDomNode, Tag.field_name.name());
	}
	
	/**
	 * @Override
	 */
	public String getXML() throws KettleException {
		StringBuilder xml = new StringBuilder();
		xml.append(XMLHandler.addTagValue(Tag.field_name.name(), fieldName));
		return xml.toString();
	}
	
	/**
	 * De-serialize from repository (see loadXML)
	 */
	public void readRep(Repository repository, ObjectId stepIdInRepository,
			List<DatabaseMeta> databases, Map<String, Counter> sequenceCounters)
			throws KettleException {
		fieldName = repository.getStepAttributeString(stepIdInRepository, Tag.field_name.name());
	}

	/**
	 * serialize to repository
	 */
	public void saveRep(Repository repository, ObjectId idOfTransformation, ObjectId idOfStep)
			throws KettleException {
		repository.saveStepAttribute(idOfTransformation, idOfStep, Tag.field_name.name(), fieldName);
	}
	
	
	/**
	 * initiailize parameters to default
	 */
	public void setDefault() {
		fieldName = "helloField";
	}

	/**
	 * getFields()方法非常重要，因为它描述了输出数据行的结构。这个方法需要修改inputRowMeta对象，使这个对象和
	 * 输出格式匹配。Spoon和后面的步骤都需要知道这个步骤要输出哪些字段。最常见的一种方法，可以给输出的RowMetaInterface对象
	 * 添加一个ValueMetaInterface对象。在ValueMetaInterface对象里设置的信息越详细越好，可以设置的信息包括数据类型、长度、
	 * 精度、格式掩码，等等。添加的字段描述元信息越多，后面生成的SQL就越准确。
	 */
	@Override
	public void getFields(RowMetaInterface inputRowMeta, String name,
			RowMetaInterface[] info, StepMeta nextStep, VariableSpace space)
			throws KettleStepException {
		String realFieldName = space.environmentSubstitute(fieldName);
		//值的元数据使用ValueMetaInterface接口描述数据流里的一个字段。这个接口里定义了字段的名字、数据类型、长度、精度，等等。下面的例子用于创建一个ValueMetaInterface对象。
		ValueMetaInterface field = new ValueMeta(realFieldName, ValueMetaInterface.TYPE_STRING);
		field.setOrigin(name);		
		inputRowMeta.addValueMeta(field);
	}
}

