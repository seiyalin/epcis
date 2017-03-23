package org.oliot.epcis.service.capture;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;

import javax.servlet.ServletContext;
import javax.servlet.ServletInputStream;
import javax.xml.bind.JAXB;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Level;
import org.oliot.epcis.configuration.Configuration;
import org.oliot.model.epcis.EPCISMasterDataDocumentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.ServletContextAware;
import org.xml.sax.SAXException;

/**
 * Copyright (C) 2014 Jaewook Jack Byun
 *
 * This project is part of Oliot (oliot.org), pursuing the implementation of
 * Electronic Product Code Information Service(EPCIS) v1.1 specification in
 * EPCglobal.
 * [http://www.gs1.org/gsmp/kc/epcglobal/epcis/epcis_1_1-standard-20140520.pdf]
 * 
 *
 * @author Jaewook Jack Byun, Ph.D student
 * 
 *         Korea Advanced Institute of Science and Technology (KAIST)
 * 
 *         Real-time Embedded System Laboratory(RESL)
 * 
 *         bjw0829@kaist.ac.kr, bjw0829@gmail.com
 */

@Controller
@RequestMapping("/VocabularyCapture")
public class VocabularyCapture implements ServletContextAware {
	
	/**
	 * 测试
	 */
	public VocabularyCapture(){
		System.out.println("VocabularyCapture()"+this.hashCode());
	}
	@Autowired
	ServletContext servletContext;

	@Override
	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
	}

	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public String post(@RequestBody String inputString) {
		
		
		System.out.println("VocabularyCapture:post()");
		
		Configuration.logger
				.info(" EPCIS Masterdata Document Capture Started.... ");

		if (Configuration.isCaptureVerfificationOn == true) {
			InputStream validateStream = getXMLDocumentInputStream(inputString);
			// Parsing and Validating data
			String xsdPath = servletContext.getRealPath("/wsdl");
			xsdPath += "/EPCglobal-epcis-masterdata-1_1_jack.xsd";
			boolean isValidated = validate(validateStream, xsdPath);
			if (isValidated == false) {
				return "Error: EPCIS Masterdata Document is not validated";
			}

			InputStream epcisStream = getXMLDocumentInputStream(inputString);
			Configuration.logger
					.info(" EPCIS Masterdata Document : Validated ");
			EPCISMasterDataDocumentType epcisMasterDataDocument = JAXB
					.unmarshal(epcisStream, EPCISMasterDataDocumentType.class);

			CaptureService cs = new CaptureService();
			cs.capture(epcisMasterDataDocument);
			Configuration.logger.info(" EPCIS Masterdata Document : Captured ");
		} else {
			InputStream epcisStream = getXMLDocumentInputStream(inputString);
			EPCISMasterDataDocumentType epcisMasterDataDocument = JAXB
					.unmarshal(epcisStream, EPCISMasterDataDocumentType.class);
			CaptureService cs = new CaptureService();
			cs.capture(epcisMasterDataDocument);
			Configuration.logger.info(" EPCIS Masterdata Document : Captured ");
		}
		return "EPCIS Masterdata Document : Captured";
	}

	private static InputStream getXMLDocumentInputStream(String xmlString) {
		InputStream stream = new ByteArrayInputStream(
				xmlString.getBytes(StandardCharsets.UTF_8));
		return stream;
	}

	public static String getDataFromInputStream(ServletInputStream is)
			throws IOException {
		StringWriter writer = new StringWriter();
		IOUtils.copy(is, writer, "UTF-8");
		String data = writer.toString();
		return data;
	}

	private static boolean validate(InputStream is, String xsdPath) {
		try {
			SchemaFactory schemaFactory = SchemaFactory
					.newInstance("http://www.w3.org/2001/XMLSchema");
			File xsdFile = new File(xsdPath);
			Schema schema = schemaFactory.newSchema(xsdFile);
			Validator validator = schema.newValidator();
			StreamSource xmlSource = new StreamSource(is);
			validator.validate(xmlSource);
			return true;
		} catch (SAXException e) {
			Configuration.logger.log(Level.ERROR, e.toString());
			return false;
		} catch (IOException e) {
			Configuration.logger.log(Level.ERROR, e.toString());
			return false;
		}
	}
}
