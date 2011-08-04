// DO NOT EDIT.  Make changes to Supplier.java instead.
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
public abstract class _Supplier extends org.wocommunity.bl.Contact {
  public static final String ENTITY_NAME = "Supplier";

  // Attribute Keys
  public static final ERXKey<String> EMAIL = new ERXKey<String>("email");
  public static final ERXKey<String> FIRST_NAME = new ERXKey<String>("firstName");
  public static final ERXKey<String> LAST_NAME = new ERXKey<String>("lastName");
  public static final ERXKey<er.extensions.crypting.ERXCryptoString> PASSWORD = new ERXKey<er.extensions.crypting.ERXCryptoString>("password");
  public static final ERXKey<NSTimestamp> SUPPLIER_SINCE = new ERXKey<NSTimestamp>("supplierSince");
  // Relationship Keys

  // Attributes
  public static final String EMAIL_KEY = EMAIL.key();
  public static final String FIRST_NAME_KEY = FIRST_NAME.key();
  public static final String LAST_NAME_KEY = LAST_NAME.key();
  public static final String PASSWORD_KEY = PASSWORD.key();
  public static final String SUPPLIER_SINCE_KEY = SUPPLIER_SINCE.key();
  // Relationships

  private static Logger LOG = Logger.getLogger(_Supplier.class);

  public Supplier localInstanceIn(EOEditingContext editingContext) {
    Supplier localInstance = (Supplier)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }

  public NSTimestamp supplierSince() {
    return (NSTimestamp) storedValueForKey(_Supplier.SUPPLIER_SINCE_KEY);
  }

  public void setSupplierSince(NSTimestamp value) {
    if (_Supplier.LOG.isDebugEnabled()) {
    	_Supplier.LOG.debug( "updating supplierSince from " + supplierSince() + " to " + value);
    }
    takeStoredValueForKey(value, _Supplier.SUPPLIER_SINCE_KEY);
  }


  public static Supplier createSupplier(EOEditingContext editingContext, String email
, String firstName
, String lastName
, er.extensions.crypting.ERXCryptoString password
) {
    Supplier eo = (Supplier) EOUtilities.createAndInsertInstance(editingContext, _Supplier.ENTITY_NAME);    
		eo.setEmail(email);
		eo.setFirstName(firstName);
		eo.setLastName(lastName);
		eo.setPassword(password);
    return eo;
  }

  public static ERXFetchSpecification<Supplier> fetchSpecForSupplier() {
    return new ERXFetchSpecification<Supplier>(_Supplier.ENTITY_NAME, null, null, false, true, null);
  }

  public static NSArray<Supplier> fetchAllSuppliers(EOEditingContext editingContext) {
    return _Supplier.fetchAllSuppliers(editingContext, null);
  }

  public static NSArray<Supplier> fetchAllSuppliers(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _Supplier.fetchSuppliers(editingContext, null, sortOrderings);
  }

  public static NSArray<Supplier> fetchSuppliers(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    ERXFetchSpecification<Supplier> fetchSpec = new ERXFetchSpecification<Supplier>(_Supplier.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray<Supplier> eoObjects = fetchSpec.fetchObjects(editingContext);
    return eoObjects;
  }

  public static Supplier fetchSupplier(EOEditingContext editingContext, String keyName, Object value) {
    return _Supplier.fetchSupplier(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static Supplier fetchSupplier(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<Supplier> eoObjects = _Supplier.fetchSuppliers(editingContext, qualifier, null);
    Supplier eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one Supplier that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static Supplier fetchRequiredSupplier(EOEditingContext editingContext, String keyName, Object value) {
    return _Supplier.fetchRequiredSupplier(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static Supplier fetchRequiredSupplier(EOEditingContext editingContext, EOQualifier qualifier) {
    Supplier eoObject = _Supplier.fetchSupplier(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no Supplier that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static Supplier localInstanceIn(EOEditingContext editingContext, Supplier eo) {
    Supplier localInstance = (eo == null) ? null : ERXEOControlUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
}
