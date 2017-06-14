package org.kettlesolutions.plugin.step.helloworld;

import org.pentaho.di.core.exception.KettleException;
import org.pentaho.di.core.row.RowDataUtil;
import org.pentaho.di.trans.Trans;
import org.pentaho.di.trans.TransMeta;
import org.pentaho.di.trans.step.BaseStep;
import org.pentaho.di.trans.step.StepDataInterface;
import org.pentaho.di.trans.step.StepInterface;
import org.pentaho.di.trans.step.StepMeta;
import org.pentaho.di.trans.step.StepMetaInterface;
/**
 * BaseStep抽象类已经实现了接口里的很多方法，我们只要覆盖需要修改的方法即可。
 * @author Administrator
 *
 */
public class HelloworldStep extends BaseStep implements StepInterface {
	/**
	 * 类的构造函数通常直接把参数传递给BaseStep父类。由父类里的方法来构造对象，然后可以直接
	 * 使用类似transMeta这样的对象。
	 * @param stepMeta
	 * @param stepDataInterface
	 * @param copyNr
	 * @param transMeta
	 * @param trans
	 */
	public HelloworldStep(StepMeta stepMeta, StepDataInterface stepDataInterface,
			int copyNr, TransMeta transMeta, Trans trans) {
		super(stepMeta, stepDataInterface, copyNr, transMeta, trans);
		// TODO Auto-generated constructor stub
	}

	
	public boolean processRow(StepMetaInterface smi, StepDataInterface sdi) throws KettleException {

		HelloworldStepMeta meta  = (HelloworldStepMeta) smi;
		HelloworldStepData data = (HelloworldStepData) sdi;
		/**
		 * getRow()方法从上一个步骤获取一行数据。如果没有更多要获取的数据行，这个方法就会返回null。
		 * 如果前面的步骤不能及时提供数据，这个方法就会阻塞，直到有可用的数据行。这样这个步骤的速度就会降低，也会影响
		 * 其它步骤的速度。
		 */
		Object[] row = getRow();
		if (row==null) {
			/**
			 * setOutputDone()方法用来通知其它的步骤，本步骤已经没有输出数据行。下一个步骤如果
			 * 再调用getRow()方法就会返回null,转换也不再调用processRow()方法。
			 */
			setOutputDone();
			return false;
		}
		
		if (first) {
			first=false;
			/**
			 * 从性能上考虑，getRow()方法不提供数据行的元数据，只提供上个步骤输出的数据。可以使用getInputRowMeta()方法
			获取元数据，元数据只获取一次即可，所以在first代码块里获取元数据。
			   如果要把数据传到下一个步骤，要使用putRow()方法。除了输出数据，还要输出RowMetaInterface元数据。
			   第一行使用clone()方法把输入行的元数据结构复制给输出行。输出行的元数据结构是在输入行的基础上增加一个字段，但
			   构造输出行的元数据结构只能构造一次，因为所有输出数据行的结构都是一样的，产生了输出行以后，元数据结构就不能再变化。
			   所以输出行的元数据结构在first代码块里构造。first是一个内部成员，first代码块里的代码只在处理第一行数据时执行。
			   下面代码的最后一行，给输出数据增加了一个字段。
			 */
			data.outputRowMeta = getInputRowMeta().clone();
			meta.getFields(data.outputRowMeta, getStepname(), null, null, this);
		}
		/**
		 * 下面的代码，把数据写入输出流。从性能角度考虑，数据行实现就是Java数组。为了开发方便，可以使用RowDataUtil类提供
		 * 的一些静态方法来操作数据。使用RowDatautil静态方法复制数据，还可以提高性能。
		 */
		String value = "Hello, world!";
		
		Object[] outputRow = RowDataUtil.addValueData(row, getInputRowMeta().size(), value);
		
		putRow(data.outputRowMeta, outputRow);
		
		return true;
	}
}



