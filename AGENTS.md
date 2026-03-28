# Project Agent Profile: Shuttle-Mobile-App

## Purpose
An Android application for managing shuttle passes and passenger tracking. It includes QR code scanning for passenger validation and uses a local Room database for offline-first support.

## Tech Stack
- **UI:** Jetpack Compose (Material 3)
- **Architecture:** MVVM + Clean Architecture (UseCases/Repositories)
- **DI:** Dagger Hilt
- **Networking:** Retrofit + OkHttp + Kotlin Serialization
- **Database:** Room
- **Async:** Coroutines & Flow
- **Media:** CameraX (for QR Scanning)

## Key Files
- `Navigation.kt`: Centralized routing and ViewModel scoping.
- `AppModule.kt`: Dagger Hilt configuration for API and Database.
- `AuthRepositoryImpl.kt`: Handles login/register logic and local user session.
- `API.kt`: Server endpoint configurations.

## Additional Information
- `README.md`: Information about this Project