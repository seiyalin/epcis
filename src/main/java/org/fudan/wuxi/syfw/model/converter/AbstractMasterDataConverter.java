package org.fudan.wuxi.syfw.model.converter;



import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import javax.xml.bind.JAXB;

import org.oliot.model.epcis.AttributeType;
import org.oliot.model.epcis.EPCISMasterDataBodyType;
import org.oliot.model.epcis.EPCISMasterDataDocumentType;
import org.oliot.model.epcis.VocabularyElementListType;
import org.oliot.model.epcis.VocabularyElementType;
import org.oliot.model.epcis.VocabularyListType;
import org.oliot.model.epcis.VocabularyType;



/**
 * 此抽象类负责定义epcis的静态事件捕获流程，并完成通用的基本操作，并为子类
 * @author yue.Qu
 *我们经常可以通过抽象出相似的方法轮廓，将其移动到超类，并让不同的子类实现算法所需的不同步骤，从而将代码重构为模板方法模式
 *
 */
public abstract class AbstractMasterDataConverter{
	
	public EPCISMasterDataDocumentType toEPCISMaterMasterData(){

		EPCISMasterDataDocumentType epcisMasterDataDocumentType = new EPCISMasterDataDocumentType();
		
		EPCISMasterDataBodyType epcisMasterDataBodyType = new EPCISMasterDataBodyType();
		VocabularyListType vocabularyListType = new VocabularyListType();
		List<VocabularyType> vocabularys = vocabularyListType.getVocabulary();
		VocabularyType vocabularyType = new VocabularyType();
		VocabularyElementListType vocabularyElementList = new VocabularyElementListType(); 

		
		List<VocabularyElementType> itemList = vocabularyElementList.getVocabularyElement();//ע��ֻ��get����
	
		
		
		VocabularyElementType item = new VocabularyElementType();
		List<AttributeType> attributes = item.getAttribute();
		
		
		
		try {//将前台所有的参数变为一个vocabulary对象，对应mongodb的一个vocabulary
			formData2Attributes(attributes);
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	
		itemList.add(item);
		
		vocabularyType.setVocabularyElementList(vocabularyElementList);
		vocabularys.add(vocabularyType);
		
		epcisMasterDataBodyType.setVocabularyList(vocabularyListType);
		
		epcisMasterDataDocumentType.setEPCISBody(epcisMasterDataBodyType);
		return epcisMasterDataDocumentType;
	}
	
	
	
	/**
	 * 
	 * @param attributes  用来载入前台表单收集的参数
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 * @throws NoSuchMethodException 
	 * @throws IllegalArgumentException 
	 * @throws SecurityException 
	 */
	
	protected abstract void formData2Attributes(List<AttributeType> attributes) throws SecurityException, IllegalArgumentException, NoSuchMethodException, IllegalAccessException, InvocationTargetException;
	
	
	
	/**
	 * 根据符合epcis规范的xml文件，生成EPCISMasterDataDocumentType实例对象
	 * @param file
	 * @return
	 */
	public EPCISMasterDataDocumentType toEPCISMaterMasterData(File  file){
//		File file = new File("C:\\gs1example5(Master).xml");
		EPCISMasterDataDocumentType  epcisMasterDataDocumentType  = JAXB.unmarshal(file, EPCISMasterDataDocumentType.class);
		return epcisMasterDataDocumentType;
	}
}
