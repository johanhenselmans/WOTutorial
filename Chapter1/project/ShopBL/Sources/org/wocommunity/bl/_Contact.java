// DO NOT EDIT.  Make changes to Contact.java instead.
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
public abstract class _Contact extends  ERXGenericRecord {
  public static final String ENTITY_NAME = "Contact";

  // Attribute Keys
  public static final ERXKey<String> EMAIL = new ERXKey<String>("email");
  public static final ERXKey<String> FIRST_NAME = new ERXKey<String>("firstName");
  public static final ERXKey<String> LAST_NAME = new ERXKey<String>("lastName");
  public static final ERXKey<er.extensions.crypting.ERXCryptoString> PASSWORD = new ERXKey<er.extensions.crypting.ERXCryptoString>("password");
  // Relationship Keys

  // Attributes
  public static final String EMAIL_KEY = EMAIL.key();
  public static final String FIRST_NAME_KEY = FIRST_NAME.key();
  public static final String LAST_NAME_KEY = LAST_NAME.key();
  public static final String PASSWORD_KEY = PASSWORD.key();
  // Relationships

  private static Logger LOG = Logger.getLogger(_Contact.class);

  public Contact localInstanceIn(EOEditingContext editingContext) {
    Contact localInstance = (Contact)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }

  public String email() {
    return (String) storedValueForKey(_Contact.EMAIL_KEY);
  }

  public void setEmail(String value) {
    if (_Contact.LOG.isDebugEnabled()) {
    	_Contact.LOG.debug( "updating email from " + email() + " to " + value);
    }
    takeStoredValueForKey(value, _Contact.EMAIL_KEY);
  }

  public String firstName() {
    return (String) storedValueForKey(_Contact.FIRST_NAME_KEY);
  }

  public void setFirstName(String value) {
    if (_Contact.LOG.isDebugEnabled()) {
    	_Contact.LOG.debug( "updating firstName from " + firstName() + " to " + value);
    }
    takeStoredValueForKey(value, _Contact.FIRST_NAME_KEY);
  }

  public String lastName() {
    return (String) storedValueForKey(_Contact.LAST_NAME_KEY);
  }

  public void setLastName(String value) {
    if (_Contact.LOG.isDebugEnabled()) {
    	_Contact.LOG.debug( "updating lastName from " + lastName() + " to " + value);
    }
    takeStoredValueForKey(value, _Contact.LAST_NAME_KEY);
  }

  public er.extensions.crypting.ERXCryptoString password() {
    return (er.extensions.crypting.ERXCryptoString) storedValueForKey(_Contact.PASSWORD_KEY);
  }

  public void setPassword(er.extensions.crypting.ERXCryptoString value) {
    if (_Contact.LOG.isDebugEnabled()) {
    	_Contact.LOG.debug( "updating password from " + password() + " to " + value);
    }
    takeStoredValueForKey(value, _Contact.PASSWORD_KEY);
  }


  public static Contact createContact(EOEditingContext editingContext, String email
, String firstName
, String lastName
, er.extensions.crypting.ERXCryptoString password
) {
    Contact eo = (Contact) EOUtilities.createAndInsertInstance(editingContext, _Contact.ENTITY_NAME);    
		eo.setEmail(email);
		eo.setFirstName(firstName);
		eo.setLastName(lastName);
		eo.setPassword(password);
    return eo;
  }

  public static ERXFetchSpecification<Contact> fetchSpec() {
    return new ERXFetchSpecification<Contact>(_Contact.ENTITY_NAME, null, null, false, true, null);
  }

  public static NSArray<Contact> fetchAllContacts(EOEditingContext editingContext) {
    return _Contact.fetchAllContacts(editingContext, null);
  }

  public static NSArray<Contact> fetchAllContacts(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _Contact.fetchContacts(editingContext, null, sortOrderings);
  }

  public static NSArray<Contact> fetchContacts(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    ERXFetchSpecification<Contact> fetchSpec = new ERXFetchSpecification<Contact>(_Contact.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray<Contact> eoObjects = fetchSpec.fetchObjects(editingContext);
    return eoObjects;
  }

  public static Contact fetchContact(EOEditingContext editingContext, String keyName, Object value) {
    return _Contact.fetchContact(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static Contact fetchContact(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<Contact> eoObjects = _Contact.fetchContacts(editingContext, qualifier, null);
    Contact eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one Contact that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static Contact fetchRequiredContact(EOEditingContext editingContext, String keyName, Object value) {
    return _Contact.fetchRequiredContact(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static Contact fetchRequiredContact(EOEditingContext editingContext, EOQualifier qualifier) {
    Contact eoObject = _Contact.fetchContact(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no Contact that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static Contact localInstanceIn(EOEditingContext editingContext, Contact eo) {
    Contact localInstance = (eo == null) ? null : ERXEOControlUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
}
