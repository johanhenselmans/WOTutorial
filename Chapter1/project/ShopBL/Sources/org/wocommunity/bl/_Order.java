// DO NOT EDIT.  Make changes to Order.java instead.
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
public abstract class _Order extends  ERXGenericRecord {
  public static final String ENTITY_NAME = "Order";

  // Attribute Keys
  public static final ERXKey<String> BILLADDR1 = new ERXKey<String>("billaddr1");
  public static final ERXKey<String> BILLADDR2 = new ERXKey<String>("billaddr2");
  public static final ERXKey<String> BILLCITY = new ERXKey<String>("billcity");
  public static final ERXKey<String> BILLCOUNTRY = new ERXKey<String>("billcountry");
  public static final ERXKey<String> BILLSTATE = new ERXKey<String>("billstate");
  public static final ERXKey<String> BILLTOFIRSTNAME = new ERXKey<String>("billtofirstname");
  public static final ERXKey<String> BILLTOLASTNAME = new ERXKey<String>("billtolastname");
  public static final ERXKey<String> BILLZIP = new ERXKey<String>("billzip");
  public static final ERXKey<String> CARDTYPE = new ERXKey<String>("cardtype");
  public static final ERXKey<String> COURIER = new ERXKey<String>("courier");
  public static final ERXKey<String> CREDITCARD = new ERXKey<String>("creditcard");
  public static final ERXKey<String> EXPRDATE = new ERXKey<String>("exprdate");
  public static final ERXKey<NSTimestamp> ORDERDATE = new ERXKey<NSTimestamp>("orderdate");
  public static final ERXKey<String> ORDER_NUMBER = new ERXKey<String>("orderNumber");
  public static final ERXKey<Integer> ORDER_PAYDESK_SESION_ID = new ERXKey<Integer>("orderPaydeskSesionId");
  public static final ERXKey<String> SHIPADDR1 = new ERXKey<String>("shipaddr1");
  public static final ERXKey<String> SHIPADDR2 = new ERXKey<String>("shipaddr2");
  public static final ERXKey<String> SHIPCITY = new ERXKey<String>("shipcity");
  public static final ERXKey<String> SHIPCOUNTRY = new ERXKey<String>("shipcountry");
  public static final ERXKey<String> SHIPSTATE = new ERXKey<String>("shipstate");
  public static final ERXKey<String> SHIPTOFIRSTNAME = new ERXKey<String>("shiptofirstname");
  public static final ERXKey<String> SHIPTOLASTNAME = new ERXKey<String>("shiptolastname");
  public static final ERXKey<String> SHIPZIP = new ERXKey<String>("shipzip");
  public static final ERXKey<String> SHORT_DESCRIPTION = new ERXKey<String>("shortDescription");
  // Relationship Keys
  public static final ERXKey<org.wocommunity.bl.Customer> CUSTOMER = new ERXKey<org.wocommunity.bl.Customer>("customer");
  public static final ERXKey<org.wocommunity.bl.OrderItem> ORDER_ITEMS = new ERXKey<org.wocommunity.bl.OrderItem>("orderItems");

