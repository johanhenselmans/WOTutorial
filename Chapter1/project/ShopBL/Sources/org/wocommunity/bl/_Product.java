// DO NOT EDIT.  Make changes to Product.java instead.
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
public abstract class _Product extends  ERXGenericRecord {
  public static final String ENTITY_NAME = "Product";

  // Attribute Keys
  public static final ERXKey<BigDecimal> LIST_PRICE = new ERXKey<BigDecimal>("listPrice");
  public static final ERXKey<String> SHORT_DESCRIPTION = new ERXKey<String>("shortDescription");
  // Relationship Keys
  public static final ERXKey<org.wocommunity.bl.InvoiceItem> INVOICE_ITEMS = new ERXKey<org.wocommunity.bl.InvoiceItem>("invoiceItems");
  public static final ERXKey<org.wocommunity.bl.OrderItem> ORDER_ITEMS = new ERXKey<org.wocommunity.bl.OrderItem>("orderItems");
  public static final ERXKey<org.wocommunity.bl.ProductCategory> PRODUCT_CATEGORIES = new ERXKey<org.wocommunity.bl.ProductCategory>("productCategories");

  // Attributes
  public static final String LIST_PRICE_KEY = LIST_PRICE.key();
  public static final String SHORT_DESCRIPTION_KEY = SHORT_DESCRIPTION.key();
  // Relationships
  public static final String INVOICE_ITEMS_KEY = INVOICE_ITEMS.key();
  public static final String ORDER_ITEMS_KEY = ORDER_ITEMS.key();
  public static final String PRODUCT_CATEGORIES_KEY = PRODUCT_CATEGORIES.key();

  private static Logger LOG = Logger.getLogger(_Product.class);

  public Product localInstanceIn(EOEditingContext editingContext) {
    Product localInstance = (Product)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }

  public BigDecimal listPrice() {
    return (BigDecimal) storedValueForKey(_Product.LIST_PRICE_KEY);
  }

  public void setListPrice(BigDecimal value) {
    if (_Product.LOG.isDebugEnabled()) {
    	_Product.LOG.debug( "updating listPrice from " + listPrice() + " to " + value);
    }
    takeStoredValueForKey(value, _Product.LIST_PRICE_KEY);
  }

  public String shortDescription() {
    return (String) storedValueForKey(_Product.SHORT_DESCRIPTION_KEY);
  }

  public void setShortDescription(String value) {
    if (_Product.LOG.isDebugEnabled()) {
    	_Product.LOG.debug( "updating shortDescription from " + shortDescription() + " to " + value);
    }
    takeStoredValueForKey(value, _Product.SHORT_DESCRIPTION_KEY);
  }

  public NSArray<org.wocommunity.bl.InvoiceItem> invoiceItems() {
    return (NSArray<org.wocommunity.bl.InvoiceItem>)storedValueForKey(_Product.INVOICE_ITEMS_KEY);
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
      EOQualifier inverseQualifier = new EOKeyValueQualifier(org.wocommunity.bl.InvoiceItem.PRODUCT_KEY, EOQualifier.QualifierOperatorEqual, this);
    	
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
    includeObjectIntoPropertyWithKey(object, _Product.INVOICE_ITEMS_KEY);
  }

  public void removeFromInvoiceItems(org.wocommunity.bl.InvoiceItem object) {
    excludeObjectFromPropertyWithKey(object, _Product.INVOICE_ITEMS_KEY);
  }

  public void addToInvoiceItemsRelationship(org.wocommunity.bl.InvoiceItem object) {
    if (_Product.LOG.isDebugEnabled()) {
      _Product.LOG.debug("adding " + object + " to invoiceItems relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	addToInvoiceItems(object);
    }
    else {
    	addObjectToBothSidesOfRelationshipWithKey(object, _Product.INVOICE_ITEMS_KEY);
    }
  }

  public void removeFromInvoiceItemsRelationship(org.wocommunity.bl.InvoiceItem object) {
    if (_Product.LOG.isDebugEnabled()) {
      _Product.LOG.debug("removing " + object + " from invoiceItems relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	removeFromInvoiceItems(object);
    }
    else {
    	removeObjectFromBothSidesOfRelationshipWithKey(object, _Product.INVOICE_ITEMS_KEY);
    }
  }

  public org.wocommunity.bl.InvoiceItem createInvoiceItemsRelationship() {
    EOClassDescription eoClassDesc = EOClassDescription.classDescriptionForEntityName( org.wocommunity.bl.InvoiceItem.ENTITY_NAME );
    EOEnterpriseObject eo = eoClassDesc.createInstanceWithEditingContext(editingContext(), null);
    editingContext().insertObject(eo);
    addObjectToBothSidesOfRelationshipWithKey(eo, _Product.INVOICE_ITEMS_KEY);
    return (org.wocommunity.bl.InvoiceItem) eo;
  }

  public void deleteInvoiceItemsRelationship(org.wocommunity.bl.InvoiceItem object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, _Product.INVOICE_ITEMS_KEY);
    editingContext().deleteObject(object);
  }

  public void deleteAllInvoiceItemsRelationships() {
    Enumeration<org.wocommunity.bl.InvoiceItem> objects = invoiceItems().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteInvoiceItemsRelationship(objects.nextElement());
    }
  }

