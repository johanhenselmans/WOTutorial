package org.wocommunity.bl;

import org.apache.log4j.Logger;

import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.foundation.NSTimestamp;

public class Supplier extends _Supplier {
	@SuppressWarnings("unused")
	private static Logger log = Logger.getLogger(Supplier.class);
	
	  @Override
	  public void awakeFromInsertion(EOEditingContext ec) {
	  	// TODO Auto-generated method stub
	  	super.awakeFromInsertion(ec);
	  	if(supplierSince() == null){
	  		setSupplierSince(new NSTimestamp());
	  	}
	  }
}