  // Attributes
  public static final String BILLADDR1_KEY = BILLADDR1.key();
  public static final String BILLADDR2_KEY = BILLADDR2.key();
  public static final String BILLCITY_KEY = BILLCITY.key();
  public static final String BILLCOUNTRY_KEY = BILLCOUNTRY.key();
  public static final String BILLSTATE_KEY = BILLSTATE.key();
  public static final String BILLTOFIRSTNAME_KEY = BILLTOFIRSTNAME.key();
  public static final String BILLTOLASTNAME_KEY = BILLTOLASTNAME.key();
  public static final String BILLZIP_KEY = BILLZIP.key();
  public static final String CARDTYPE_KEY = CARDTYPE.key();
  public static final String COURIER_KEY = COURIER.key();
  public static final String CREDITCARD_KEY = CREDITCARD.key();
  public static final String EXPRDATE_KEY = EXPRDATE.key();
  public static final String ORDERDATE_KEY = ORDERDATE.key();
  public static final String ORDER_NUMBER_KEY = ORDER_NUMBER.key();
  public static final String ORDER_PAYDESK_SESION_ID_KEY = ORDER_PAYDESK_SESION_ID.key();
  public static final String SHIPADDR1_KEY = SHIPADDR1.key();
  public static final String SHIPADDR2_KEY = SHIPADDR2.key();
  public static final String SHIPCITY_KEY = SHIPCITY.key();
  public static final String SHIPCOUNTRY_KEY = SHIPCOUNTRY.key();
  public static final String SHIPSTATE_KEY = SHIPSTATE.key();
  public static final String SHIPTOFIRSTNAME_KEY = SHIPTOFIRSTNAME.key();
  public static final String SHIPTOLASTNAME_KEY = SHIPTOLASTNAME.key();
  public static final String SHIPZIP_KEY = SHIPZIP.key();
  public static final String SHORT_DESCRIPTION_KEY = SHORT_DESCRIPTION.key();
  // Relationships
  public static final String CUSTOMER_KEY = CUSTOMER.key();
  public static final String ORDER_ITEMS_KEY = ORDER_ITEMS.key();

  private static Logger LOG = Logger.getLogger(_Order.class);

  public Order localInstanceIn(EOEditingContext editingContext) {
    Order localInstance = (Order)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }

  public String billaddr1() {
    return (String) storedValueForKey(_Order.BILLADDR1_KEY);
  }

  public void setBilladdr1(String value) {
    if (_Order.LOG.isDebugEnabled()) {
    	_Order.LOG.debug( "updating billaddr1 from " + billaddr1() + " to " + value);
    }
    takeStoredValueForKey(value, _Order.BILLADDR1_KEY);
  }

  public String billaddr2() {
    return (String) storedValueForKey(_Order.BILLADDR2_KEY);
  }

  public void setBilladdr2(String value) {
    if (_Order.LOG.isDebugEnabled()) {
    	_Order.LOG.debug( "updating billaddr2 from " + billaddr2() + " to " + value);
    }
    takeStoredValueForKey(value, _Order.BILLADDR2_KEY);
  }

  public String billcity() {
    return (String) storedValueForKey(_Order.BILLCITY_KEY);
  }

  public void setBillcity(String value) {
    if (_Order.LOG.isDebugEnabled()) {
    	_Order.LOG.debug( "updating billcity from " + billcity() + " to " + value);
    }
    takeStoredValueForKey(value, _Order.BILLCITY_KEY);
  }

  public String billcountry() {
    return (String) storedValueForKey(_Order.BILLCOUNTRY_KEY);
  }

  public void setBillcountry(String value) {
    if (_Order.LOG.isDebugEnabled()) {
    	_Order.LOG.debug( "updating billcountry from " + billcountry() + " to " + value);
    }
    takeStoredValueForKey(value, _Order.BILLCOUNTRY_KEY);
  }

  public String billstate() {
    return (String) storedValueForKey(_Order.BILLSTATE_KEY);
  }

  public void setBillstate(String value) {
    if (_Order.LOG.isDebugEnabled()) {
    	_Order.LOG.debug( "updating billstate from " + billstate() + " to " + value);
    }
    takeStoredValueForKey(value, _Order.BILLSTATE_KEY);
  }

  public String billtofirstname() {
    return (String) storedValueForKey(_Order.BILLTOFIRSTNAME_KEY);
  }

  public void setBilltofirstname(String value) {
    if (_Order.LOG.isDebugEnabled()) {
    	_Order.LOG.debug( "updating billtofirstname from " + billtofirstname() + " to " + value);
    }
    takeStoredValueForKey(value, _Order.BILLTOFIRSTNAME_KEY);
  }

  public String billtolastname() {
    return (String) storedValueForKey(_Order.BILLTOLASTNAME_KEY);
  }

  public void setBilltolastname(String value) {
    if (_Order.LOG.isDebugEnabled()) {
    	_Order.LOG.debug( "updating billtolastname from " + billtolastname() + " to " + value);
    }
    takeStoredValueForKey(value, _Order.BILLTOLASTNAME_KEY);
  }

