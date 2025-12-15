# LiveData with ViewModel Sample

A simple Android application demonstrating the LiveData and ViewModel architecture components pattern using Jetpack Compose.

## Overview

This project showcases how to implement the **MVVM (Model-View-ViewModel)** architecture pattern in Android using:
- **LiveData**: Observable data holder class that is lifecycle-aware
- **ViewModel**: Stores and manages UI-related data in a lifecycle-conscious way
- **Jetpack Compose**: Modern Android UI toolkit

## Features

- ✅ LiveData implementation with ViewModel
- ✅ Lifecycle-aware data observation
- ✅ Jetpack Compose UI
- ✅ Simple button click interaction to update LiveData
- ✅ Proper ViewModelProvider usage

## Architecture

The app follows the MVVM pattern:

```
┌─────────────┐
│   View      │  (MainActivity - Compose UI)
│  (Activity) │
└──────┬──────┘
       │ observes
       ▼
┌─────────────┐
│  ViewModel  │  (NameViewModel)
└──────┬──────┘
       │ manages
       ▼
┌─────────────┐
│  LiveData   │  (MutableLiveData<String?>)
└─────────────┘
```

## Project Structure

```
app/src/main/java/demo/amjadkhan/livedatawithviewmodel/
├── MainActivity.kt          # Main activity with Compose UI
└── NameViewModel.kt         # ViewModel managing LiveData
```

## Key Components

### NameViewModel
- Extends `ViewModel` to store UI-related data
- Contains `MutableLiveData<String?>` to hold the current name
- Provides a getter method to access the LiveData

### MainActivity
- Uses Jetpack Compose for UI
- Observes LiveData changes using `observe()` method
- Updates UI reactively when LiveData changes
- Contains a button to update the name value

## How It Works

1. **ViewModel Creation**: The ViewModel is created using `ViewModelProvider`:
   ```kotlin
   viewModel = ViewModelProvider(this)[NameViewModel::class.java]
   ```

2. **LiveData Observation**: The Activity observes LiveData changes:
   ```kotlin
   viewModel.getCurrentName().observe(this@MainActivity) { name ->
       currentNameOfUser = name ?: "NA"
   }
   ```

3. **Updating LiveData**: When the button is clicked, the LiveData value is updated:
   ```kotlin
   viewModel.getCurrentName().value = "Amjad"
   ```

4. **UI Update**: The Compose UI automatically recomposes when the observed state changes.

## Requirements

- **Minimum SDK**: 24 (Android 7.0)
- **Target SDK**: 36
- **Kotlin**: 2.0.21
- **Gradle**: 8.11.2

## Dependencies

- AndroidX Core KTX
- Jetpack Compose (BOM 2024.09.00)
- Material3
- Lifecycle Runtime KTX
- Activity Compose

## Building the Project

1. Clone the repository
2. Open the project in Android Studio
3. Sync Gradle files
4. Run the app on an emulator or physical device

## Usage

1. Launch the app
2. You'll see "Hello NA!" displayed initially
3. Click the "Click Me" button
4. The text will update to "Hello Amjad!" automatically

## Benefits of This Pattern

- **Lifecycle-aware**: LiveData automatically handles lifecycle events
- **Data persistence**: ViewModel survives configuration changes
- **Separation of concerns**: UI logic separated from business logic
- **Reactive updates**: UI automatically updates when data changes
- **Memory leak prevention**: Observers are automatically removed when lifecycle is destroyed

## Notes

- This is a simple example demonstrating the basic concepts
- In production apps, you might want to use `viewModelScope` with coroutines for async operations
- Consider using `StateFlow` or `Flow` for more advanced reactive programming scenarios

## License

This project is a sample/demo project for educational purposes.

