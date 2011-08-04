// DO NOT EDIT.  Make changes to ProductCategory.java instead.
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
public abstract class _ProductCategory extends  ERXGenericRecord {
  public static final String ENTITY_NAME = "ProductCategory";

  // Attribute Keys
  public static final ERXKey<String> SHORT_DECRIPTION = new ERXKey<String>("shortDecription");
  // Relationship Keys
  public static final ERXKey<org.wocommunity.bl.Product> PRODUCTS = new ERXKey<org.wocommunity.bl.Product>("products");

  // Attributes
  public static final String SHORT_DECRIPTION_KEY = SHORT_DECRIPTION.key();
  // Relationships
  public static final String PRODUCTS_KEY = PRODUCTS.key();

  private static Logger LOG = Logger.getLogger(_ProductCategory.class);

  public ProductCategory localInstanceIn(EOEditingContext editingContext) {
    ProductCategory localInstance = (ProductCategory)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }

  public String shortDecription() {
    return (String) storedValueForKey(_ProductCategory.SHORT_DECRIPTION_KEY);
  }

  public void setShortDecription(String value) {
    if (_ProductCategory.LOG.isDebugEnabled()) {
    	_ProductCategory.LOG.debug( "updating shortDecription from " + shortDecription() + " to " + value);
    }
    takeStoredValueForKey(value, _ProductCategory.SHORT_DECRIPTION_KEY);
  }

  public NSArray<org.wocommunity.bl.Product> products() {
    return (NSArray<org.wocommunity.bl.Product>)storedValueForKey(_ProductCategory.PRODUCTS_KEY);
  }

  public NSArray<org.wocommunity.bl.Product> products(EOQualifier qualifier) {
    return products(qualifier, null);
  }

  public NSArray<org.wocommunity.bl.Product> products(EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    NSArray<org.wocommunity.bl.Product> results;
      results = products();
      if (qualifier != null) {
        results = (NSArray<org.wocommunity.bl.Product>)EOQualifier.filteredArrayWithQualifier(results, qualifier);
      }
      if (sortOrderings != null) {
        results = (NSArray<org.wocommunity.bl.Product>)EOSortOrdering.sortedArrayUsingKeyOrderArray(results, sortOrderings);
      }
    return results;
  }
  
  public void addToProducts(org.wocommunity.bl.Product object) {
    includeObjectIntoPropertyWithKey(object, _ProductCategory.PRODUCTS_KEY);
  }

  public void removeFromProducts(org.wocommunity.bl.Product object) {
    excludeObjectFromPropertyWithKey(object, _ProductCategory.PRODUCTS_KEY);
  }

  public void addToProductsRelationship(org.wocommunity.bl.Product object) {
    if (_ProductCategory.LOG.isDebugEnabled()) {
      _ProductCategory.LOG.debug("adding " + object + " to products relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	addToProducts(object);
    }
    else {
    	addObjectToBothSidesOfRelationshipWithKey(object, _ProductCategory.PRODUCTS_KEY);
    }
  }

  public void removeFromProductsRelationship(org.wocommunity.bl.Product object) {
    if (_ProductCategory.LOG.isDebugEnabled()) {
      _ProductCategory.LOG.debug("removing " + object + " from products relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	removeFromProducts(object);
    }
    else {
    	removeObjectFromBothSidesOfRelationshipWithKey(object, _ProductCategory.PRODUCTS_KEY);
    }
  }

  public org.wocommunity.bl.Product createProductsRelationship() {
    EOClassDescription eoClassDesc = EOClassDescription.classDescriptionForEntityName( org.wocommunity.bl.Product.ENTITY_NAME );
    EOEnterpriseObject eo = eoClassDesc.createInstanceWithEditingContext(editingContext(), null);
    editingContext().insertObject(eo);
    addObjectToBothSidesOfRelationshipWithKey(eo, _ProductCategory.PRODUCTS_KEY);
    return (org.wocommunity.bl.Product) eo;
  }

  public void deleteProductsRelationship(org.wocommunity.bl.Product object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, _ProductCategory.PRODUCTS_KEY);
    editingContext().deleteObject(object);
  }

  public void deleteAllProductsRelationships() {
    Enumeration<org.wocommunity.bl.Product> objects = products().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteProductsRelationship(objects.nextElement());
    }
  }


  public static ProductCategory createProductCategory(EOEditingContext editingContext, String shortDecription
) {
    ProductCategory eo = (ProductCategory) EOUtilities.createAndInsertInstance(editingContext, _ProductCategory.ENTITY_NAME);    
		eo.setShortDecription(shortDecription);
    return eo;
  }

  public static ERXFetchSpecification<ProductCategory> fetchSpec() {
    return new ERXFetchSpecification<ProductCategory>(_ProductCategory.ENTITY_NAME, null, null, false, true, null);
  }

  public static NSArray<ProductCategory> fetchAllProductCategories(EOEditingContext editingContext) {
    return _ProductCategory.fetchAllProductCategories(editingContext, null);
  }

  public static NSArray<ProductCategory> fetchAllProductCategories(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _ProductCategory.fetchProductCategories(editingContext, null, sortOrderings);
  }

  public static NSArray<ProductCategory> fetchProductCategories(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    ERXFetchSpecification<ProductCategory> fetchSpec = new ERXFetchSpecification<ProductCategory>(_ProductCategory.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray<ProductCategory> eoObjects = fetchSpec.fetchObjects(editingContext);
    return eoObjects;
  }

  public static ProductCategory fetchProductCategory(EOEditingContext editingContext, String keyName, Object value) {
    return _ProductCategory.fetchProductCategory(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static ProductCategory fetchProductCategory(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<ProductCategory> eoObjects = _ProductCategory.fetchProductCategories(editingContext, qualifier, null);
    ProductCategory eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one ProductCategory that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static ProductCategory fetchRequiredProductCategory(EOEditingContext editingContext, String keyName, Object value) {
    return _ProductCategory.fetchRequiredProductCategory(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static ProductCategory fetchRequiredProductCategory(EOEditingContext editingContext, EOQualifier qualifier) {
    ProductCategory eoObject = _ProductCategory.fetchProductCategory(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no ProductCategory that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static ProductCategory localInstanceIn(EOEditingContext editingContext, ProductCategory eo) {
    ProductCategory localInstance = (eo == null) ? null : ERXEOControlUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
}
