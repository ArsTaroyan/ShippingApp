# ShippingApp

![NPM Version](https://img.shields.io/npm/v/kotlin?style=flat-square&label=kotlin)
![GitHub followers](https://img.shields.io/github/followers/ArsTaroyan?style=flat-square&logo=github)
![Static Badge](https://img.shields.io/badge/android--stiudio-gray?style=flat-square&logo=android&labelColor=grey&color=dark--green) 
[![API](https://img.shields.io/badge/Min%20SDK-24%20[Android%207.0]-blue.svg?style=flat-square)](https://github.com/AndroidSDKSources/android-sdk-sources-list) 
[![Target SDK](https://img.shields.io/badge/Target%20SDK-34%20[Android%2014]-blue.svg?style=flat-square)](https://developer.android.com/about/versions/13)

ShippingApp is an Android application designed to facilitate the management of shipments and inventory for supermarkets. Developed entirely in Kotlin using Android Studio, the app utilizes various Jetpack Compose components for a modern and responsive user interface. The project follows the MVVM architecture pattern, resulting in clean and maintainable code.

## Key Features

- **Inventory Management**: Easily manage and replenish inventory items.
- **Order Recording**: Record and track orders from previous shipments.
- **User-Friendly Interface**: Intuitive and easy-to-use interface for supermarket staff.

## Technologies and Libraries Used

- **Room**:
  - `implementation("androidx.room:room-ktx:2.5.1")`
  - `kapt("androidx.room:room-compiler:2.5.1")`
- **Coroutines**:
  - `implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.5.1")`
- **Navigation**:
  - `implementation("androidx.compose.material:material:1.6.2")`
  - `implementation("androidx.navigation:navigation-compose:2.7.7")`
- **Gson**:
  - `implementation("com.google.code.gson:gson:2.9.0")`
- **Glide**:
  - `implementation("com.github.bumptech.glide:compose:1.0.0-alpha.1")`
- **Hilt**:
  - `implementation("com.google.dagger:hilt-android:2.46.1")`
  - `implementation("androidx.hilt:hilt-navigation-compose:1.0.0-alpha02")`
  - `kapt("com.google.dagger:hilt-compiler:2.46.1")`
- **Preferences DataStore**:
  - `implementation("androidx.datastore:datastore-preferences:1.0.0-alpha04")`

## Installation

1. **Clone the repository**
    ```bash
    git clone https://github.com/ArsTaroyan/ShippingApp.git
    cd Daily
    ```

2. **Open the project**
    Open the project in [Android Studio](https://developer.android.com/studio).

3. **Sync Gradle**
    The project uses Gradle to manage dependencies. Sync Gradle to download all required dependencies.

4. **Run the application**
    Connect your Android device or use an emulator to run the application.

## Project Structure

The project follows MVVM Architecture principles, ensuring modularity and testability of the code. The main modules include:

- **data**: Contains data sources (Room database, SharedPreferences).
- **domain**: Contains business logic (models).
- **presentation**: Contains the user interface (Activity, ViewModel).


## Project Description

ShippingApp was developed to assist supermarkets in managing their inventory and replenishing supplies without the need for manual intervention. The app simplifies the supermarket's workflow by enabling staff to easily replenish products. It also records orders from previous shipments for reference.

![two](https://github.com/ArsTaroyan/ShippingApp/assets/96776103/842e0fe5-adcd-4f3c-8ef2-4408c4495ea7) ![one](https://github.com/ArsTaroyan/ShippingApp/assets/96776103/62aa244f-7763-430f-98de-c0ca39a6e18e) ![three](https://github.com/ArsTaroyan/ShippingApp/assets/96776103/118314d9-7930-4b54-ab24-46ecae1fc929) ![five](https://github.com/ArsTaroyan/ShippingApp/assets/96776103/145816c4-da1a-4eae-a623-6eeec80fab79) ![six](https://github.com/ArsTaroyan/ShippingApp/assets/96776103/a35ab175-7972-478a-83ee-923b0873d5ad) ![for](https://github.com/ArsTaroyan/ShippingApp/assets/96776103/efe9236e-548a-4ff7-9e3b-d8c40ce6f16f)




