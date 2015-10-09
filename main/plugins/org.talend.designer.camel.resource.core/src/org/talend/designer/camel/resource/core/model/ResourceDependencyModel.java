// ============================================================================
//
// Copyright (C) 2006-2015 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package org.talend.designer.camel.resource.core.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

import org.talend.camel.core.model.camelProperties.RouteResourceItem;
import org.talend.commons.exception.PersistenceException;
import org.talend.core.model.repository.IRepositoryViewObject;
import org.talend.core.model.utils.JavaResourcesHelper;
import org.talend.core.repository.model.ProxyRepositoryFactory;
import org.talend.designer.camel.resource.core.util.RouteResourceUtil;

/**
 * @author xpli
 * 
 */
public class ResourceDependencyModel {

    private final RouteResourceItem item;

    private String selectedVersion = RouteResourceUtil.LATEST_VERSION;

    /**
     * Built in type can not be deleted.
     */
    private boolean isBuiltIn;

    private final Collection<String> refNodes = new HashSet<String>();

    public ResourceDependencyModel(RouteResourceItem item) {
        this.item = item;
    }

    /**
     * @return the item
     */
    public RouteResourceItem getItem() {
        return item;
    }

    /**
     * @return the selectedVersion
     */
    public String getSelectedVersion() {
        return selectedVersion;
    }

    /**
     * @param selectedVersion
     *            the selectedVersion to set
     */
    public void setSelectedVersion(String selectedVersion) {
        this.selectedVersion = selectedVersion;
    }

    /**
     * @return the isBuiltIn
     */
    public boolean isBuiltIn() {
        return isBuiltIn;
    }

    /**
     * @param isBuiltIn
     *            the isBuiltIn to set
     */
    public void setBuiltIn(boolean isBuiltIn) {
        this.isBuiltIn = isBuiltIn;
    }


    /**
     * @return the classPathUrl
     */
    public String getClassPathUrl() {
        return JavaResourcesHelper.getResouceClasspath(item, selectedVersion);
    }

    /**
     * @return the versions
     */
    public Collection<String> getVersions() {
        final List<String> versions = new ArrayList<String>();
        try {
            for (IRepositoryViewObject obj : ProxyRepositoryFactory.getInstance().getAllVersion(
                item.getProperty().getId())) {
                versions.add(obj.getVersion());
            }
        } catch (PersistenceException e) {
        }
        versions.add(RouteResourceUtil.LATEST_VERSION);
        Collections.sort(versions);
        return versions;
    }

    /**
     * @return the refNodes
     */
    public Collection<String> getRefNodes() {
        return refNodes;
    }

    @Override
    public String toString() {
        return getItem().getProperty().getDisplayName();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof ResourceDependencyModel) {
            final ResourceDependencyModel model = (ResourceDependencyModel) obj;
            return model.getItem().getProperty().getId().equals(item.getProperty().getId());
        }
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return item.getProperty().getId().hashCode();
    }

}