  public NSArray<org.wocommunity.bl.OrderItem> orderItems() {
    return (NSArray<org.wocommunity.bl.OrderItem>)storedValueForKey(_Product.ORDER_ITEMS_KEY);
  }

  public NSArray<org.wocommunity.bl.OrderItem> orderItems(EOQualifier qualifier) {
    return orderItems(qualifier, null, false);
  }

  public NSArray<org.wocommunity.bl.OrderItem> orderItems(EOQualifier qualifier, boolean fetch) {
    return orderItems(qualifier, null, fetch);
  }

  public NSArray<org.wocommunity.bl.OrderItem> orderItems(EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings, boolean fetch) {
    NSArray<org.wocommunity.bl.OrderItem> results;
    if (fetch) {
      EOQualifier fullQualifier;
      EOQualifier inverseQualifier = new EOKeyValueQualifier(org.wocommunity.bl.OrderItem.PRODUCT_KEY, EOQualifier.QualifierOperatorEqual, this);
    	
      if (qualifier == null) {
        fullQualifier = inverseQualifier;
      }
      else {
        NSMutableArray<EOQualifier> qualifiers = new NSMutableArray<EOQualifier>();
        qualifiers.addObject(qualifier);
        qualifiers.addObject(inverseQualifier);
        fullQualifier = new EOAndQualifier(qualifiers);
      }

      results = org.wocommunity.bl.OrderItem.fetchOrderItems(editingContext(), fullQualifier, sortOrderings);
    }
    else {
      results = orderItems();
      if (qualifier != null) {
        results = (NSArray<org.wocommunity.bl.OrderItem>)EOQualifier.filteredArrayWithQualifier(results, qualifier);
      }
      if (sortOrderings != null) {
        results = (NSArray<org.wocommunity.bl.OrderItem>)EOSortOrdering.sortedArrayUsingKeyOrderArray(results, sortOrderings);
      }
    }
    return results;
  }
  
  public void addToOrderItems(org.wocommunity.bl.OrderItem object) {
    includeObjectIntoPropertyWithKey(object, _Product.ORDER_ITEMS_KEY);
  }

  public void removeFromOrderItems(org.wocommunity.bl.OrderItem object) {
    excludeObjectFromPropertyWithKey(object, _Product.ORDER_ITEMS_KEY);
  }

  public void addToOrderItemsRelationship(org.wocommunity.bl.OrderItem object) {
    if (_Product.LOG.isDebugEnabled()) {
      _Product.LOG.debug("adding " + object + " to orderItems relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	addToOrderItems(object);
    }
    else {
    	addObjectToBothSidesOfRelationshipWithKey(object, _Product.ORDER_ITEMS_KEY);
    }
  }

  public void removeFromOrderItemsRelationship(org.wocommunity.bl.OrderItem object) {
    if (_Product.LOG.isDebugEnabled()) {
      _Product.LOG.debug("removing " + object + " from orderItems relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	removeFromOrderItems(object);
    }
    else {
    	removeObjectFromBothSidesOfRelationshipWithKey(object, _Product.ORDER_ITEMS_KEY);
    }
  }

  public org.wocommunity.bl.OrderItem createOrderItemsRelationship() {
    EOClassDescription eoClassDesc = EOClassDescription.classDescriptionForEntityName( org.wocommunity.bl.OrderItem.ENTITY_NAME );
    EOEnterpriseObject eo = eoClassDesc.createInstanceWithEditingContext(editingContext(), null);
    editingContext().insertObject(eo);
    addObjectToBothSidesOfRelationshipWithKey(eo, _Product.ORDER_ITEMS_KEY);
    return (org.wocommunity.bl.OrderItem) eo;
  }

  public void deleteOrderItemsRelationship(org.wocommunity.bl.OrderItem object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, _Product.ORDER_ITEMS_KEY);
    editingContext().deleteObject(object);
  }

  public void deleteAllOrderItemsRelationships() {
    Enumeration<org.wocommunity.bl.OrderItem> objects = orderItems().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteOrderItemsRelationship(objects.nextElement());
    }
  }

  public NSArray<org.wocommunity.bl.ProductCategory> productCategories() {
    return (NSArray<org.wocommunity.bl.ProductCategory>)storedValueForKey(_Product.PRODUCT_CATEGORIES_KEY);
  }

