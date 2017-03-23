package org.fudan.wuxi.syfw.model.converter;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

import org.fudan.wuxi.syfw.model.feed.FeedCompInfo;
import org.oliot.model.epcis.AttributeType;

//import cn.edu.fudan.syfw.entity.caputureentity.Address;
/**
 * 
 * @author yue.Qu
 *
 */
public class FeedMasterDataConverter<T> extends AbstractMasterDataConverter {
	private T feedInfo;
	private Class<T> clazz;
	private  Map<String, FieldEntity> attrValueMap;
	
	
	public FeedMasterDataConverter(T feedInfo) {
		this.feedInfo = feedInfo;
//		clazz = (Class<T>)feedInfo.getClass();
	}
	
	public FeedMasterDataConverter() {
		
	}

	@SuppressWarnings("unchecked")
	@Override
	protected void formData2Attributes(List<AttributeType> attributes) throws SecurityException, IllegalArgumentException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
		
		if(feedInfo instanceof FeedCompInfo){
			FeedCompInfo info  = (FeedCompInfo) feedInfo;
			parseInfoToAttributeType( info ,attributes);
		}
		
		
//		attrValueMap = FieldsCollector.getFileds(feedInfo);//将前台页面传过来的参数封装到attrValueMap中
//		//迭代attrValueMap，一个entry对应创建一个AttributeType实例
//		Iterator<Entry<String, FieldEntity>> it = attrValueMap.entrySet().iterator();
//		while(it.hasNext()){
//			Entry<String, FieldEntity> entry = it.next();
//			String key = entry.getKey();
//			FieldEntity fieldEntity = entry.getValue();
//			if(fieldEntity.getValue()!=null){//如果属性值非空则创建一个attributeType
//				
//				if(fieldEntity.getClazz().equals(String.class)){//如果只是String类型
//					AttributeType attributeType = new AttributeType();
//					attributeType.setId(fieldEntity.getFieldname());
//					
//					attributeType.setValue((String)fieldEntity.getValue());
//					
//					attributes.add(attributeType);
//				}
//				
//			}
		}

	/**
	 * 将FeedCompInfo转换到attributes
	 * @param attributes
	 */
	private void parseInfoToAttributeType(FeedCompInfo info ,List<AttributeType> attributes) {
		if( info.getAddr()!=null){
			AttributeType attributeType = new AttributeType();
			attributeType.setId("Address");
			
			attributeType.setValue(info.getAddr());
			
			attributes.add(attributeType);
		}
		if( info.getBizLicense()!=null){
			AttributeType attributeType = new AttributeType();
			attributeType.setId("BizLicense");
			
			attributeType.setValue(info.getBizLicense());
			
			attributes.add(attributeType);
		}
		if( info.getRepresent()!=null){
			AttributeType attributeType = new AttributeType();
			attributeType.setId("法人代表");
			
			attributeType.setValue(info.getRepresent());
			
			attributes.add(attributeType);
		}
		if( info.getTel()!=null){
			AttributeType attributeType = new AttributeType();
			attributeType.setId("电话");
			
			attributeType.setValue(info.getTel());
			
			attributes.add(attributeType);
		}
		
		
		
	}
		
		
	
		
//		ParameterizedType pt =  (ParameterizedType)this.getClass().getGenericSuperclass();//BaseDaoImpl<User>
//		clazz = (Class<T>)pt.getActualTypeArguments()[0];
		
//		System.out.println("===============================");
//		
//		System.out.println(clazz.getName());
//		System.out.println("===============================");

	}
	
	
//private void formData2Attributes(List<AttributeType> attributes){
//		
//		if(attributes!=null){
//			if(masterData!=null){
//				//��ȡ��ֳ������
//				String cultivationBaseAddress = masterData.getCultivationBaseAddress();
//				AttributeType attributeType = new AttributeType();
//				attributeType.setId("cultivationBaseAddress");
//				attributeType.setValue(cultivationBaseAddress);
//				attributes.add(attributeType);
//				
//				//��ȡ���˴��
//				String legalRepresentive = masterData.getLegalRepresentive();
//				AttributeType attributeType2 = new AttributeType();
//				attributeType2.setId("legalRepresentive");
//				attributeType2.setValue(legalRepresentive);
//				attributes.add(attributeType2);
//				
//				//��ȡ��֯�����
//				String organizationCode = masterData.getOrganizationCode();
//				AttributeType attributeType3 = new AttributeType();
//				attributeType3.setId("organizationCode");
//				attributeType3.setValue(organizationCode);
//				attributes.add(attributeType3);
//				
//				//��ȡ��ϵ�绰
//				String phone = masterData.getPhone();
//				AttributeType attributeType4 = new AttributeType();
//				attributeType4.setId("phone");
//				attributeType4.setValue(phone);
//				attributes.add(attributeType4);
//				
//				//��ȡ��ַ
//				Address address = masterData.getAddress();
//				AttributeType attributeType5 = new AttributeType();
//				attributeType5.setId("address");
//				
//				attributeType5.setValue(address.getProvince());//Ŀǰ��ģ���ȡ��ַ�����е�ʡ����Ϣ
//				attributes.add(attributeType5);
//			}
//			
//		}
	
//	@Test
//	public void test(){
////		formData2Attributes(null);
//		System.out.println("ffsadfsdafsd");
//	}


