# WESTERN GOVERNOR UNIVERSITY --- D287 – JAVA FRAMEWORKS

# Digital Express Electronics - Inventory Management System

This Inventory Management System is a customized software application built using the Spring Framework. It has a Java backend and an HTML front-end. The application is designed to help businesses track their inventory efficiently. It allows users to manage products, parts, and their respective quantities.

## Table of Contents
- [Project Description](#project-description)
- [Changes Made](#changes-made)
- [Products and Parts](#products-and-parts)
- [Contributors](#contributors)

## Changes Made

**Parts C to J:**

## **Part C:**
### **CHANGE - mainscreen.html**
Line 12-22: Included a custom style for the store header.
Line 23 - Digital Express Electronics
Line 29 - Welcome to Digital Express Electronics
Line 33 - Shop for computer supplies
Line 68 - Shop Computers and Laptops Products

## **Part D:**
### **CREATE - about.html (HTML content)**

### **INSERT - mainscreen.html**
Line 31 - Learn More About Us

### **CREATE - AboutUsController.java, LINES 57-61**
Controller class for navigating to the about page.

### **INSERT - MainController**
Configuration of controller to be sent to the AboutUs page.

##  **Part E:**
### **INSERT - Bootstrap.java**
Bootstrapping data for the application.

##  **Part F:**
### **CREATE - confirmationbuyproduct.html (HTML content)**
### **CREATE - errorbuyproduct.html (HTML content)**

### **INSERT - mainscreen.html, LINES 96**
Buy Now

### **INSERT - product.java, LINES 108-128**
Method to decrement inventory when buying a product.

### **INSERT - AddProductController.java, LINES 172-187**
Controller method for buying a product.

##  **Part G:**
Adding additional fields to the part entity for maximum and minimum inventory.

### **INSERT - mainscreen.html, LINES 50-51 AND LINES 60-61**
Minimum
Maximum

### **INSERT - Part.java, LINES 44-52**
int minimum;
int maximum;

### **INSERT - InhousePart.java AND OutsourcedPart.java, LINES 18-20**
Adding default values for maximum and minimum.

### **INSERT - InhousePartForm.html AND OutsourcedPartForm.html, LINES 5-50**
Additional text inputs for inventory, minimum, and maximum values.

### **CHANGE - application.properties**
Modify the file path for persistent storage.

### **INSERT - Part.java, LINES 105-111**
Method to validate and adjust inventory limits.

### **INSERT - InhousePartServiceImpl.java AND OutsourcedPartServiceImpl.java, LINE 54**
Validation of inventory limits.

##  **Part H:**
Validation for between or at the maximum and minimum fields.

### **CREATE - PartInventoryMinimumValidator.java**
Validator for minimum inventory.

### **CREATE - ValidPartInventoryMinimum.java**
Annotation for minimum inventory validation.

### **CREATE - PartInventoryValidator.java**
Validator for inventory limits.

### **CREATE - ValidPartInventory.java**
Annotation for inventory limits validation.

##  **Part I:**
### **INSERT - PartTest.java, LINES 160-176**
Unit tests for minimum and maximum inventory.

##  **Part J:**
### Removed Validators

##### **ValidDeletePart (DeletePartValidator):**
Did not get used in final project completition for both the ValidDeletePart and DeletePartValidator. Messages still do appear for deleting associated part.

## Kept Validators

##### **ValidEnufParts (EnufPartsValidator):**
Prevents adding additional product inventory if there isn't enough associated parts inventory.

##### **ValidPartInventory (PartInventoryValidator):**
Prevents adding additional part inventory if it exceeds the specified max.

#####  **ValidPartInventoryMinimum (PartInventoryMinimumValidator):**
Prevents modifying part inventory if the changes put it below the min threshold.

##### **ValidProductPrice (PriceProductValidator):**
Prevents charging less for the product than the sum cost of its associated parts.