  public NSArray<org.wocommunity.bl.ProductCategory> productCategories(EOQualifier qualifier) {
    return productCategories(qualifier, null);
  }

  public NSArray<org.wocommunity.bl.ProductCategory> productCategories(EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    NSArray<org.wocommunity.bl.ProductCategory> results;
      results = productCategories();
      if (qualifier != null) {
        results = (NSArray<org.wocommunity.bl.ProductCategory>)EOQualifier.filteredArrayWithQualifier(results, qualifier);
      }
      if (sortOrderings != null) {
        results = (NSArray<org.wocommunity.bl.ProductCategory>)EOSortOrdering.sortedArrayUsingKeyOrderArray(results, sortOrderings);
      }
    return results;
  }
  
  public void addToProductCategories(org.wocommunity.bl.ProductCategory object) {
    includeObjectIntoPropertyWithKey(object, _Product.PRODUCT_CATEGORIES_KEY);
  }

  public void removeFromProductCategories(org.wocommunity.bl.ProductCategory object) {
    excludeObjectFromPropertyWithKey(object, _Product.PRODUCT_CATEGORIES_KEY);
  }

  public void addToProductCategoriesRelationship(org.wocommunity.bl.ProductCategory object) {
    if (_Product.LOG.isDebugEnabled()) {
      _Product.LOG.debug("adding " + object + " to productCategories relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	addToProductCategories(object);
    }
    else {
    	addObjectToBothSidesOfRelationshipWithKey(object, _Product.PRODUCT_CATEGORIES_KEY);
    }
  }

  public void removeFromProductCategoriesRelationship(org.wocommunity.bl.ProductCategory object) {
    if (_Product.LOG.isDebugEnabled()) {
      _Product.LOG.debug("removing " + object + " from productCategories relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	removeFromProductCategories(object);
    }
    else {
    	removeObjectFromBothSidesOfRelationshipWithKey(object, _Product.PRODUCT_CATEGORIES_KEY);
    }
  }

  public org.wocommunity.bl.ProductCategory createProductCategoriesRelationship() {
    EOClassDescription eoClassDesc = EOClassDescription.classDescriptionForEntityName( org.wocommunity.bl.ProductCategory.ENTITY_NAME );
    EOEnterpriseObject eo = eoClassDesc.createInstanceWithEditingContext(editingContext(), null);
    editingContext().insertObject(eo);
    addObjectToBothSidesOfRelationshipWithKey(eo, _Product.PRODUCT_CATEGORIES_KEY);
    return (org.wocommunity.bl.ProductCategory) eo;
  }

  public void deleteProductCategoriesRelationship(org.wocommunity.bl.ProductCategory object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, _Product.PRODUCT_CATEGORIES_KEY);
    editingContext().deleteObject(object);
  }

  public void deleteAllProductCategoriesRelationships() {
    Enumeration<org.wocommunity.bl.ProductCategory> objects = productCategories().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteProductCategoriesRelationship(objects.nextElement());
    }
  }


  public static Product createProduct(EOEditingContext editingContext, BigDecimal listPrice
, String shortDescription
) {
    Product eo = (Product) EOUtilities.createAndInsertInstance(editingContext, _Product.ENTITY_NAME);    
		eo.setListPrice(listPrice);
		eo.setShortDescription(shortDescription);
    return eo;
  }

  public static ERXFetchSpecification<Product> fetchSpec() {
    return new ERXFetchSpecification<Product>(_Product.ENTITY_NAME, null, null, false, true, null);
  }

  public static NSArray<Product> fetchAllProducts(EOEditingContext editingContext) {
    return _Product.fetchAllProducts(editingContext, null);
  }

  public static NSArray<Product> fetchAllProducts(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _Product.fetchProducts(editingContext, null, sortOrderings);
  }

  public static NSArray<Product> fetchProducts(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    ERXFetchSpecification<Product> fetchSpec = new ERXFetchSpecification<Product>(_Product.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray<Product> eoObjects = fetchSpec.fetchObjects(editingContext);
    return eoObjects;
  }

  public static Product fetchProduct(EOEditingContext editingContext, String keyName, Object value) {
    return _Product.fetchProduct(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static Product fetchProduct(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<Product> eoObjects = _Product.fetchProducts(editingContext, qualifier, null);
    Product eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one Product that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static Product fetchRequiredProduct(EOEditingContext editingContext, String keyName, Object value) {
    return _Product.fetchRequiredProduct(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static Product fetchRequiredProduct(EOEditingContext editingContext, EOQualifier qualifier) {
    Product eoObject = _Product.fetchProduct(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no Product that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static Product localInstanceIn(EOEditingContext editingContext, Product eo) {
    Product localInstance = (eo == null) ? null : ERXEOControlUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
}
