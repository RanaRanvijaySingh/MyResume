## Introduction
This application contains all my CV details, separated out in three screens (Home, Companies, and Projects).

## Screenshot
![20190901_192929](https://github.globant.com/storage/user/2250/files/5366b200-ccef-11e9-8341-4ab6f3dd9bc3)

## Architecture
The application is designed on MVVM Pattern following the rules of clean architecture.

The components of the application are as follows:
- View - Contains Activity and Fragments. No logical operation should be included in it. The purpose of this component is to purely populate the UI and listen to user interactions. 
- ViewModel - Contains all your live data that is being observed in the view. Any change in the live data updates the view. Its acts as a delegate between view and your domain layer which are use-cases.
- UI Models - Contains all the data that is supposed to be populated on View. 
- UseCase - Contains the repository and mapper to make the background call and get the data mapped ready for View.
- Repository - Contains all the service calls for getting the data for the application.
