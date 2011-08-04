package org.wocommunity.bl.migration;

import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.foundation.NSArray;

import er.extensions.jdbc.ERXSQLHelper.ColumnIndex;
import er.extensions.migration.ERXMigrationDatabase;
import er.extensions.migration.ERXMigrationIndex;
import er.extensions.migration.ERXMigrationTable;
import er.extensions.migration.ERXModelVersion;

public class ShopBL0 extends ERXMigrationDatabase.Migration {
	@Override
	public NSArray<ERXModelVersion> modelDependencies() {
		return null;
	}
  
	@Override
	public void downgrade(EOEditingContext editingContext, ERXMigrationDatabase database) throws Throwable {
		// DO NOTHING
	}

	@Override
	public void upgrade(EOEditingContext editingContext, ERXMigrationDatabase database) throws Throwable {
		ERXMigrationTable invoiceTable = database.newTableNamed("Invoice");
		invoiceTable.newIntegerColumn("id", false);
		invoiceTable.create();
	 	invoiceTable.setPrimaryKey("id");

		ERXMigrationTable productCategoryProductTable = database.newTableNamed("ProductCategoryProduct");
		productCategoryProductTable.newIntegerColumn("productCategoryId", false);
		productCategoryProductTable.newIntegerColumn("productId", false);
		productCategoryProductTable.create();
	 	productCategoryProductTable.setPrimaryKey("productCategoryId", "productId");

		ERXMigrationTable invoiceItemTable = database.newTableNamed("InvoiceItem");
		invoiceItemTable.newIntegerColumn("id", false);
		invoiceItemTable.newIntegerColumn("invoiceID", false);
		invoiceItemTable.newIntegerColumn("productID", false);
		invoiceItemTable.create();
	 	invoiceItemTable.setPrimaryKey("id");

		ERXMigrationTable productTable = database.newTableNamed("Product");
		productTable.newIntegerColumn("id", false);
		productTable.newBigDecimalColumn("listPrice", 38, 2, false);
		productTable.newStringColumn("shortDescription", 50, false);
		productTable.create();
	 	productTable.setPrimaryKey("id");

		ERXMigrationTable orderTable = database.newTableNamed("order");
		orderTable.newStringColumn("billaddr1", 80, true);
		orderTable.newStringColumn("billaddr2", 80, true);
		orderTable.newStringColumn("billcity", 80, true);
		orderTable.newStringColumn("billcountry", 20, true);
		orderTable.newStringColumn("billstate", 80, true);
		orderTable.newStringColumn("billtofirstname", 80, true);
		orderTable.newStringColumn("billtolastname", 80, true);
		orderTable.newStringColumn("billzip", 20, true);
		orderTable.newStringColumn("cardtype", 80, true);
		orderTable.newStringColumn("courier", 80, true);
		orderTable.newStringColumn("creditcard", 80, true);
		orderTable.newIntegerColumn("customerID", false);
		orderTable.newStringColumn("exprdate", 7, true);
		orderTable.newIntegerColumn("id", false);
		orderTable.newTimestampColumn("orderdate", true);
		orderTable.newStringColumn("orderNumber", 50, false);
		orderTable.newIntegerColumn("orderPaydeskSesionId", true);
		orderTable.newStringColumn("shipaddr1", 80, true);
		orderTable.newStringColumn("shipaddr2", 80, true);
		orderTable.newStringColumn("shipcity", 80, true);
		orderTable.newStringColumn("shipcountry", 20, true);
		orderTable.newStringColumn("shipstate", 80, true);
		orderTable.newStringColumn("shiptofirstname", 80, true);
		orderTable.newStringColumn("shiptolastname", 80, true);
		orderTable.newStringColumn("shipzip", 20, true);
		orderTable.newStringColumn("shortDescription", 50, false);
		orderTable.create();
	 	orderTable.setPrimaryKey("id");

		ERXMigrationTable contactTable = database.newTableNamed("Contact");
		contactTable.newStringColumn("email", 50, false);
		contactTable.newStringColumn("firstName", 50, false);
		contactTable.newIntegerColumn("id", false);
		contactTable.newStringColumn("lastName", 50, false);
		contactTable.newStringColumn("password", 100, false);
		contactTable.create();
	 	contactTable.setPrimaryKey("id");

		ERXMigrationTable orderItemTable = database.newTableNamed("orderitem");
		orderItemTable.newIntegerColumn("id", false);
		orderItemTable.newIntegerColumn("orderID", false);
		orderItemTable.newIntegerColumn("productID", false);
		orderItemTable.create();
	 	orderItemTable.setPrimaryKey("id");

		ERXMigrationTable productCategoryTable = database.newTableNamed("ProductCategory");
		productCategoryTable.newIntegerColumn("id", false);
		productCategoryTable.newStringColumn("shortDecription", 50, false);
		productCategoryTable.create();
	 	productCategoryTable.setPrimaryKey("id");

		ERXMigrationTable employeeTable = database.existingTableNamed("Contact");
		employeeTable.newTimestampColumn("employeeSince", true);

		ERXMigrationTable customerTable = database.existingTableNamed("Contact");
		customerTable.newTimestampColumn("customerSince", true);

		ERXMigrationTable supplierTable = database.existingTableNamed("Contact");
		supplierTable.newTimestampColumn("supplierSince", true);

		productCategoryProductTable.addForeignKey("productId", "Product", "id");
		productCategoryProductTable.addForeignKey("productCategoryId", "ProductCategory", "id");
		invoiceItemTable.addForeignKey("invoiceID", "Invoice", "id");
		invoiceItemTable.addForeignKey("productID", "Product", "id");
		orderTable.addForeignKey("customerID", "Contact", "id");
		orderItemTable.addForeignKey("orderID", "order", "id");
		orderItemTable.addForeignKey("productID", "Product", "id");
	}
}