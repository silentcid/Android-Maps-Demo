Bottle Rocket Android Maps Guidelines
=====================================

## Google Maps Library for pins hybrid for the first release of Jetpack Compose
Uses a hybrid system where parts of the custom pins and clustering system methods were being used to display pins in clusters in Jetpack Compose. The library was not updated by Google for Jetpack Compose, and was mainly used in Fragments. 

## Retrofit adapter with Kotlin Result
This also uses the Earlier releases of Kotlin Result in a Retrofit Adapter. It uses Kotlin's Result<T> type to wrap API responses in a type-safe way. All Retrofit calls return a Result<T>, allowing clean and centralized handling of both success and error cases:

 ```private fun getYelpBusinesses(latLong: LatLong, radius: Int?) {
        launchIO {
            yelpRepository.getBusinessesByLatLng(latLong, radius)
                .onSuccess { businessList ->
                    yelpBusinessState.value = businessList
                }.handleFailure()
        }
    }
```
Can view some of the code here:
data/src/main/java/com/bottlerocketstudios/mapsdemo/infrastructure/retrofitadapter

## Steps on obtaining an Google Maps API key to run the Android Maps Demo.
1. Get the API Key at https://mapsplatform.google.com and click on get started. (You might need to setup billing).
2. In the console click on the left hamburger menu on the top-most left hand side of the site and choose `API & Services` > `credentials`.
3. Click on Create Credentials found on the top-middle of the website and choose API Key, Copy this API key which you will be using for this demo.
4. On the dialog box click on edit API key. You can choose `None` for the application restrictions if you're only testing out the demo. Otherwise choose Android apps and follow the directions.
5. Choose library from the side menu and click on Maps SDK for Android, on the next screen choose Enable.
   1. If you need the Places API you will also need to locate it from the list of library options and enable this as well.
6. Back in the project locate the `secrets` block from project level build.gradle and follow the directions in adding your key to the app.
   1. Note: Here is the documentation on what the Secrets Gradle plugin is for https://developers.google.com/maps/documentation/android-sdk/secrets-gradle-plugin

## Sets on obtaining a Yelp API Key
1. Sign up for an account at https://www.yelp.com/developers
2. Visit https://www.yelp.com/developers/documentation/v3/get_started
3. Go to Manage App
4. Copy API Key and in local.properties add value `YELP_API_KEY` and add your API key there. 

## Change from AllProjects to DependencyResolutionManagement
From Gradle version 6.8 and up, `allProjects` block is not required to list repositories. Instead list them in the project-level `settings.gradle.kts`. If attempt to add an allProjects block in your gradle file. Gradle will throw an error if dependencyResolutionManagement is present
in the project-level `settings.gradle.kts`. 