  public String billzip() {
    return (String) storedValueForKey(_Order.BILLZIP_KEY);
  }

  public void setBillzip(String value) {
    if (_Order.LOG.isDebugEnabled()) {
    	_Order.LOG.debug( "updating billzip from " + billzip() + " to " + value);
    }
    takeStoredValueForKey(value, _Order.BILLZIP_KEY);
  }

  public String cardtype() {
    return (String) storedValueForKey(_Order.CARDTYPE_KEY);
  }

  public void setCardtype(String value) {
    if (_Order.LOG.isDebugEnabled()) {
    	_Order.LOG.debug( "updating cardtype from " + cardtype() + " to " + value);
    }
    takeStoredValueForKey(value, _Order.CARDTYPE_KEY);
  }

  public String courier() {
    return (String) storedValueForKey(_Order.COURIER_KEY);
  }

  public void setCourier(String value) {
    if (_Order.LOG.isDebugEnabled()) {
    	_Order.LOG.debug( "updating courier from " + courier() + " to " + value);
    }
    takeStoredValueForKey(value, _Order.COURIER_KEY);
  }

  public String creditcard() {
    return (String) storedValueForKey(_Order.CREDITCARD_KEY);
  }

  public void setCreditcard(String value) {
    if (_Order.LOG.isDebugEnabled()) {
    	_Order.LOG.debug( "updating creditcard from " + creditcard() + " to " + value);
    }
    takeStoredValueForKey(value, _Order.CREDITCARD_KEY);
  }

  public String exprdate() {
    return (String) storedValueForKey(_Order.EXPRDATE_KEY);
  }

  public void setExprdate(String value) {
    if (_Order.LOG.isDebugEnabled()) {
    	_Order.LOG.debug( "updating exprdate from " + exprdate() + " to " + value);
    }
    takeStoredValueForKey(value, _Order.EXPRDATE_KEY);
  }

  public NSTimestamp orderdate() {
    return (NSTimestamp) storedValueForKey(_Order.ORDERDATE_KEY);
  }

  public void setOrderdate(NSTimestamp value) {
    if (_Order.LOG.isDebugEnabled()) {
    	_Order.LOG.debug( "updating orderdate from " + orderdate() + " to " + value);
    }
    takeStoredValueForKey(value, _Order.ORDERDATE_KEY);
  }

  public String orderNumber() {
    return (String) storedValueForKey(_Order.ORDER_NUMBER_KEY);
  }

  public void setOrderNumber(String value) {
    if (_Order.LOG.isDebugEnabled()) {
    	_Order.LOG.debug( "updating orderNumber from " + orderNumber() + " to " + value);
    }
    takeStoredValueForKey(value, _Order.ORDER_NUMBER_KEY);
  }

  public Integer orderPaydeskSesionId() {
    return (Integer) storedValueForKey(_Order.ORDER_PAYDESK_SESION_ID_KEY);
  }

  public void setOrderPaydeskSesionId(Integer value) {
    if (_Order.LOG.isDebugEnabled()) {
    	_Order.LOG.debug( "updating orderPaydeskSesionId from " + orderPaydeskSesionId() + " to " + value);
    }
    takeStoredValueForKey(value, _Order.ORDER_PAYDESK_SESION_ID_KEY);
  }

  public String shipaddr1() {
    return (String) storedValueForKey(_Order.SHIPADDR1_KEY);
  }

  public void setShipaddr1(String value) {
    if (_Order.LOG.isDebugEnabled()) {
    	_Order.LOG.debug( "updating shipaddr1 from " + shipaddr1() + " to " + value);
    }
    takeStoredValueForKey(value, _Order.SHIPADDR1_KEY);
  }

  public String shipaddr2() {
    return (String) storedValueForKey(_Order.SHIPADDR2_KEY);
  }

  public void setShipaddr2(String value) {
    if (_Order.LOG.isDebugEnabled()) {
    	_Order.LOG.debug( "updating shipaddr2 from " + shipaddr2() + " to " + value);
    }
    takeStoredValueForKey(value, _Order.SHIPADDR2_KEY);
  }

