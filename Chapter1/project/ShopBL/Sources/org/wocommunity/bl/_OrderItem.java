// DO NOT EDIT.  Make changes to OrderItem.java instead.
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
public abstract class _OrderItem extends  ERXGenericRecord {
  public static final String ENTITY_NAME = "OrderItem";

  // Attribute Keys
  // Relationship Keys
  public static final ERXKey<org.wocommunity.bl.Order> ORDER = new ERXKey<org.wocommunity.bl.Order>("order");
  public static final ERXKey<org.wocommunity.bl.Product> PRODUCT = new ERXKey<org.wocommunity.bl.Product>("product");

  // Attributes
  // Relationships
  public static final String ORDER_KEY = ORDER.key();
  public static final String PRODUCT_KEY = PRODUCT.key();

  private static Logger LOG = Logger.getLogger(_OrderItem.class);

  public OrderItem localInstanceIn(EOEditingContext editingContext) {
    OrderItem localInstance = (OrderItem)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }

  public org.wocommunity.bl.Order order() {
    return (org.wocommunity.bl.Order)storedValueForKey(_OrderItem.ORDER_KEY);
  }
  
  public void setOrder(org.wocommunity.bl.Order value) {
    takeStoredValueForKey(value, _OrderItem.ORDER_KEY);
  }

  public void setOrderRelationship(org.wocommunity.bl.Order value) {
    if (_OrderItem.LOG.isDebugEnabled()) {
      _OrderItem.LOG.debug("updating order from " + order() + " to " + value);
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	setOrder(value);
    }
    else if (value == null) {
    	org.wocommunity.bl.Order oldValue = order();
    	if (oldValue != null) {
    		removeObjectFromBothSidesOfRelationshipWithKey(oldValue, _OrderItem.ORDER_KEY);
      }
    } else {
    	addObjectToBothSidesOfRelationshipWithKey(value, _OrderItem.ORDER_KEY);
    }
  }
  
  public org.wocommunity.bl.Product product() {
    return (org.wocommunity.bl.Product)storedValueForKey(_OrderItem.PRODUCT_KEY);
  }
  
  public void setProduct(org.wocommunity.bl.Product value) {
    takeStoredValueForKey(value, _OrderItem.PRODUCT_KEY);
  }

  public void setProductRelationship(org.wocommunity.bl.Product value) {
    if (_OrderItem.LOG.isDebugEnabled()) {
      _OrderItem.LOG.debug("updating product from " + product() + " to " + value);
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	setProduct(value);
    }
    else if (value == null) {
    	org.wocommunity.bl.Product oldValue = product();
    	if (oldValue != null) {
    		removeObjectFromBothSidesOfRelationshipWithKey(oldValue, _OrderItem.PRODUCT_KEY);
      }
    } else {
    	addObjectToBothSidesOfRelationshipWithKey(value, _OrderItem.PRODUCT_KEY);
    }
  }
  

  public static OrderItem createOrderItem(EOEditingContext editingContext, org.wocommunity.bl.Order order, org.wocommunity.bl.Product product) {
    OrderItem eo = (OrderItem) EOUtilities.createAndInsertInstance(editingContext, _OrderItem.ENTITY_NAME);    
    eo.setOrderRelationship(order);
    eo.setProductRelationship(product);
    return eo;
  }

  public static ERXFetchSpecification<OrderItem> fetchSpec() {
    return new ERXFetchSpecification<OrderItem>(_OrderItem.ENTITY_NAME, null, null, false, true, null);
  }

  public static NSArray<OrderItem> fetchAllOrderItems(EOEditingContext editingContext) {
    return _OrderItem.fetchAllOrderItems(editingContext, null);
  }

  public static NSArray<OrderItem> fetchAllOrderItems(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _OrderItem.fetchOrderItems(editingContext, null, sortOrderings);
  }

  public static NSArray<OrderItem> fetchOrderItems(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    ERXFetchSpecification<OrderItem> fetchSpec = new ERXFetchSpecification<OrderItem>(_OrderItem.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray<OrderItem> eoObjects = fetchSpec.fetchObjects(editingContext);
    return eoObjects;
  }

  public static OrderItem fetchOrderItem(EOEditingContext editingContext, String keyName, Object value) {
    return _OrderItem.fetchOrderItem(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static OrderItem fetchOrderItem(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<OrderItem> eoObjects = _OrderItem.fetchOrderItems(editingContext, qualifier, null);
    OrderItem eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one OrderItem that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static OrderItem fetchRequiredOrderItem(EOEditingContext editingContext, String keyName, Object value) {
    return _OrderItem.fetchRequiredOrderItem(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static OrderItem fetchRequiredOrderItem(EOEditingContext editingContext, EOQualifier qualifier) {
    OrderItem eoObject = _OrderItem.fetchOrderItem(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no OrderItem that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static OrderItem localInstanceIn(EOEditingContext editingContext, OrderItem eo) {
    OrderItem localInstance = (eo == null) ? null : ERXEOControlUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
}
