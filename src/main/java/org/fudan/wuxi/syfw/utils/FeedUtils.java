package org.fudan.wuxi.syfw.utils;

import java.util.List;

import org.fudan.wuxi.syfw.model.converter.FeedMasterDataConverter;
import org.fudan.wuxi.syfw.model.feed.FeedCompInfo;
import org.fudan.wuxi.syfw.model.query.PollQueryEntity;
import org.oliot.model.epcis.EPCISMasterDataDocumentType;
import org.oliot.model.epcis.QueryParam;
import org.oliot.model.epcis.QueryParams;


/**
 * 
 * @author Administrator
 *
 */
@SuppressWarnings("unused")
public class FeedUtils {
	/**
	 * 该方法依赖model模块下的converter包下的FeedMasterDataConverter
	 * @param compInfo
	 * @return
	 */
		public static EPCISMasterDataDocumentType ModelToEPCISMasterDataDocumentType(FeedCompInfo compInfo){
			
			System.out.println("前台收集到的FeedCompInfo 参数为"+compInfo);
				
//			FeedCompInfo compInfo2 = new FeedCompInfo();
//			compInfo2.setAddr("复旦大学无锡研究院");
//			compInfo2.setBizLicense("复旦大学无锡研究院授权许可证");
//			compInfo2.setAddr("复旦大学无锡研究院");
			
			FeedMasterDataConverter<FeedCompInfo> mdc = new FeedMasterDataConverter<FeedCompInfo>(compInfo);
			
			EPCISMasterDataDocumentType epcisMaterMasterData = mdc.toEPCISMaterMasterData();

			return epcisMaterMasterData;
		}
		/**
		 * 将id封装成PollQueryEntity查询参数
		 * @param id
		 * @return
		 */
		public static PollQueryEntity feedCmpInfoId2PollQueryEntity(String id){
			PollQueryEntity pqe = new PollQueryEntity();
			pqe.setQueryName("SimpleMasterDataQuery");
			
			
			QueryParams queryParams = new QueryParams();
			List<QueryParam> params = queryParams.getParam();
			
			//�׶�
			QueryParam queryParam = new QueryParam();
			queryParam.setName("EQ_disposition");
			queryParam.setValue("��ֳ");
			params.add(queryParam);
			
//			//�¼�����
//			QueryParam queryParam2 = new QueryParam();
//			queryParam2.setName("eventType");
//			queryParam2.setValue("ObjectEvent");
//			params.add(queryParam2);
			
			pqe.setParams(queryParams);
			
			
			return pqe;
			
		}
}