  public String shipcity() {
    return (String) storedValueForKey(_Order.SHIPCITY_KEY);
  }

  public void setShipcity(String value) {
    if (_Order.LOG.isDebugEnabled()) {
    	_Order.LOG.debug( "updating shipcity from " + shipcity() + " to " + value);
    }
    takeStoredValueForKey(value, _Order.SHIPCITY_KEY);
  }

  public String shipcountry() {
    return (String) storedValueForKey(_Order.SHIPCOUNTRY_KEY);
  }

  public void setShipcountry(String value) {
    if (_Order.LOG.isDebugEnabled()) {
    	_Order.LOG.debug( "updating shipcountry from " + shipcountry() + " to " + value);
    }
    takeStoredValueForKey(value, _Order.SHIPCOUNTRY_KEY);
  }

  public String shipstate() {
    return (String) storedValueForKey(_Order.SHIPSTATE_KEY);
  }

  public void setShipstate(String value) {
    if (_Order.LOG.isDebugEnabled()) {
    	_Order.LOG.debug( "updating shipstate from " + shipstate() + " to " + value);
    }
    takeStoredValueForKey(value, _Order.SHIPSTATE_KEY);
  }

  public String shiptofirstname() {
    return (String) storedValueForKey(_Order.SHIPTOFIRSTNAME_KEY);
  }

  public void setShiptofirstname(String value) {
    if (_Order.LOG.isDebugEnabled()) {
    	_Order.LOG.debug( "updating shiptofirstname from " + shiptofirstname() + " to " + value);
    }
    takeStoredValueForKey(value, _Order.SHIPTOFIRSTNAME_KEY);
  }

  public String shiptolastname() {
    return (String) storedValueForKey(_Order.SHIPTOLASTNAME_KEY);
  }

  public void setShiptolastname(String value) {
    if (_Order.LOG.isDebugEnabled()) {
    	_Order.LOG.debug( "updating shiptolastname from " + shiptolastname() + " to " + value);
    }
    takeStoredValueForKey(value, _Order.SHIPTOLASTNAME_KEY);
  }

  public String shipzip() {
    return (String) storedValueForKey(_Order.SHIPZIP_KEY);
  }

  public void setShipzip(String value) {
    if (_Order.LOG.isDebugEnabled()) {
    	_Order.LOG.debug( "updating shipzip from " + shipzip() + " to " + value);
    }
    takeStoredValueForKey(value, _Order.SHIPZIP_KEY);
  }

  public String shortDescription() {
    return (String) storedValueForKey(_Order.SHORT_DESCRIPTION_KEY);
  }

  public void setShortDescription(String value) {
    if (_Order.LOG.isDebugEnabled()) {
    	_Order.LOG.debug( "updating shortDescription from " + shortDescription() + " to " + value);
    }
    takeStoredValueForKey(value, _Order.SHORT_DESCRIPTION_KEY);
  }

  public org.wocommunity.bl.Customer customer() {
    return (org.wocommunity.bl.Customer)storedValueForKey(_Order.CUSTOMER_KEY);
  }
  
  public void setCustomer(org.wocommunity.bl.Customer value) {
    takeStoredValueForKey(value, _Order.CUSTOMER_KEY);
  }

  public void setCustomerRelationship(org.wocommunity.bl.Customer value) {
    if (_Order.LOG.isDebugEnabled()) {
      _Order.LOG.debug("updating customer from " + customer() + " to " + value);
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	setCustomer(value);
    }
    else if (value == null) {
    	org.wocommunity.bl.Customer oldValue = customer();
    	if (oldValue != null) {
    		removeObjectFromBothSidesOfRelationshipWithKey(oldValue, _Order.CUSTOMER_KEY);
      }
    } else {
    	addObjectToBothSidesOfRelationshipWithKey(value, _Order.CUSTOMER_KEY);
    }
  }
  
