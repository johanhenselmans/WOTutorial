// DO NOT EDIT.  Make changes to Employee.java instead.
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
public abstract class _Employee extends org.wocommunity.bl.Contact {
  public static final String ENTITY_NAME = "Employee";

  // Attribute Keys
  public static final ERXKey<String> EMAIL = new ERXKey<String>("email");
  public static final ERXKey<NSTimestamp> EMPLOYEE_SINCE = new ERXKey<NSTimestamp>("employeeSince");
  public static final ERXKey<String> FIRST_NAME = new ERXKey<String>("firstName");
  public static final ERXKey<String> LAST_NAME = new ERXKey<String>("lastName");
  public static final ERXKey<er.extensions.crypting.ERXCryptoString> PASSWORD = new ERXKey<er.extensions.crypting.ERXCryptoString>("password");
  // Relationship Keys

  // Attributes
  public static final String EMAIL_KEY = EMAIL.key();
  public static final String EMPLOYEE_SINCE_KEY = EMPLOYEE_SINCE.key();
  public static final String FIRST_NAME_KEY = FIRST_NAME.key();
  public static final String LAST_NAME_KEY = LAST_NAME.key();
  public static final String PASSWORD_KEY = PASSWORD.key();
  // Relationships

  private static Logger LOG = Logger.getLogger(_Employee.class);

  public Employee localInstanceIn(EOEditingContext editingContext) {
    Employee localInstance = (Employee)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }

  public NSTimestamp employeeSince() {
    return (NSTimestamp) storedValueForKey(_Employee.EMPLOYEE_SINCE_KEY);
  }

  public void setEmployeeSince(NSTimestamp value) {
    if (_Employee.LOG.isDebugEnabled()) {
    	_Employee.LOG.debug( "updating employeeSince from " + employeeSince() + " to " + value);
    }
    takeStoredValueForKey(value, _Employee.EMPLOYEE_SINCE_KEY);
  }


  public static Employee createEmployee(EOEditingContext editingContext, String email
, String firstName
, String lastName
, er.extensions.crypting.ERXCryptoString password
) {
    Employee eo = (Employee) EOUtilities.createAndInsertInstance(editingContext, _Employee.ENTITY_NAME);    
		eo.setEmail(email);
		eo.setFirstName(firstName);
		eo.setLastName(lastName);
		eo.setPassword(password);
    return eo;
  }

  public static ERXFetchSpecification<Employee> fetchSpecForEmployee() {
    return new ERXFetchSpecification<Employee>(_Employee.ENTITY_NAME, null, null, false, true, null);
  }

  public static NSArray<Employee> fetchAllEmployees(EOEditingContext editingContext) {
    return _Employee.fetchAllEmployees(editingContext, null);
  }

  public static NSArray<Employee> fetchAllEmployees(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _Employee.fetchEmployees(editingContext, null, sortOrderings);
  }

  public static NSArray<Employee> fetchEmployees(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    ERXFetchSpecification<Employee> fetchSpec = new ERXFetchSpecification<Employee>(_Employee.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray<Employee> eoObjects = fetchSpec.fetchObjects(editingContext);
    return eoObjects;
  }

  public static Employee fetchEmployee(EOEditingContext editingContext, String keyName, Object value) {
    return _Employee.fetchEmployee(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static Employee fetchEmployee(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<Employee> eoObjects = _Employee.fetchEmployees(editingContext, qualifier, null);
    Employee eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one Employee that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static Employee fetchRequiredEmployee(EOEditingContext editingContext, String keyName, Object value) {
    return _Employee.fetchRequiredEmployee(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static Employee fetchRequiredEmployee(EOEditingContext editingContext, EOQualifier qualifier) {
    Employee eoObject = _Employee.fetchEmployee(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no Employee that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static Employee localInstanceIn(EOEditingContext editingContext, Employee eo) {
    Employee localInstance = (eo == null) ? null : ERXEOControlUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
}
