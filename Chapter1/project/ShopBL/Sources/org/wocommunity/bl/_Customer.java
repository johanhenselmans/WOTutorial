// DO NOT EDIT.  Make changes to Customer.java instead.
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
public abstract class _Customer extends org.wocommunity.bl.Contact {
  public static final String ENTITY_NAME = "Customer";

  // Attribute Keys
  public static final ERXKey<NSTimestamp> CUSTOMER_SINCE = new ERXKey<NSTimestamp>("customerSince");
  public static final ERXKey<String> EMAIL = new ERXKey<String>("email");
  public static final ERXKey<String> FIRST_NAME = new ERXKey<String>("firstName");
  public static final ERXKey<String> LAST_NAME = new ERXKey<String>("lastName");
  public static final ERXKey<er.extensions.crypting.ERXCryptoString> PASSWORD = new ERXKey<er.extensions.crypting.ERXCryptoString>("password");
  // Relationship Keys
  public static final ERXKey<org.wocommunity.bl.Order> ORDERS = new ERXKey<org.wocommunity.bl.Order>("orders");

  // Attributes
  public static final String CUSTOMER_SINCE_KEY = CUSTOMER_SINCE.key();
  public static final String EMAIL_KEY = EMAIL.key();
  public static final String FIRST_NAME_KEY = FIRST_NAME.key();
  public static final String LAST_NAME_KEY = LAST_NAME.key();
  public static final String PASSWORD_KEY = PASSWORD.key();
  // Relationships
  public static final String ORDERS_KEY = ORDERS.key();

  private static Logger LOG = Logger.getLogger(_Customer.class);

  public Customer localInstanceIn(EOEditingContext editingContext) {
    Customer localInstance = (Customer)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }

  public NSTimestamp customerSince() {
    return (NSTimestamp) storedValueForKey(_Customer.CUSTOMER_SINCE_KEY);
  }

  public void setCustomerSince(NSTimestamp value) {
    if (_Customer.LOG.isDebugEnabled()) {
    	_Customer.LOG.debug( "updating customerSince from " + customerSince() + " to " + value);
    }
    takeStoredValueForKey(value, _Customer.CUSTOMER_SINCE_KEY);
  }

  public NSArray<org.wocommunity.bl.Order> orders() {
    return (NSArray<org.wocommunity.bl.Order>)storedValueForKey(_Customer.ORDERS_KEY);
  }

  public NSArray<org.wocommunity.bl.Order> orders(EOQualifier qualifier) {
    return orders(qualifier, null, false);
  }

  public NSArray<org.wocommunity.bl.Order> orders(EOQualifier qualifier, boolean fetch) {
    return orders(qualifier, null, fetch);
  }

  public NSArray<org.wocommunity.bl.Order> orders(EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings, boolean fetch) {
    NSArray<org.wocommunity.bl.Order> results;
    if (fetch) {
      EOQualifier fullQualifier;
      EOQualifier inverseQualifier = new EOKeyValueQualifier(org.wocommunity.bl.Order.CUSTOMER_KEY, EOQualifier.QualifierOperatorEqual, this);
    	
      if (qualifier == null) {
        fullQualifier = inverseQualifier;
      }
      else {
        NSMutableArray<EOQualifier> qualifiers = new NSMutableArray<EOQualifier>();
        qualifiers.addObject(qualifier);
        qualifiers.addObject(inverseQualifier);
        fullQualifier = new EOAndQualifier(qualifiers);
      }

      results = org.wocommunity.bl.Order.fetchOrders(editingContext(), fullQualifier, sortOrderings);
    }
    else {
      results = orders();
      if (qualifier != null) {
        results = (NSArray<org.wocommunity.bl.Order>)EOQualifier.filteredArrayWithQualifier(results, qualifier);
      }
      if (sortOrderings != null) {
        results = (NSArray<org.wocommunity.bl.Order>)EOSortOrdering.sortedArrayUsingKeyOrderArray(results, sortOrderings);
      }
    }
    return results;
  }
  
