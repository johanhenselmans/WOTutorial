// DO NOT EDIT.  Make changes to Invoice.java instead.
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
public abstract class _Invoice extends  ERXGenericRecord {
  public static final String ENTITY_NAME = "Invoice";

  // Attribute Keys
  // Relationship Keys
  public static final ERXKey<org.wocommunity.bl.InvoiceItem> INVOICE_ITEMS = new ERXKey<org.wocommunity.bl.InvoiceItem>("invoiceItems");

  // Attributes
  // Relationships
  public static final String INVOICE_ITEMS_KEY = INVOICE_ITEMS.key();

  private static Logger LOG = Logger.getLogger(_Invoice.class);

  public Invoice localInstanceIn(EOEditingContext editingContext) {
    Invoice localInstance = (Invoice)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }

  public NSArray<org.wocommunity.bl.InvoiceItem> invoiceItems() {
    return (NSArray<org.wocommunity.bl.InvoiceItem>)storedValueForKey(_Invoice.INVOICE_ITEMS_KEY);
  }

  public NSArray<org.wocommunity.bl.InvoiceItem> invoiceItems(EOQualifier qualifier) {
    return invoiceItems(qualifier, null, false);
  }

  public NSArray<org.wocommunity.bl.InvoiceItem> invoiceItems(EOQualifier qualifier, boolean fetch) {
    return invoiceItems(qualifier, null, fetch);
  }

  public NSArray<org.wocommunity.bl.InvoiceItem> invoiceItems(EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings, boolean fetch) {
    NSArray<org.wocommunity.bl.InvoiceItem> results;
    if (fetch) {
      EOQualifier fullQualifier;
      EOQualifier inverseQualifier = new EOKeyValueQualifier(org.wocommunity.bl.InvoiceItem.INVOICE_KEY, EOQualifier.QualifierOperatorEqual, this);
    	
      if (qualifier == null) {
        fullQualifier = inverseQualifier;
      }
      else {
        NSMutableArray<EOQualifier> qualifiers = new NSMutableArray<EOQualifier>();
        qualifiers.addObject(qualifier);
        qualifiers.addObject(inverseQualifier);
        fullQualifier = new EOAndQualifier(qualifiers);
      }

      results = org.wocommunity.bl.InvoiceItem.fetchInvoiceItems(editingContext(), fullQualifier, sortOrderings);
    }
    else {
      results = invoiceItems();
      if (qualifier != null) {
        results = (NSArray<org.wocommunity.bl.InvoiceItem>)EOQualifier.filteredArrayWithQualifier(results, qualifier);
      }
      if (sortOrderings != null) {
        results = (NSArray<org.wocommunity.bl.InvoiceItem>)EOSortOrdering.sortedArrayUsingKeyOrderArray(results, sortOrderings);
      }
    }
    return results;
  }
  
  public void addToInvoiceItems(org.wocommunity.bl.InvoiceItem object) {
    includeObjectIntoPropertyWithKey(object, _Invoice.INVOICE_ITEMS_KEY);
  }

  public void removeFromInvoiceItems(org.wocommunity.bl.InvoiceItem object) {
    excludeObjectFromPropertyWithKey(object, _Invoice.INVOICE_ITEMS_KEY);
  }

  public void addToInvoiceItemsRelationship(org.wocommunity.bl.InvoiceItem object) {
    if (_Invoice.LOG.isDebugEnabled()) {
      _Invoice.LOG.debug("adding " + object + " to invoiceItems relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	addToInvoiceItems(object);
    }
    else {
    	addObjectToBothSidesOfRelationshipWithKey(object, _Invoice.INVOICE_ITEMS_KEY);
    }
  }

  public void removeFromInvoiceItemsRelationship(org.wocommunity.bl.InvoiceItem object) {
    if (_Invoice.LOG.isDebugEnabled()) {
      _Invoice.LOG.debug("removing " + object + " from invoiceItems relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	removeFromInvoiceItems(object);
    }
    else {
    	removeObjectFromBothSidesOfRelationshipWithKey(object, _Invoice.INVOICE_ITEMS_KEY);
    }
  }

  public org.wocommunity.bl.InvoiceItem createInvoiceItemsRelationship() {
    EOClassDescription eoClassDesc = EOClassDescription.classDescriptionForEntityName( org.wocommunity.bl.InvoiceItem.ENTITY_NAME );
    EOEnterpriseObject eo = eoClassDesc.createInstanceWithEditingContext(editingContext(), null);
    editingContext().insertObject(eo);
    addObjectToBothSidesOfRelationshipWithKey(eo, _Invoice.INVOICE_ITEMS_KEY);
    return (org.wocommunity.bl.InvoiceItem) eo;
  }

  public void deleteInvoiceItemsRelationship(org.wocommunity.bl.InvoiceItem object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, _Invoice.INVOICE_ITEMS_KEY);
    editingContext().deleteObject(object);
  }

  public void deleteAllInvoiceItemsRelationships() {
    Enumeration<org.wocommunity.bl.InvoiceItem> objects = invoiceItems().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteInvoiceItemsRelationship(objects.nextElement());
    }
  }


  public static Invoice createInvoice(EOEditingContext editingContext) {
    Invoice eo = (Invoice) EOUtilities.createAndInsertInstance(editingContext, _Invoice.ENTITY_NAME);    
    return eo;
  }

  public static ERXFetchSpecification<Invoice> fetchSpec() {
    return new ERXFetchSpecification<Invoice>(_Invoice.ENTITY_NAME, null, null, false, true, null);
  }

  public static NSArray<Invoice> fetchAllInvoices(EOEditingContext editingContext) {
    return _Invoice.fetchAllInvoices(editingContext, null);
  }

  public static NSArray<Invoice> fetchAllInvoices(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _Invoice.fetchInvoices(editingContext, null, sortOrderings);
  }

  public static NSArray<Invoice> fetchInvoices(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    ERXFetchSpecification<Invoice> fetchSpec = new ERXFetchSpecification<Invoice>(_Invoice.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray<Invoice> eoObjects = fetchSpec.fetchObjects(editingContext);
    return eoObjects;
  }

  public static Invoice fetchInvoice(EOEditingContext editingContext, String keyName, Object value) {
    return _Invoice.fetchInvoice(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static Invoice fetchInvoice(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<Invoice> eoObjects = _Invoice.fetchInvoices(editingContext, qualifier, null);
    Invoice eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one Invoice that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static Invoice fetchRequiredInvoice(EOEditingContext editingContext, String keyName, Object value) {
    return _Invoice.fetchRequiredInvoice(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static Invoice fetchRequiredInvoice(EOEditingContext editingContext, EOQualifier qualifier) {
    Invoice eoObject = _Invoice.fetchInvoice(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no Invoice that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static Invoice localInstanceIn(EOEditingContext editingContext, Invoice eo) {
    Invoice localInstance = (eo == null) ? null : ERXEOControlUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
}
