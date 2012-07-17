package org.talend.repository.services;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {

    private static final String BUNDLE_NAME = "org.talend.repository.services.messages"; //$NON-NLS-1$

    public static String ExportServiceAction_Action_Label;

    public static String ServiceExportManager_Exception_cannot_create_document_builder;

    public static String ServiceExportManager_Exception_cannot_open_file;

    public static String ServiceExportManager_Exception_cannot_serialize_xml;

    public static String ServiceExportManager_Exception_Cannot_parse_job_xml;

    public static String ServiceExportManager_Exception_invalid_blueprint_xml;

    public static String ServiceExportWizard_Wizard_Title;

    public static String ServiceExportWizard_WarningMessage_WillBeOverwritten;

    public static String AssignWsdlDialog_Title;

    public static String AssignWsdlDialog_Description;

    public static String AssignWsdlDialog_WsdlChoice_CreateNew;

    public static String AssignWsdlDialog_WsdlChoice_ImportExistent;

    public static String AssignWsdlDialog_ExistentWsdlFilePath;

    public static String AssignWsdlDialog_ImportWsdlSchemas;

    public static String PublishMetadata_Exception_wsdl_not_found;

    public static String PublishMetadata_Exception_wsdl_not_valid;

    public static String PublishMetadataAction_Importing;

	public static String PublishMetadataAction_Name;

	public static String AssignJobAction_WarningTitle;

    public static String AssignJobAction_WarningMessage;

    static {
        // initialize resource bundle
        NLS.initializeMessages(BUNDLE_NAME, Messages.class);
    }

    private Messages() {
    }

}