  public void addToOrders(org.wocommunity.bl.Order object) {
    includeObjectIntoPropertyWithKey(object, _Customer.ORDERS_KEY);
  }

  public void removeFromOrders(org.wocommunity.bl.Order object) {
    excludeObjectFromPropertyWithKey(object, _Customer.ORDERS_KEY);
  }

  public void addToOrdersRelationship(org.wocommunity.bl.Order object) {
    if (_Customer.LOG.isDebugEnabled()) {
      _Customer.LOG.debug("adding " + object + " to orders relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	addToOrders(object);
    }
    else {
    	addObjectToBothSidesOfRelationshipWithKey(object, _Customer.ORDERS_KEY);
    }
  }

  public void removeFromOrdersRelationship(org.wocommunity.bl.Order object) {
    if (_Customer.LOG.isDebugEnabled()) {
      _Customer.LOG.debug("removing " + object + " from orders relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	removeFromOrders(object);
    }
    else {
    	removeObjectFromBothSidesOfRelationshipWithKey(object, _Customer.ORDERS_KEY);
    }
  }

  public org.wocommunity.bl.Order createOrdersRelationship() {
    EOClassDescription eoClassDesc = EOClassDescription.classDescriptionForEntityName( org.wocommunity.bl.Order.ENTITY_NAME );
    EOEnterpriseObject eo = eoClassDesc.createInstanceWithEditingContext(editingContext(), null);
    editingContext().insertObject(eo);
    addObjectToBothSidesOfRelationshipWithKey(eo, _Customer.ORDERS_KEY);
    return (org.wocommunity.bl.Order) eo;
  }

  public void deleteOrdersRelationship(org.wocommunity.bl.Order object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, _Customer.ORDERS_KEY);
    editingContext().deleteObject(object);
  }

  public void deleteAllOrdersRelationships() {
    Enumeration<org.wocommunity.bl.Order> objects = orders().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteOrdersRelationship(objects.nextElement());
    }
  }


  public static Customer createCustomer(EOEditingContext editingContext, String email
, String firstName
, String lastName
, er.extensions.crypting.ERXCryptoString password
) {
    Customer eo = (Customer) EOUtilities.createAndInsertInstance(editingContext, _Customer.ENTITY_NAME);    
		eo.setEmail(email);
		eo.setFirstName(firstName);
		eo.setLastName(lastName);
		eo.setPassword(password);
    return eo;
  }

  public static ERXFetchSpecification<Customer> fetchSpecForCustomer() {
    return new ERXFetchSpecification<Customer>(_Customer.ENTITY_NAME, null, null, false, true, null);
  }

  public static NSArray<Customer> fetchAllCustomers(EOEditingContext editingContext) {
    return _Customer.fetchAllCustomers(editingContext, null);
  }

  public static NSArray<Customer> fetchAllCustomers(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _Customer.fetchCustomers(editingContext, null, sortOrderings);
  }

  public static NSArray<Customer> fetchCustomers(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    ERXFetchSpecification<Customer> fetchSpec = new ERXFetchSpecification<Customer>(_Customer.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray<Customer> eoObjects = fetchSpec.fetchObjects(editingContext);
    return eoObjects;
  }

  public static Customer fetchCustomer(EOEditingContext editingContext, String keyName, Object value) {
    return _Customer.fetchCustomer(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static Customer fetchCustomer(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<Customer> eoObjects = _Customer.fetchCustomers(editingContext, qualifier, null);
    Customer eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one Customer that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static Customer fetchRequiredCustomer(EOEditingContext editingContext, String keyName, Object value) {
    return _Customer.fetchRequiredCustomer(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static Customer fetchRequiredCustomer(EOEditingContext editingContext, EOQualifier qualifier) {
    Customer eoObject = _Customer.fetchCustomer(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no Customer that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static Customer localInstanceIn(EOEditingContext editingContext, Customer eo) {
    Customer localInstance = (eo == null) ? null : ERXEOControlUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
}
