// ============================================================================
//
// Copyright (C) 2006-2012 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package org.talend.camel.libraries;

import org.talend.core.language.ECodeLanguage;
import org.talend.core.model.routines.IRoutineProviderCreator;
import org.talend.core.model.routines.IRoutinesProvider;

/**
 * @author Administrator
 * 
 */
public class CamelRoutineProviderCreator implements IRoutineProviderCreator {

    IRoutinesProvider javaProvider = null;

    public CamelRoutineProviderCreator() {
        javaProvider = new CamelJavaRoutinesProvider();
    }

    public IRoutinesProvider createIRoutinesProviderByLanguage(ECodeLanguage lan) {
        return javaProvider;
    }

}