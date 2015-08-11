package com.allstate.edms;

import com.allstate.ets.tibco.schemas.edms_interfaces.retrievedocumentimpl.EDMSResponseHeader;
import com.allstate.ets.tibco.schemas.edms_interfaces.retrievedocumentimpl.EDMSResponseHeader.UserInformation;
import com.allstate.ets.tibco.schemas.edms_interfaces.retrievedocumentimpl.EDMSRetrieveRequestType;
import com.allstate.ets.tibco.schemas.edms_interfaces.retrievedocumentimpl.EDMSRetrieveResponseType;
import com.allstate.ets.tibco.schemas.edms_interfaces.retrievedocumentimpl.EDMSRetrieveResponseType.EDMSRetrieveResponseDetail;
import com.allstate.ets.tibco.schemas.edms_interfaces.retrievedocumentimpl.ObjectFactory;
import com.example.xmlns._1367425861502.EDMSRetreiveInterface;

public class RetrieveService implements EDMSRetreiveInterface {

	public EDMSRetrieveResponseType retrieveDocument(
			EDMSRetrieveRequestType edmsRetrieveRequest) {

		ObjectFactory of = new ObjectFactory();

		EDMSRetrieveResponseType response = of.createEDMSRetrieveResponseType();

		EDMSResponseHeader header = new ObjectFactory()
				.createEDMSResponseHeader();
		response.setEDMSResponseHeader(header);
		header.setConsumerSourceName(edmsRetrieveRequest.getEDMSRequestHeader()
				.getConsumerSourceName());
		header.setRequestTimestamp(edmsRetrieveRequest.getEDMSRequestHeader()
				.getRequestTimestamp());
		header.setCorrelationId(edmsRetrieveRequest.getEDMSRequestHeader()
				.getCorrelationId());

		UserInformation ui = of.createEDMSResponseHeaderUserInformation();
		header.setUserInformation(ui);
		ui.setUserId(edmsRetrieveRequest.getEDMSRequestHeader()
				.getUserInformation().getUserId());

		EDMSRetrieveResponseDetail dets = of
				.createEDMSRetrieveResponseTypeEDMSRetrieveResponseDetail();
		response.setEDMSRetrieveResponseDetail(dets);
		dets.setContentId(edmsRetrieveRequest.getContentId());

		dets.setDescription("Hello world!");
		return response;
	}
}
