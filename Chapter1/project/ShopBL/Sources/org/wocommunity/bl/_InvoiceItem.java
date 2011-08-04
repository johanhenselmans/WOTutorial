// DO NOT EDIT.  Make changes to InvoiceItem.java instead.
package org.wocommunity.bl;

import com.webobjects.eoaccess.*;
import com.webobjects.eocontrol.*;
import com.webobjects.foundation.*;
import java.math.*;
import java.util.*;
import org.apache.log4j.Logger;

import er.extensions.eof.*;
import er.extensions.foundation.*;

@SuppressWarnings("all")
public abstract class _InvoiceItem extends  ERXGenericRecord {
  public static final String ENTITY_NAME = "InvoiceItem";

  // Attribute Keys
  // Relationship Keys
  public static final ERXKey<org.wocommunity.bl.Invoice> INVOICE = new ERXKey<org.wocommunity.bl.Invoice>("invoice");
  public static final ERXKey<org.wocommunity.bl.Product> PRODUCT = new ERXKey<org.wocommunity.bl.Product>("product");

  // Attributes
  // Relationships
  public static final String INVOICE_KEY = INVOICE.key();
  public static final String PRODUCT_KEY = PRODUCT.key();

  private static Logger LOG = Logger.getLogger(_InvoiceItem.class);

  public InvoiceItem localInstanceIn(EOEditingContext editingContext) {
    InvoiceItem localInstance = (InvoiceItem)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }

  public org.wocommunity.bl.Invoice invoice() {
    return (org.wocommunity.bl.Invoice)storedValueForKey(_InvoiceItem.INVOICE_KEY);
  }
  
  public void setInvoice(org.wocommunity.bl.Invoice value) {
    takeStoredValueForKey(value, _InvoiceItem.INVOICE_KEY);
  }

  public void setInvoiceRelationship(org.wocommunity.bl.Invoice value) {
    if (_InvoiceItem.LOG.isDebugEnabled()) {
      _InvoiceItem.LOG.debug("updating invoice from " + invoice() + " to " + value);
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	setInvoice(value);
    }
    else if (value == null) {
    	org.wocommunity.bl.Invoice oldValue = invoice();
    	if (oldValue != null) {
    		removeObjectFromBothSidesOfRelationshipWithKey(oldValue, _InvoiceItem.INVOICE_KEY);
      }
    } else {
    	addObjectToBothSidesOfRelationshipWithKey(value, _InvoiceItem.INVOICE_KEY);
    }
  }
  
  public org.wocommunity.bl.Product product() {
    return (org.wocommunity.bl.Product)storedValueForKey(_InvoiceItem.PRODUCT_KEY);
  }
  
  public void setProduct(org.wocommunity.bl.Product value) {
    takeStoredValueForKey(value, _InvoiceItem.PRODUCT_KEY);
  }

  public void setProductRelationship(org.wocommunity.bl.Product value) {
    if (_InvoiceItem.LOG.isDebugEnabled()) {
      _InvoiceItem.LOG.debug("updating product from " + product() + " to " + value);
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	setProduct(value);
    }
    else if (value == null) {
    	org.wocommunity.bl.Product oldValue = product();
    	if (oldValue != null) {
    		removeObjectFromBothSidesOfRelationshipWithKey(oldValue, _InvoiceItem.PRODUCT_KEY);
      }
    } else {
    	addObjectToBothSidesOfRelationshipWithKey(value, _InvoiceItem.PRODUCT_KEY);
    }
  }
  

  public static InvoiceItem createInvoiceItem(EOEditingContext editingContext, org.wocommunity.bl.Invoice invoice, org.wocommunity.bl.Product product) {
    InvoiceItem eo = (InvoiceItem) EOUtilities.createAndInsertInstance(editingContext, _InvoiceItem.ENTITY_NAME);    
    eo.setInvoiceRelationship(invoice);
    eo.setProductRelationship(product);
    return eo;
  }

  public static ERXFetchSpecification<InvoiceItem> fetchSpec() {
    return new ERXFetchSpecification<InvoiceItem>(_InvoiceItem.ENTITY_NAME, null, null, false, true, null);
  }

  public static NSArray<InvoiceItem> fetchAllInvoiceItems(EOEditingContext editingContext) {
    return _InvoiceItem.fetchAllInvoiceItems(editingContext, null);
  }

  public static NSArray<InvoiceItem> fetchAllInvoiceItems(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _InvoiceItem.fetchInvoiceItems(editingContext, null, sortOrderings);
  }

  public static NSArray<InvoiceItem> fetchInvoiceItems(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    ERXFetchSpecification<InvoiceItem> fetchSpec = new ERXFetchSpecification<InvoiceItem>(_InvoiceItem.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray<InvoiceItem> eoObjects = fetchSpec.fetchObjects(editingContext);
    return eoObjects;
  }

  public static InvoiceItem fetchInvoiceItem(EOEditingContext editingContext, String keyName, Object value) {
    return _InvoiceItem.fetchInvoiceItem(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static InvoiceItem fetchInvoiceItem(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<InvoiceItem> eoObjects = _InvoiceItem.fetchInvoiceItems(editingContext, qualifier, null);
    InvoiceItem eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one InvoiceItem that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static InvoiceItem fetchRequiredInvoiceItem(EOEditingContext editingContext, String keyName, Object value) {
    return _InvoiceItem.fetchRequiredInvoiceItem(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static InvoiceItem fetchRequiredInvoiceItem(EOEditingContext editingContext, EOQualifier qualifier) {
    InvoiceItem eoObject = _InvoiceItem.fetchInvoiceItem(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no InvoiceItem that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static InvoiceItem localInstanceIn(EOEditingContext editingContext, InvoiceItem eo) {
    InvoiceItem localInstance = (eo == null) ? null : ERXEOControlUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
}