  public NSArray<org.wocommunity.bl.OrderItem> orderItems() {
    return (NSArray<org.wocommunity.bl.OrderItem>)storedValueForKey(_Order.ORDER_ITEMS_KEY);
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
      EOQualifier inverseQualifier = new EOKeyValueQualifier(org.wocommunity.bl.OrderItem.ORDER_KEY, EOQualifier.QualifierOperatorEqual, this);
    	
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
    includeObjectIntoPropertyWithKey(object, _Order.ORDER_ITEMS_KEY);
  }

  public void removeFromOrderItems(org.wocommunity.bl.OrderItem object) {
    excludeObjectFromPropertyWithKey(object, _Order.ORDER_ITEMS_KEY);
  }

  public void addToOrderItemsRelationship(org.wocommunity.bl.OrderItem object) {
    if (_Order.LOG.isDebugEnabled()) {
      _Order.LOG.debug("adding " + object + " to orderItems relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	addToOrderItems(object);
    }
    else {
    	addObjectToBothSidesOfRelationshipWithKey(object, _Order.ORDER_ITEMS_KEY);
    }
  }

  public void removeFromOrderItemsRelationship(org.wocommunity.bl.OrderItem object) {
    if (_Order.LOG.isDebugEnabled()) {
      _Order.LOG.debug("removing " + object + " from orderItems relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	removeFromOrderItems(object);
    }
    else {
    	removeObjectFromBothSidesOfRelationshipWithKey(object, _Order.ORDER_ITEMS_KEY);
    }
  }

  public org.wocommunity.bl.OrderItem createOrderItemsRelationship() {
    EOClassDescription eoClassDesc = EOClassDescription.classDescriptionForEntityName( org.wocommunity.bl.OrderItem.ENTITY_NAME );
    EOEnterpriseObject eo = eoClassDesc.createInstanceWithEditingContext(editingContext(), null);
    editingContext().insertObject(eo);
    addObjectToBothSidesOfRelationshipWithKey(eo, _Order.ORDER_ITEMS_KEY);
    return (org.wocommunity.bl.OrderItem) eo;
  }

  public void deleteOrderItemsRelationship(org.wocommunity.bl.OrderItem object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, _Order.ORDER_ITEMS_KEY);
    editingContext().deleteObject(object);
  }

  public void deleteAllOrderItemsRelationships() {
    Enumeration<org.wocommunity.bl.OrderItem> objects = orderItems().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteOrderItemsRelationship(objects.nextElement());
    }
  }


  public static Order createOrder(EOEditingContext editingContext, String orderNumber
, String shortDescription
, org.wocommunity.bl.Customer customer) {
    Order eo = (Order) EOUtilities.createAndInsertInstance(editingContext, _Order.ENTITY_NAME);    
		eo.setOrderNumber(orderNumber);
		eo.setShortDescription(shortDescription);
    eo.setCustomerRelationship(customer);
    return eo;
  }

  public static ERXFetchSpecification<Order> fetchSpec() {
    return new ERXFetchSpecification<Order>(_Order.ENTITY_NAME, null, null, false, true, null);
  }

  public static NSArray<Order> fetchAllOrders(EOEditingContext editingContext) {
    return _Order.fetchAllOrders(editingContext, null);
  }

  public static NSArray<Order> fetchAllOrders(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _Order.fetchOrders(editingContext, null, sortOrderings);
  }

  public static NSArray<Order> fetchOrders(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    ERXFetchSpecification<Order> fetchSpec = new ERXFetchSpecification<Order>(_Order.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray<Order> eoObjects = fetchSpec.fetchObjects(editingContext);
    return eoObjects;
  }

  public static Order fetchOrder(EOEditingContext editingContext, String keyName, Object value) {
    return _Order.fetchOrder(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static Order fetchOrder(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<Order> eoObjects = _Order.fetchOrders(editingContext, qualifier, null);
    Order eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one Order that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static Order fetchRequiredOrder(EOEditingContext editingContext, String keyName, Object value) {
    return _Order.fetchRequiredOrder(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static Order fetchRequiredOrder(EOEditingContext editingContext, EOQualifier qualifier) {
    Order eoObject = _Order.fetchOrder(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no Order that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static Order localInstanceIn(EOEditingContext editingContext, Order eo) {
    Order localInstance = (eo == null) ? null : ERXEOControlUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
}
